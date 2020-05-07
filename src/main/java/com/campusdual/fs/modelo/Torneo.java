package com.campusdual.fs.modelo;

import com.campusdual.fs.data.GarajeDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.StringJoiner;

public class Torneo implements Serializable {

    private String nombre;
    private final Carrera[] carreras = new Carrera[10];
    private final HashMap<Coche, Integer> participantes = new HashMap<>();
    private Garaje garaje = null;
    private TipoDeCompeticion tipoDeCompeticion;

    public Torneo(String nombre, TipoDeCompeticion tipoDeCompeticion) {
        this.nombre            = nombre;
        this.tipoDeCompeticion = tipoDeCompeticion;
    }

    public void buscarParticipantes() {
        participantes.clear();
        if (garaje == null) {
            GarajeDao.getInstance()
                     .getGarajes()
                     .stream()
                     .filter(garaje1 -> garaje1.getCoches().size() > 0)     //descartamos los garajes vacios
                     .forEach(garaje1 -> participantes.put(garaje1.getCoches().get(new Random().nextInt(garaje1.getCoches().size())), 0)); //seleccionamos un coche alatorio de cada garaje
        } else
            garaje.getCoches().forEach(coche -> participantes.put(coche, 0));
        System.out.println("Participantes: " + participantes.keySet().size());
    }

    public Map<Coche, Integer> simularTorneo() {
        for (Carrera carrera : carreras) {
            carrera.getParticipantes().addAll(participantes.keySet());
            List<Coche> podio = carrera.simularCarrera();

            for (int i = 0; i < Math.min(3, podio.size()); i++) {
                int puntuacionActual = participantes.get(podio.get(i));
                int puntosGanados = 0;
                switch (i) {
                    case 0:
                        puntosGanados = 5;
                        break;
                    case 1:
                        puntosGanados = 3;
                        break;
                    case 2:
                        puntosGanados = 1;
                        break;
                }
                participantes.put(podio.get(i), puntuacionActual + puntosGanados);
            }
        }
        return sortByValue(participantes);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Carrera[] getCarreras() {
        return carreras;
    }

    public HashMap<Coche, Integer> getParticipantes() {
        return participantes;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    public TipoDeCompeticion getTipoDeCompeticion() {
        return tipoDeCompeticion;
    }

    public void setTipoDeCompeticion(TipoDeCompeticion tipoDeCompeticion) {
        this.tipoDeCompeticion = tipoDeCompeticion;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Torneo.class.getSimpleName() + "[", "]")
            .add("nombre='" + nombre + "'")
            .add("carreras=" + Arrays.toString(carreras))
            .add("participantes=" + participantes.size())
            .add("garaje=" + (garaje != null ? garaje.getNombre() : "null"))
            .add("tipoDeCompeticion=" + tipoDeCompeticion)
            .toString();
    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
