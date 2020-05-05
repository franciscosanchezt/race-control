package com.campusdual.fs.vista.coche;

import com.campusdual.fs.vista.MenuViewLocal;

public class MenuCoches extends MenuViewLocal {

    public MenuCoches() {
        super("Gestionando Coches", "Gestor de Coches");
        this.addMenuItem(new ActionCocheLista());
        this.addMenuItem(new ActionCocheAgregar());
        this.addMenuItem(new MenuCochesLista());
    }
}
