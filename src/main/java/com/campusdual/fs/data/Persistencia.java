package com.campusdual.fs.data;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.modelo.Torneo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Persistencia {

    private static final CocheDao cocheDao = CocheDao.getInstance();
    private static final GarajeDao garajeDao = GarajeDao.getInstance();
    private static final CarreraDao carreraDao = CarreraDao.getInstance();
    private static final TorneoDao torneoDao = TorneoDao.getInstance();

    public static boolean carga(Path path) {

        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))) {
            cocheDao.setSiguienteId(in.readInt());
            cocheDao.setMap((HashMap<Integer, Coche>) in.readObject());
            garajeDao.setSiguienteId(in.readInt());
            garajeDao.setMap((HashMap<Integer, Garaje>) in.readObject());
            carreraDao.setSiguienteId(in.readInt());
            carreraDao.setMap((HashMap<Integer, Carrera>) in.readObject());
            torneoDao.setTorneoEstandar((Torneo) in.readObject());
            torneoDao.setTorneoEliminacion((Torneo) in.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean guardar(Path path) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path))) {
            out.writeInt(cocheDao.getSiguienteId());
            out.writeObject(cocheDao.getMap());
            out.writeInt(garajeDao.getSiguienteId());
            out.writeObject(garajeDao.getMap());
            out.writeInt(carreraDao.getSiguienteId());
            out.writeObject(carreraDao.getMap());
            out.writeObject(torneoDao.getTorneoEstandar());
            out.writeObject(torneoDao.getTorneoEliminacion());
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
