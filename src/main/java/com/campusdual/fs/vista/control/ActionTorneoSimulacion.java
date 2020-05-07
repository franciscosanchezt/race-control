package com.campusdual.fs.vista.control;

import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Torneo;
import com.campusdual.fs.vista.local.ActionViewLocal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ActionTorneoSimulacion extends ActionViewLocal {

    private final Torneo torneo;

    public ActionTorneoSimulacion(Torneo torneo) {
        super("Simulando torneo...", "Simular Torneo");
        this.torneo = torneo;
    }

    @Override
    public void executeCustomAction() {
        println("Tipo de Torneo: " + torneo.getTipoDeCompeticion());
        println("Tipo de Seleccion: " + (torneo.getGaraje() != null ? ("Garaje: " + torneo.getGaraje().getNombre()) : "Todos los Garajes"));
        if (torneo.getParticipantes().size() < 2) {
            boolean search = confirmDialog("El torneo no tiene suficientes participantes.\n Deseas autocompletar los participantes?");
            if (search) {
                torneo.buscarParticipantes();
                if (torneo.getParticipantes().size() < 2) {
                    println("No hay suficientes competidores disponibles");
                    actionFailed();
                    return;
                }

            } else
                actionCanceled();
        }

        if (torneo.getParticipantes().size() > 1) {
            println("Simulando Carrera...\nPodio: ");
            Map<Coche, Integer> podio = torneo.simularTorneo();
            podio.forEach((coche, puntuacion) -> println("Coche: " + coche.toCompactString() + " Puntuacion: " + puntuacion));
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

    private void guardar(Path path, Map<Coche, Integer> podio) {
        try {
            boolean success = Persistencia.guardarPodioTorneo(path, torneo, podio);
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
