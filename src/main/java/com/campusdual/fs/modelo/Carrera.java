package com.campusdual.fs.modelo;

import java.util.ArrayList;

public class Carrera {

    private String premio;
    private final ArrayList<Coche> participantes = new ArrayList<>();
    private TipoDeCarrera tipoDeCarrera;


    private enum TipoDeCarrera {
        ESTANDAR,
        ELIMINACION
    }
}
