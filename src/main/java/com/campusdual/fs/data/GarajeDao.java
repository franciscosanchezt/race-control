package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Garaje;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class GarajeDao implements Serializable {

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
    private HashMap<Integer, Garaje> garajes = new HashMap<>();

    public void insertarGaraje(String nombre) {
        garajes.put(siguienteId, new Garaje(siguienteId, nombre));
        siguienteId++;
    }

    public Collection<Garaje> getGarajes() {
        return garajes.values();
    }


    int getSiguienteId() {
        return siguienteId;
    }

    HashMap<Integer, Garaje> getMap() {
        return garajes;
    }

    void setSiguienteId(int siguienteId) {
        this.siguienteId = siguienteId;
    }

    void setMap(HashMap<Integer, Garaje> garajes) {
        this.garajes = garajes;
    }
}
