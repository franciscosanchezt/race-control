package com.campusdual.fs.vista.coche;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionCocheEliminarGaraje extends ActionViewLocal {

    private final Coche coche;

    public ActionCocheEliminarGaraje(Coche coche) {
        super("Eliminando el Garaje del Coche: " + coche.toCompactString(), "Eliminar Garaje");
        this.coche = coche;
    }

    @Override
    public void executeCustomAction() {
        if (coche.getGaraje() == null) {
            this.println("Este coche no tiene garaje asignado.");
            this.actionFailed();
        } else {
            boolean confirm = this.confirmDialog("Deseas retirar este coche del garaje: " + coche.getGaraje().getNombre());
            if (confirm) {
                coche.getGaraje().getCoches().remove(coche);
                coche.setGaraje(null);
                this.actionSuccessful();
            } else
                this.actionCanceled();
        }
    }
}
