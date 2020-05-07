package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionCarreraRenombrar extends ActionViewLocal {

    private final MenuCarreraGestion parent;
    private final Carrera carrera;

    public ActionCarreraRenombrar(MenuCarreraGestion parent, Carrera carrera) {
        super("Renombrando Garaje: " + carrera.getNombre(), "Cambiar Nombre");
        this.parent  = parent;
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        String nuevoNombre = this.prompt("Nuevo Nombre: ", String.class);
        if (nuevoNombre.length() > 0) {
            this.carrera.setNombre(nuevoNombre);
            this.parent.refreshView();
            this.actionSuccessful();
        } else
            actionFailed();
    }
}
