package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuGarajes extends MenuViewLocal {

    public MenuGarajes() {
        super("Gestionando Garages", "Gestor de Garages");
        this.addMenuItem(new ActionGarajeLista());
        this.addMenuItem(new ActionGarajeAgregar());
        this.addMenuItem(new MenuGarajesLista());
    }
}
