package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.ActionViewLocal;
import java.util.Collection;

public class ActionCarreraLista extends ActionViewLocal {

    public ActionCarreraLista() {
        super("Listado de Carreras", "Listado de Carreras");
    }

    @Override
    public void executeCustomAction() {
        Collection<Carrera> carreras = CarreraDao.getInstance().getCarreras();
        carreras.forEach(coche -> println(coche));
    }
}
