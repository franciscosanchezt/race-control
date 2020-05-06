package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionCarreraEstablecerGaraje extends ActionViewLocal {

    private final Carrera carrera;
    private final Garaje garaje;

    public ActionCarreraEstablecerGaraje(AbstractView parent, Carrera carrera, Garaje garaje) {
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
