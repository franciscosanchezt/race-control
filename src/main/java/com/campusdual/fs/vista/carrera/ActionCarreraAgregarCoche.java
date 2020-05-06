package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionCarreraAgregarCoche extends ActionViewLocal {

    private final Carrera carrera;
    private final Coche coche;

    public ActionCarreraAgregarCoche(AbstractView parent, Carrera carrera, Coche coche) {
        super("Agregar Coche de la Carrera " + carrera.getNombre(), coche.toCompactString());
        this.carrera = carrera;
        this.coche   = coche;
    }

    @Override
    public void executeCustomAction() {
        boolean confirm = confirmDialog("Deseas agregar el coche " + coche.toCompactString() + "de la Carrera " + carrera.getNombre() + " ?");
        if (confirm) {
            carrera.getParticipantes().add(coche);
            actionSuccessful();
        } else
            actionCanceled();
    }
}
