package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.ActionViewLocal;
import com.campusdual.fs.vista.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCarreraSeleccionarGaraje extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Garaje", "");
    private final Carrera carrera;

    public MenuCarreraSeleccionarGaraje(Carrera carrera) {
        super("Seleccionando Garaje", "Seleccionar Garaje");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        refrescarGarajes(carrera);
        menuViewLocal.setParentView(this);
        menuViewLocal.display();

    }

    public void refrescarGarajes(Carrera carrera) {
        Collection<Garaje> garajes = GarajeDao.getInstance().getGarajes();
        ArrayList<AbstractView> garagesMenu = new ArrayList<>();
        for (Garaje garaje : garajes) {
            garagesMenu.add(new ActionCarreraEstablecerGaraje(this, carrera, garaje));
        }
        menuViewLocal.setMenuItems(garagesMenu);
    }
}
