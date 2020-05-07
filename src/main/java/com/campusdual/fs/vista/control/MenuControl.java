package com.campusdual.fs.vista.control;

import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuControl extends MenuViewLocal {

    public MenuControl() {
        super("Controlador de Carreras", "Controlador de Carreras");
        this.addMenuItem(new MenuControlTorneoEstandar());
        this.addMenuItem(new MenuControlTorneoEliminacion());
    }


}
