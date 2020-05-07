package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.torneo.ActionTorneoAgregar;
import com.campusdual.fs.vista.torneo.ActionTorneoDescartar;

public class MenuControlTorneoEliminacion extends MenuViewLocal {

    Torneo torneoEliminacion = null;

    public MenuControlTorneoEliminacion() {
        super("Torneo de Eliminacion", "Torneo Eliminacion");
        torneoEliminacion = TorneoDao.getInstance().getTorneoEliminacion();
        if (torneoEliminacion == null)
            this.addMenuItem(new ActionTorneoAgregar(TipoDeCompeticion.ELIMINACION));
        else
            this.addMenuItem(new ActionTorneoDescartar(TipoDeCompeticion.ELIMINACION));
    }
}
