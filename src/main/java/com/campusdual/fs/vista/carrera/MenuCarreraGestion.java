package com.campusdual.fs.vista.carrera;


import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.local.IRefreshable;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;

public class MenuCarreraGestion extends MenuViewLocal {

    private final IRefreshable parent;
    private final Carrera carrera;

    public MenuCarreraGestion(IRefreshable parent, Carrera carrera) {
        super("Editando Carrera: " + carrera.getNombre(), carrera.getNombre());
        this.parent  = parent;
        this.carrera = carrera;
        this.addMenuItem(new ActionCarreraRenombrar(this, this.carrera));
        this.addMenuItem(new ActionCarreraCambiarTipo(this.carrera));
        this.addMenuItem(new MenuCarreraSeleccionarGaraje(this.carrera));
        this.addMenuItem(new ActionCarreraEliminarGaraje(this.carrera));
        this.addMenuItem(new MenuCarreraAgregarCoche(this.carrera));
        this.addMenuItem(new MenuCarreraEliminarCoche(this.carrera));
        this.setParentView((AbstractView) parent);
    }

    @Override
    public void refreshView() {
        setRunningTitle("Editando Carrera: " + carrera.getNombre());
        setNameInParentMenu(carrera.getNombre());
        parent.refreshView();
    }
}
