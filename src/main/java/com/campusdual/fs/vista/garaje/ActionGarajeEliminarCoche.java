package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionGarajeEliminarCoche extends ActionViewLocal {

    private final Garaje garaje;
    private final Coche coche;

    public ActionGarajeEliminarCoche(AbstractView parent, Garaje garaje, Coche coche) {
        super("Eliminando registro de coche", coche.toCompactString());
        this.garaje = garaje;
        this.coche  = coche;
        setParentView(parent);
    }

    @Override
    public void executeCustomAction() {
        boolean confirm = this.confirmDialog("Deseas eliminar el registro del coche " + coche.toCompactString() + " del garaje " + garaje.getNombre());
        if (confirm) {
            coche.setGaraje(null);
            garaje.getCoches().remove(coche);
        } else
            this.actionCanceled();

    }
}
