package com.campusdual.fs.vista.torneo;

import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.IRefreshable;

public class ActionTorneoDescartar extends ActionViewLocal {

    private IRefreshable parent;
    private TipoDeCompeticion tipoDeCompeticion;

    public ActionTorneoDescartar() {
        super("Descartar Nuevo Torneo", "Descatando Torneo");
    }

    public ActionTorneoDescartar(IRefreshable parent, TipoDeCompeticion tipoDeCompeticion) {
        this();
        this.parent            = parent;
        this.tipoDeCompeticion = tipoDeCompeticion;
        this.setNameInParentMenu(tipoDeCompeticion == TipoDeCompeticion.ESTANDAR ? "Descartar Torneo Estandar" : "Descartar Torneo Eliminacion");
    }

    @Override
    public void executeCustomAction() {
        if (tipoDeCompeticion == null) {
            boolean estandar = confirmDialog("Descartar Torneo Estandar?");
            tipoDeCompeticion = estandar ? TipoDeCompeticion.ESTANDAR : TipoDeCompeticion.ELIMINACION;
        }
        boolean confirm = confirmDialog("Deseas Descartar el torneo " + (tipoDeCompeticion == TipoDeCompeticion.ESTANDAR ? "Estandar" : "Eliminacion"));
        if (confirm) {
            TorneoDao.getInstance().descartarTorneo(tipoDeCompeticion);

            if (parent != null)
                parent.refreshView();
        }
    }
}
