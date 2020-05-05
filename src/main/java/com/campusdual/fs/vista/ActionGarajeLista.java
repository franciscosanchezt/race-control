package com.campusdual.fs.vista;

import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.modelo.Garaje;
import java.util.Collection;

public class ActionGarajeLista extends ActionViewLocal {

    public ActionGarajeLista() {
        super("Listado de Garajes", "Listado de Garajes");
    }

    @Override
    public void executeCustomAction() {
        Collection<Garaje> garajes = GarajeDao.getInstance().getGarajes();
        garajes.forEach(garaje -> println(garaje));
    }
}
