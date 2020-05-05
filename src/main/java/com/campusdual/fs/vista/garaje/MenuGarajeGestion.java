package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.MenuViewLocal;

public class MenuGarajeGestion extends MenuViewLocal {

    private final MenuGarajesGestion parent;
    private final Garaje garaje;

    public MenuGarajeGestion(MenuGarajesGestion parent, Garaje garaje) {
        super("Gestionando Garage: " + garaje.getNombre(), garaje.getNombre());
        this.parent = parent;
        this.garaje = garaje;
        this.addMenuItem(new ActionGarajeRenombrar(this, this.garaje));
        this.addMenuItem(new MenuGarajeRegistrarCoches(this, this.garaje));
        this.setParentView(parent);
    }

    public void refrescarGaraje() {
        setRunningTitle("Gestionando Garage: " + garaje.getNombre());
        setNameInParentMenu(garaje.getNombre());
        parent.refrescarGarajes();
    }
}
