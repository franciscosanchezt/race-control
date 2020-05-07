package com.campusdual.fs.vista.control;


import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.carrera.ActionCarreraCambiarTipo;
import com.campusdual.fs.vista.carrera.ActionCarreraEliminarGaraje;
import com.campusdual.fs.vista.carrera.ActionCarreraRenombrar;
import com.campusdual.fs.vista.carrera.MenuCarreraAgregarCoche;
import com.campusdual.fs.vista.carrera.MenuCarreraEliminarCoche;
import com.campusdual.fs.vista.carrera.MenuCarreraSeleccionarGaraje;
import com.campusdual.fs.vista.local.IRefreshable;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;

public class MenuControlCarrera extends MenuViewLocal {

    private final IRefreshable parent;
    private final Carrera carrera;

    public MenuControlCarrera(IRefreshable parent, Carrera carrera) {
        super("Editando Carrera: " + carrera.getNombre(), carrera.getNombre());
        this.parent  = parent;
        this.carrera = carrera;
        this.addMenuItem(new ActionCarreraSimulacion(this.carrera));
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
