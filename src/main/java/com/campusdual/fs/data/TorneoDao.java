package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Torneo;

public class TorneoDao {

    //Singleton instance
    private static TorneoDao instance;

    private TorneoDao() {
    }

    public static TorneoDao getInstance() {
        if (instance == null) {
            synchronized (TorneoDao.class) {
                if (instance == null) {
                    instance = new TorneoDao();
                }
            }
        }
        return instance;
    }

    private Torneo torneoEstandar;
    private Torneo torneoEliminacion;

    public Torneo getTorneoEstandar() {
        return torneoEstandar;
    }

    public void setTorneoEstandar(Torneo torneoEstandar) {
        this.torneoEstandar = torneoEstandar;
    }

    public Torneo getTorneoEliminacion() {
        return torneoEliminacion;
    }

    public void setTorneoEliminacion(Torneo torneoEliminacion) {
        this.torneoEliminacion = torneoEliminacion;
    }


}
