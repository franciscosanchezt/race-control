package com.campusdual.fs.vista.torneo;


import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionTorneosLista extends ActionViewLocal {

    public ActionTorneosLista() {
        super("Listado de Torneos", "Listado de Torneos");
    }

    @Override
    public void executeCustomAction() {
        println(TorneoDao.getInstance().getTorneoEstandar());
        println(TorneoDao.getInstance().getTorneoEliminacion());
    }
}
