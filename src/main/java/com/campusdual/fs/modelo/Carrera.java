package com.campusdual.fs.modelo;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Carrera {

    private int id;
    private String nombre;
    private final ArrayList<Coche> participantes = new ArrayList<>();
    private TipoDeCarrera tipoDeCarrera;
    private Garaje garaje = null;


    public enum TipoDeCarrera {
        ESTANDAR,
        ELIMINACION
    }

    public Carrera(int id, String nombre, TipoDeCarrera tipoDeCarrera) {
        this.id            = id;
        this.nombre        = nombre;
        this.tipoDeCarrera = tipoDeCarrera;
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

    public TipoDeCarrera getTipoDeCarrera() {
        return tipoDeCarrera;
    }

    public void setTipoDeCarrera(TipoDeCarrera tipoDeCarrera) {
        this.tipoDeCarrera = tipoDeCarrera;
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
            .add("tipoDeCarrera=" + tipoDeCarrera)
            .add("garaje=" + (garaje != null ? garaje.getNombre() : "null"))
            .toString();
    }
}
