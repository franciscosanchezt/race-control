package com.campusdual.fs.modelo;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Garaje {

    private int id;
    private String nombre;
    private final ArrayList<Coche> coches = new ArrayList<>();

    public Garaje(int id, String nombre) {
        this.id     = id;
        this.nombre = nombre;
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Coche> getCoches() {
        return coches;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Garaje.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("nombre='" + nombre + "'")
            .add("coches=" + coches)
            .toString();
    }
}
