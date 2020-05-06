package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Carrera.TipoDeCarrera;
import com.campusdual.fs.vista.ActionViewLocal;

public class ActionCarreraCambiarTipo extends ActionViewLocal {

    private final Carrera carrera;

    public ActionCarreraCambiarTipo(Carrera carrera) {
        super("Editando tipo de carrera", "Editar tipo de carrera");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        boolean estandar = confirmDialog("Carrera estandar?");
        carrera.setTipoDeCarrera(estandar ? TipoDeCarrera.ESTANDAR : TipoDeCarrera.ELIMINACION);
        actionSuccessful();
    }
}
