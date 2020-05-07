package com.campusdual.fs.vista.torneo;

import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.IRefreshable;

public class ActionTorneoAgregar extends ActionViewLocal {

    private IRefreshable parent;
    private TipoDeCompeticion tipoDeCompeticion;

    public ActionTorneoAgregar() {
        super("Creando Nuevo Torneo", "Crear Torneo");
    }

    public ActionTorneoAgregar(IRefreshable parent, TipoDeCompeticion tipoDeCompeticion) {
        this();
        this.parent            = parent;
        this.tipoDeCompeticion = tipoDeCompeticion;
    }

    @Override
    public void executeCustomAction() {
        String nombre = this.prompt("Introduce el nombre del Torneo: ", String.class);
        if (nombre.length() > 0) {
            if (tipoDeCompeticion == null) {
                boolean estandar = confirmDialog("Torneo Estandar?");
                tipoDeCompeticion = estandar ? TipoDeCompeticion.ESTANDAR : TipoDeCompeticion.ELIMINACION;
            }
            Torneo torneo = new Torneo(nombre, tipoDeCompeticion);
            boolean created = false;
            if (tipoDeCompeticion == TipoDeCompeticion.ESTANDAR) {
                if (TorneoDao.getInstance().getTorneoEstandar() == null) {
                    TorneoDao.getInstance().setTorneoEstandar(torneo);
                    created = true;
                } else {
                    println("Ya hay un torneo de ese tipo.");
                    actionFailed();
                }
            } else {
                if (TorneoDao.getInstance().getTorneoEliminacion() == null) {
                    TorneoDao.getInstance().setTorneoEliminacion(torneo);
                    created = true;
                } else {
                    println("Ya hay un torneo de ese tipo.");
                    actionFailed();
                }
            }
            if (created) {
                println("Creando las 10 carreras del torneo");
                for (int i = 0; i < 10; i++) {
                    String nombreCarrera = prompt("Introduce el nombre de la carrera #" + (i + 1), String.class);
                    torneo.getCarreras()[i] = CarreraDao.getInstance().insertarCarrera(nombreCarrera, torneo.getTipoDeCompeticion());
                }
                if (parent != null)
                    parent.refreshView();
            }
        } else
            actionFailed();
    }
}
