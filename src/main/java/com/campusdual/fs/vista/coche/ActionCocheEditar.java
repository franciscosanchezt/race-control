package com.campusdual.fs.vista.coche;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.IRefreshable;

public class ActionCocheEditar extends ActionViewLocal {

    private final IRefreshable parent;
    private final Coche coche;

    public ActionCocheEditar(IRefreshable parent, Coche coche) {
        super("Editando coche\ndeja el campo en blanco para mantener valor actual", "Editar Coche");
        this.parent = parent;
        this.coche  = coche;
    }

    @Override
    public void executeCustomAction() {
        String marca = this.prompt("Introduce marca (" + coche.getMarca() + "): ", String.class);
        String modelo = this.prompt("Introduce modelo (" + coche.getModelo() + "): ", String.class);
        if (marca.length() > 0)
            coche.setMarca(marca);
        if (modelo.length() > 0)
            coche.setModelo(modelo);
        if (marca.length() > 0 || modelo.length() > 0) {
            this.actionSuccessful();
            this.parent.refreshView();
        } else
            this.actionCanceled();
    }
}
