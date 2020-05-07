package com.campusdual.fs.vista.torneo;

import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuTorneos extends MenuViewLocal {

    public MenuTorneos() {
        super("Gestionando Torneos", "Gestor de Torneos");
        this.addMenuItem(new ActionTorneosLista());
        this.addMenuItem(new ActionTorneoAgregar());
        this.addMenuItem(new ActionTorneoDescartar(TipoDeCompeticion.ESTANDAR));
        this.addMenuItem(new ActionTorneoDescartar(TipoDeCompeticion.ELIMINACION));
    }
}
