package com.campusdual.fs.modelo;

import java.util.StringJoiner;

public class Coche {

    private int id;
    private String marca;
    private String modelo;
    private Garaje garaje;
    private static int velocidadMaxima = 10;

    public Coche(int id, String marca, String modelo) {
        this.id     = id;
        this.marca  = marca;
        this.modelo = modelo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public static int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public static void setVelocidadMaxima(int velocidadMaxima) {
        Coche.velocidadMaxima = velocidadMaxima;
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Coche.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("marca='" + marca + "'")
            .add("modelo='" + modelo + "'")
            .add("garaje=" + garaje.getNombre())
            .toString();
    }

    public String toCompactString() {
        return "(" + this.getId() + ") " + this.getMarca() + ", " + this.getModelo();
    }
}
