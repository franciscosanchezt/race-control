package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionCarreraEliminarCoche extends ActionViewLocal {

    private final Carrera carrera;
    private final Coche coche;

    public ActionCarreraEliminarCoche(AbstractView parent, Carrera carrera, Coche coche) {
        super("Eliminar Coche de la Carrera " + carrera.getNombre(), coche.toCompactString());
        this.carrera = carrera;
        this.coche   = coche;
    }

    @Override
    public void executeCustomAction() {
        boolean confirm = confirmDialog("Deseas eliminar el coche " + coche.toCompactString() + "de la Carrera " + carrera.getNombre() + " ?");
        if (confirm) {
            carrera.getParticipantes().remove(coche);
            actionSuccessful();
        } else
            actionCanceled();

    }
}
