package com.campusdual.fs.vista;

public class MenuCoches extends MenuViewLocal {

    public MenuCoches() {
        super("Gestionando Coches", "Gestor de Coches");
        this.addMenuItem(new ActionCocheLista());
        this.addMenuItem(new ActionCocheAgregar());
    }
}
