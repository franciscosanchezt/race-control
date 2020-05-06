package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

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

    public int insertarCoches(File file, Garaje garaje) {
        AtomicInteger count = new AtomicInteger(0);
        try {
            Files.lines(file.toPath()).forEach(s -> {
                String[] cols = s.split(",");
                if (cols[0].length() > 0 && cols[1].length() > 0) {
                    Coche coche = new Coche(siguienteId, cols[0], cols[1]);
                    if (garaje != null)
                        coche.setGaraje(garaje);
                    coches.put(siguienteId, coche);
                    siguienteId++;
                    count.incrementAndGet();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count.get();
    }


}
