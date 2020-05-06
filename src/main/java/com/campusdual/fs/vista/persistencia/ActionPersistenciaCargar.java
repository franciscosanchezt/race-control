package com.campusdual.fs.vista.persistencia;

import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActionPersistenciaCargar extends ActionViewLocal {

    public ActionPersistenciaCargar() {
        super("Cargar datos", "Cargar Datos");
    }

    @Override
    public void executeCustomAction() {
        String input = prompt("Introduce la ruta del archivo de respaldo:\n", String.class);
        Path path = Paths.get(input);
        boolean exists = Files.exists(path);
        if (exists) {
            boolean success = Persistencia.carga(path);
            if (success)
                actionSuccessful();
            else {
                println("Error en Carga");
                actionFailed();
            }
        } else {
            println("Error 404");
            actionFailed();
        }
    }
}
