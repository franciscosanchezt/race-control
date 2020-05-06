package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.vista.MenuViewLocal;

public class MenuCarreras extends MenuViewLocal {

    public MenuCarreras() {
        super("Gestionar Carreras", "Gestion de Carreras");
        this.addMenuItem(new ActionCarreraLista());
        this.addMenuItem(new ActionCarreraAgregar());
    }
}
