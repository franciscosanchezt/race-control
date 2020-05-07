package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.torneo.ActionTorneoAgregar;
import com.campusdual.fs.vista.torneo.ActionTorneoDescartar;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;

public class MenuControlTorneoEstandar extends MenuViewLocal {

    Torneo torneoEstandar = null;

    public MenuControlTorneoEstandar() {
        super("Torneo Estandar", "Torneo Estandar");
        refreshView();
    }

    @Override
    public void refreshView() {
        this.setMenuItems(new ArrayList<AbstractView>());
        torneoEstandar = TorneoDao.getInstance().getTorneoEstandar();
        if (torneoEstandar == null)
            this.addMenuItem(new ActionTorneoAgregar(this, TipoDeCompeticion.ESTANDAR));
        else {
            this.addMenuItem(new ActionTorneoDescartar(this, TipoDeCompeticion.ESTANDAR));
            println("Torneo: " + torneoEstandar.getNombre());
            println("Torneo tipo: " + torneoEstandar.getTipoDeCompeticion());
        }
    }
}
