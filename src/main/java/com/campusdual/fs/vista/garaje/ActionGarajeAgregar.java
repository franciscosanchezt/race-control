package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionGarajeAgregar extends ActionViewLocal {

    public ActionGarajeAgregar() {
        super("Creando Nuevo Garaje", "Crear Garaje");
    }

    @Override
    public void executeCustomAction() {
        String nombre = this.prompt("Introduce el nombre del Garaje: ", String.class);
        if (nombre.length() > 0) {
            GarajeDao.getInstance().insertarGaraje(nombre);
            this.actionSuccessful();
        } else
            actionFailed();
    }
}
