package com.campusdual.fs.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.StringJoiner;

public class Carrera implements Serializable {

    private int id;
    private String nombre;
    private final ArrayList<Coche> participantes = new ArrayList<>();
    private TipoDeCompeticion tipoDeCompeticion;
    private Garaje garaje = null;


    public Carrera(int id, String nombre, TipoDeCompeticion tipoDeCompeticion) {
        this.id                = id;
        this.nombre            = nombre;
        this.tipoDeCompeticion = tipoDeCompeticion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String premio) {
        this.nombre = premio;
    }

    public ArrayList<Coche> getParticipantes() {
        return participantes;
    }

    public TipoDeCompeticion getTipoDeCompeticion() {
        return tipoDeCompeticion;
    }

    public void setTipoDeCompeticion(TipoDeCompeticion tipoDeCompeticion) {
        this.tipoDeCompeticion = tipoDeCompeticion;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Carrera.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("premio='" + nombre + "'")
            .add("participantes=" + participantes)
            .add("tipoDeCarrera=" + tipoDeCompeticion)
            .add("garaje=" + (garaje != null ? garaje.getNombre() : "null"))
            .toString();
    }
}
