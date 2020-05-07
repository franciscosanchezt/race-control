package com.campusdual.fs.vista.persistencia;

import com.campusdual.fs.App;
import com.campusdual.fs.vista.local.MenuViewLocal;
import java.nio.file.Paths;

public class MenuPersistencia extends MenuViewLocal {

    public MenuPersistencia() {
        super("Persistencia de datos", "Persistencia de datos");
        this.addMenuItem(new ActionPersistenciaGuardar(Paths.get(App.defaultPath)));
        this.addMenuItem(new ActionPersistenciaGuardar());
        this.addMenuItem(new ActionPersistenciaCargar());
    }
}
