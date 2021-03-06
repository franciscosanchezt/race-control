package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.TipoDeCompeticion;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class CarreraDao implements Serializable {

    //Singleton instance
    private static CarreraDao instance;

    private CarreraDao() {
    }

    public static CarreraDao getInstance() {
        if (instance == null) {
            synchronized (CarreraDao.class) {
                if (instance == null) {
                    instance = new CarreraDao();
                }
            }
        }
        return instance;
    }

    private int siguienteId = 0;
    private HashMap<Integer, Carrera> carreras = new HashMap<>();

    public Carrera insertarCarrera(String nombre, TipoDeCompeticion tipoDeCompeticion) {
        Carrera carrera = new Carrera(siguienteId, nombre, tipoDeCompeticion);
        carreras.put(siguienteId, carrera);
        siguienteId++;
        return carrera;
    }

    public Collection<Carrera> getCarreras() {
        return carreras.values();
    }

    int getSiguienteId() {
        return siguienteId;
    }

    HashMap<Integer, Carrera> getMap() {
        return carreras;
    }

    void setSiguienteId(int siguienteId) {
        this.siguienteId = siguienteId;
    }

    void setMap(HashMap<Integer, Carrera> carreras) {
        this.carreras = carreras;
    }
}
