package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.torneo.ActionTorneoAgregar;
import com.campusdual.fs.vista.torneo.ActionTorneoDescartar;

public class MenuControlTorneoEstandar extends MenuViewLocal {

    Torneo torneoEstandar = TorneoDao.getInstance().getTorneoEstandar();

    public MenuControlTorneoEstandar() {
        super("Torneo de Estandar", "");
        setNameInParentMenu("Torneo Estandar: " + (torneoEstandar == null ? "-" : torneoEstandar.getNombre()));
        if (torneoEstandar == null)
            this.addMenuItem(new ActionTorneoAgregar(TipoDeCompeticion.ESTANDAR));
        else {
            this.addMenuItem(new ActionTorneoDescartar(TipoDeCompeticion.ESTANDAR));
        }

    }
}
