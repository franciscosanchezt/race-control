package com.campusdual.fs.modelo;

import com.campusdual.fs.modelo.Carrera.TipoDeCompeticion;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringJoiner;

public class Torneo {

    private String nombre;
    private final Carrera[] carreras = new Carrera[10];
    private final HashMap<Coche, Integer> participantes = new HashMap<>();
    private Garaje garaje = null;
    private TipoDeCompeticion tipoDeCompeticion;

    public Torneo(String nombre, TipoDeCompeticion tipoDeCompeticion) {
        this.nombre            = nombre;
        this.tipoDeCompeticion = tipoDeCompeticion;
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
}
