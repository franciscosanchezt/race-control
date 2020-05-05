package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Garaje;
import java.util.Collection;
import java.util.HashMap;

public class GarajeDao {

    //Singleton instance
    private static GarajeDao instance;

    private GarajeDao() {
    }

    public static GarajeDao getInstance() {
        if (instance == null) {
            synchronized (GarajeDao.class) {
                if (instance == null) {
                    instance = new GarajeDao();
                }
            }
        }
        return instance;
    }

    private int siguienteId = 0;
    private final HashMap<Integer, Garaje> garajes = new HashMap<>();

    public void insertarGaraje(String nombre) {
        garajes.put(siguienteId, new Garaje(siguienteId, nombre));
        siguienteId++;
    }

    public Collection<Garaje> getGarajes() {
        return garajes.values();
    }


}
