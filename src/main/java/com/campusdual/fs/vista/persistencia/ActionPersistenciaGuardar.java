package com.campusdual.fs.vista.persistencia;

import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActionPersistenciaGuardar extends ActionViewLocal {

    public ActionPersistenciaGuardar() {
        super("Guardar datos", "Guardar Datos");
    }

    @Override
    public void executeCustomAction() {
        String input = prompt("Introduce la ruta del archivo de respaldo a crear:\n", String.class);
        Path path = Paths.get(input);
        boolean exists = Files.exists(path);
        if (exists) {
            boolean overwrite = confirmDialog("Archivo existente. Sobreescribir? ");
            if (overwrite) {
                guardar(path);
            } else
                actionCanceled();
        } else {
            guardar(path);
        }
    }

    private void guardar(Path path) {
        boolean success = Persistencia.guardar(path);
        if (success)
            actionSuccessful();
        else {
            println("Error en Guardado");
            actionFailed();
        }
    }
}