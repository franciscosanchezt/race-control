package com.campusdual.fs.vista;

public class MenuGarajes extends MenuViewLocal {

    public MenuGarajes() {
        super("Gestionando Garages", "Gestor de Garages");
        this.addMenuItem(new ActionGarajeLista());
        this.addMenuItem(new ActionGarajeAgregar());
    }
}
