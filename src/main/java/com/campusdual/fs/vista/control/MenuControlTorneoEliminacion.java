package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.torneo.ActionTorneoAgregar;
import com.campusdual.fs.vista.torneo.ActionTorneoDescartar;

public class MenuControlTorneoEliminacion extends MenuViewLocal {

    Torneo torneoEliminacion = TorneoDao.getInstance().getTorneoEliminacion();

    public MenuControlTorneoEliminacion() {
        super("Torneo de Eliminacion", "");
        setNameInParentMenu("Torneo Eliminacion: " + (torneoEliminacion == null ? "-" : torneoEliminacion.getNombre()));
        if (torneoEliminacion == null)
            this.addMenuItem(new ActionTorneoAgregar(TipoDeCompeticion.ELIMINACION));
        else
            this.addMenuItem(new ActionTorneoDescartar(TipoDeCompeticion.ELIMINACION));
    }
}
