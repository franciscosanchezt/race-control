package com.campusdual.fs.vista.persistencia;

import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuPersistencia extends MenuViewLocal {

    public MenuPersistencia() {
        super("Persistencia de datos", "Persistencia de datos");
        this.addMenuItem(new ActionPersistenciaGuardar());
        this.addMenuItem(new ActionPersistenciaCargar());
    }
}
