package com.campusdual.fs.vista.coche;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.vista.local.ActionViewLocal;

public class ActionCocheAgregar extends ActionViewLocal {

    public ActionCocheAgregar() {
        super("Creando Nuevo Coche", "Crear Nuevo Coche");
    }

    @Override
    public void executeCustomAction() {
        String marca = this.prompt("Introduce la marca: ", String.class);
        String modelo = this.prompt("Introduce el modelo: ", String.class);
        if (marca.length() > 0 && modelo.length() > 0) {
            CocheDao.getInstance().insertarCoche(marca, modelo);
            this.actionSuccessful();
        } else
            actionFailed();
    }
}
