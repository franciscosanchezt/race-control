package com.campusdual.fs.vista.coche;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionCocheSeleccionarGaraje extends ActionViewLocal {

    private final Coche coche;
    private final Garaje garaje;

    public ActionCocheSeleccionarGaraje(AbstractView parent, Coche coche, Garaje garaje) {
        super("Registrando coche en garaje", garaje.getNombre());
        this.coche  = coche;
        this.garaje = garaje;
        setParentView(parent);
    }

    @Override
    public void executeCustomAction() {
        boolean confirm = confirmDialog("Deseas registrar el coche " + coche.toCompactString() + " en el garaje " + garaje.getNombre());
        if (confirm) {
            coche.setGaraje(garaje);
            garaje.getCoches().add(coche);
        } else
            actionCanceled();
    }
}
