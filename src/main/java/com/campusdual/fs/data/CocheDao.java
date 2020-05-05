package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Coche;
import java.util.Collection;
import java.util.HashMap;

public class CocheDao {

    //Singleton instance
    private static CocheDao instance;

    private CocheDao() {
    }

    public static CocheDao getInstance() {
        if (instance == null) {
            synchronized (CocheDao.class) {
                if (instance == null) {
                    instance = new CocheDao();
                }
            }
        }
        return instance;
    }

    private int siguienteId = 0;
    private final HashMap<Integer, Coche> coches = new HashMap<>();

    public void insertarCoche(String marca, String modelo) {
        coches.put(siguienteId, new Coche(siguienteId, marca, modelo));
        siguienteId++;
    }

    public Collection<Coche> getCoches() {
        return coches.values();
    }


}
