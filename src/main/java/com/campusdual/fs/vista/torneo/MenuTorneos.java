package com.campusdual.fs.vista.torneo;

import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuTorneos extends MenuViewLocal {

    public MenuTorneos() {
        super("Gestionando Torneos", "Gestor de Torneos");
        this.addMenuItem(new ActionTorneosLista());
        this.addMenuItem(new ActionTorneoAgregar());
    }
}
