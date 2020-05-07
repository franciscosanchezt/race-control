package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import io.bretty.console.view.AbstractView;

public class ActionGarajeRegistrarCoche extends ActionViewLocal {

    private final AbstractView parent;
    private final Garaje garaje;
    private final Coche coche;

    public ActionGarajeRegistrarCoche(AbstractView parent, Garaje garaje, Coche coche) {
        super("Registrando coche en el garaje: " + garaje.getNombre(), "(" + coche.getId() + ") " + coche.getMarca() + ", " + coche.getModelo());
        this.parent = parent;
        this.garaje = garaje;
        this.coche  = coche;
        this.setParentView(parent);
    }

    @Override
    public void executeCustomAction() {
        boolean confirm = this.confirmDialog("Confirmacion de Registro\n Deseas registrar el coche: (" + coche.getId() + ") " + coche.getMarca() + ", " + coche.getModelo());
        if (confirm) {
            this.coche.setGaraje(garaje);
            this.garaje.getCoches().add(coche);
            this.actionSuccessful();
        } else
            this.actionCanceled();
    }
}
