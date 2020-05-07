package com.campusdual.fs.modelo;

import com.campusdual.fs.data.GarajeDao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Carrera implements Serializable {

    private int id;
    private String nombre;
    private final ArrayList<Coche> participantes = new ArrayList<>();
    private TipoDeCompeticion tipoDeCompeticion;
    private Garaje garaje = null;
    private boolean finalizada = false;


    public Carrera(int id, String nombre, TipoDeCompeticion tipoDeCompeticion) {
        this.id                = id;
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
                     .forEach(garaje1 -> participantes.add(garaje1.getCoches().get(new Random().nextInt(garaje1.getCoches().size())))); //seleccionamos un coche alatorio de cada garaje
        } else
            participantes.addAll(garaje.getCoches());
        System.out.println("Participantes: " + participantes.size());
    }

    public List<Coche> simularCarrera() {
        List<Coche> podio = new ArrayList<>();
        ArrayList<Coche> estadoDeCarrera = new ArrayList<>();
        estadoDeCarrera.addAll(participantes);
        switch (tipoDeCompeticion) {
            case ESTANDAR:
                Collections.shuffle(estadoDeCarrera);
                podio = estadoDeCarrera.subList(0, Math.min(estadoDeCarrera.size(), 3));
                break;
            case ELIMINACION:
                Coche coche3 = null, coche2 = null, coche1 = null;
                for (int vueltasRestantes = participantes.size() - 1; vueltasRestantes >= 0; vueltasRestantes--) {
                    Collections.shuffle(estadoDeCarrera);
                    switch (vueltasRestantes) {
                        case 0:
                            coche1 = estadoDeCarrera.get(0);
                            break;
                        case 1:
                            coche2 = estadoDeCarrera.get(1);
                            break;
                        case 2:
                            coche3 = estadoDeCarrera.get(2);
                            break;
                    }
                    if (estadoDeCarrera.size() > 1)
                        estadoDeCarrera.remove(estadoDeCarrera.size() - 1);
                    else
                        break;
                }
                if (coche2 == null)
                    podio = Collections.singletonList(coche1);
                else if (coche3 == null)
                    podio = Arrays.asList(coche1, coche2);
                else
                    podio = Arrays.asList(coche1, coche2, coche3);
                break;
        }
        return podio;
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

    public String getDuracion() {
        return tipoDeCompeticion == TipoDeCompeticion.ESTANDAR ?
               "3 Horas" :
               Math.max(1, participantes.size() - 1) + " vueltas.";
    }

    public Garaje getGaraje() {
        return garaje;
    }

    public void setGaraje(Garaje garaje) {
        this.garaje = garaje;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Carrera.class.getSimpleName() + "[", "]")
            .add("id=" + id)
            .add("nombre='" + nombre + "'")
            .add("participantes=" + participantes)
            .add("tipoDeCompeticion=" + tipoDeCompeticion)
            .add("garaje=" + (garaje != null ? garaje.getNombre() : "null")) //(garaje != null ? garaje.getNombre() : "null")
            .add("finalizada=" + finalizada)
            .toString();
    }
}
