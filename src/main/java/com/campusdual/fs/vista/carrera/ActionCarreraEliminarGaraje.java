package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionCarreraEliminarGaraje extends ActionViewLocal {

    private final Carrera carrera;

    public ActionCarreraEliminarGaraje(Carrera carrera) {
        super("Eliminar Garaje", "Eliminar Garaje");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        if (carrera.getGaraje() != null) {
            boolean confirm = confirmDialog("Deseas dejar la carrera sin garaje registrado?");
            if (confirm) {
                carrera.setGaraje(null);
                actionSuccessful();
            }
        } else
            actionFailed();
    }
}
