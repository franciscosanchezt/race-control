package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Carrera.TipoDeCompeticion;
import java.util.Collection;
import java.util.HashMap;

public class CarreraDao {

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
    private final HashMap<Integer, Carrera> carreras = new HashMap<>();

    public Carrera insertarCarrera(String nombre, TipoDeCompeticion tipoDeCompeticion) {
        Carrera carrera = new Carrera(siguienteId, nombre, tipoDeCompeticion);
        carreras.put(siguienteId, carrera);
        siguienteId++;
        return carrera;
    }

    public Collection<Carrera> getCarreras() {
        return carreras.values();
    }


}
