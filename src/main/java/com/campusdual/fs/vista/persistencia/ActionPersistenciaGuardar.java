package com.campusdual.fs.vista.persistencia;

import com.campusdual.fs.App;
import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ActionPersistenciaGuardar extends ActionViewLocal {

    private Path path;

    public ActionPersistenciaGuardar() {
        super("Guardar datos", "Guardar Datos indicando ruta");
    }

    public ActionPersistenciaGuardar(Path path) {
        super("Guardar datos", "Guardar Datos en ruta predefinida " + Paths.get(App.defaultPath).toAbsolutePath().toString());
        this.path = path;
    }

    @Override
    public void executeCustomAction() {
        if (path == null) {
            String input = prompt("Introduce la ruta del archivo de respaldo a crear:\n", String.class);
            path = Paths.get(input);
        }
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
        try {
            boolean success = Persistencia.guardar(path);
            if (success)
                actionSuccessful();
            else {
                println("Error en Guardado");
                actionFailed();
            }
        } catch (Exception e) {
            println("Error en Guardado");
            actionFailed();
        }
    }
}