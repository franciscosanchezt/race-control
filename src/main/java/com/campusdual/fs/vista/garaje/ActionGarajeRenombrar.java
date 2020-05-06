package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionGarajeRenombrar extends ActionViewLocal {

    private final MenuGarajeGestion parent;
    private final Garaje garaje;

    public ActionGarajeRenombrar(MenuGarajeGestion parent, Garaje garaje) {
        super("Renombrando Garaje: " + garaje.getNombre(), "Cambiar Nombre");
        this.parent = parent;
        this.garaje = garaje;
    }

    @Override
    public void executeCustomAction() {
        String nuevoNombre = this.prompt("Nuevo Nombre: ", String.class);
        if (nuevoNombre.length() > 0) {
            this.garaje.setNombre(nuevoNombre);
            this.parent.refrescarGaraje();
            this.actionSuccessful();
        } else
            actionFailed();
    }
}
