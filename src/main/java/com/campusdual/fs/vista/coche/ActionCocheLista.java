package com.campusdual.fs.vista.coche;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.util.Collection;

public class ActionCocheLista extends ActionViewLocal {

    public ActionCocheLista() {
        super("Listado de Coches", "Listado de Coches");
    }

    @Override
    public void executeCustomAction() {
        Collection<Coche> coches = CocheDao.getInstance().getCoches();
        coches.forEach(coche -> println(coche));
    }
}
