package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Carrera.TipoDeCarrera;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.ActionViewLocal;
import com.campusdual.fs.vista.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class ActionCarreraAgregar extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Garaje", "");

    public ActionCarreraAgregar() {
        super("Agregando nueva Carrera", "Agregar Carrera");
    }

    @Override
    public void executeCustomAction() {
        String nombre = this.prompt("Introduce el nombre de la Carrera: ", String.class);
        if (nombre.length() > 0) {
            boolean estandar = confirmDialog("Carrera estandar?");
            Carrera carrera = CarreraDao.getInstance().insertarCarrera(nombre, (estandar ? TipoDeCarrera.ESTANDAR : TipoDeCarrera.ELIMINACION));
            refrescarGarajes(carrera);
            menuViewLocal.setParentView(this);
            menuViewLocal.display();
            println("Carrera: " + nombre + ", Tipo: " + (estandar ? "Estandar" : "Eliminacion"));
        }
    }

    public void refrescarGarajes(Carrera carrera) {
        Collection<Garaje> garajes = GarajeDao.getInstance().getGarajes();
        ArrayList<AbstractView> garagesMenu = new ArrayList<>();
        for (Garaje garaje : garajes) {
            garagesMenu.add(new ActionCarreraSeleccionarGaraje(this, carrera, garaje));
        }
        menuViewLocal.setMenuItems(garagesMenu);
    }

    private class ActionCarreraSeleccionarGaraje extends ActionViewLocal {

        private final Carrera carrera;
        private final Garaje garaje;

        public ActionCarreraSeleccionarGaraje(ActionCarreraAgregar parent, Carrera carrera, Garaje garaje) {
            super("Selecciona un Garaje", garaje.getNombre());
            this.carrera = carrera;
            this.garaje  = garaje;
            this.setParentView(parent);
        }

        @Override
        public void executeCustomAction() {
            if (garaje == null) {
                this.println("Garaje no seleccionado");
            } else
                carrera.setGaraje(garaje);
            actionSuccessful();
        }
    }
}
