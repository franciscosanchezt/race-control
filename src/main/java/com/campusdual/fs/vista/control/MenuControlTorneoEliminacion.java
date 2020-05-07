package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.torneo.ActionTorneoAgregar;
import com.campusdual.fs.vista.torneo.ActionTorneoDescartar;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;

public class MenuControlTorneoEliminacion extends MenuViewLocal {

    Torneo torneoEliminacion = null;

    public MenuControlTorneoEliminacion() {
        super("Torneo de Eliminacion", "Torneo Eliminacion");
        refreshView();
    }

    @Override
    public void refreshView() {
        this.setMenuItems(new ArrayList<AbstractView>());
        torneoEliminacion = TorneoDao.getInstance().getTorneoEliminacion();
        if (torneoEliminacion == null)
            this.addMenuItem(new ActionTorneoAgregar(this, TipoDeCompeticion.ELIMINACION));
        else {
            println("Torneo: " + torneoEliminacion.getNombre());
            println("Torneo tipo: " + torneoEliminacion.getTipoDeCompeticion());
            this.addMenuItem(new ActionTorneoDescartar(this, TipoDeCompeticion.ELIMINACION));
            this.addMenuItem(new ActionTorneoSimulacion(torneoEliminacion));
        }
    }
}
