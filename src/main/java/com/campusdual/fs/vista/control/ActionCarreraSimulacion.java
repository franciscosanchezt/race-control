package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ActionCarreraSimulacion extends ActionViewLocal {


    private final Carrera carrera;

    public ActionCarreraSimulacion(Carrera carrera) {
        super("Simulando Carrera", "Simular Carrera");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        println("Tipo de Carrera: " + carrera.getTipoDeCompeticion());
        println("Tipo de Seleccion: " + (carrera.getGaraje() != null ? ("Garaje: " + carrera.getGaraje().getNombre()) : "Todos los Garajes"));
        if (carrera.getParticipantes().size() < 2) {
            boolean search = confirmDialog("La carrera no tiene suficientes participantes.\n Deseas autocompletar los participantes?");
            if (search) {
                carrera.buscarParticipantes();
                if (carrera.getParticipantes().size() < 2) {
                    println("No hay suficientes competidores disponibles");
                    actionFailed();
                    return;
                }

            } else
                actionCanceled();
        }

        if (carrera.getParticipantes().size() > 1) {
            println("Simulando Carrera...\nDuracion de la carrera: " + carrera.getDuracion() + "\nPodio: ");
            List<Coche> podio = carrera.simularCarrera();
            for (int i = 0; i < podio.size(); i++) {
                Coche coche = podio.get(i);
                println("Posicion " + (i + 1) + ": " + coche.toCompactString());
            }
            boolean guardar = confirmDialog("Deseas guardar el resultado en un archivo de texto?");
            if (guardar) {
                String input = prompt("Introduce la ruta/nombre del archivo a guardar: ", String.class);
                Path path = Paths.get(input);

                boolean exists = Files.exists(path);
                if (exists) {
                    boolean overwrite = confirmDialog("Archivo existente. Sobreescribir? ");
                    if (overwrite) {
                        guardar(path, podio);
                    } else
                        actionCanceled();
                } else {
                    guardar(path, podio);
                }
            }
            actionSuccessful();
        }
    }

    private void guardar(Path path, List<Coche> podio) {
        try {
            boolean success = Persistencia.guardarPodioCarrera(path, carrera, podio);
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
