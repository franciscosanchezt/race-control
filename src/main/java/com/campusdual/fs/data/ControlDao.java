package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Carrera;
import java.util.ArrayList;

public class ControlDao {

    //Singleton instance
    private static ControlDao instance;

    private ControlDao() {
    }

    public static ControlDao getInstance() {
        if (instance == null) {
            synchronized (ControlDao.class) {
                if (instance == null) {
                    instance = new ControlDao();
                }
            }
        }
        return instance;
    }


    private final ArrayList<Carrera> carreras = new ArrayList<>();

    public ArrayList<Carrera> getCarreras() {
        return carreras;
    }
}
