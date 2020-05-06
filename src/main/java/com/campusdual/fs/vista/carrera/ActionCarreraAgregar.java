package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Carrera.TipoDeCarrera;
import com.campusdual.fs.vista.ActionViewLocal;

public class ActionCarreraAgregar extends ActionViewLocal {


    public ActionCarreraAgregar() {
        super("Agregando nueva Carrera", "Agregar Carrera");
    }

    @Override
    public void executeCustomAction() {
        String nombre = this.prompt("Introduce el nombre de la Carrera: ", String.class);
        if (nombre.length() > 0) {
            boolean estandar = confirmDialog("Carrera estandar?");
            Carrera carrera = CarreraDao.getInstance().insertarCarrera(nombre, (estandar ? TipoDeCarrera.ESTANDAR : TipoDeCarrera.ELIMINACION));

            println("Carrera: " + nombre + ", Tipo: " + (estandar ? "Estandar" : "Eliminacion"));
        }
    }


}
