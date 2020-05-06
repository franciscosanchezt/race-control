package com.campusdual.fs.vista.carrera;


import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.local.MenuViewLocal;

public class MenuCarreraGestion extends MenuViewLocal {

    private final MenuCarrerasLista parent;
    private final Carrera carrera;

    public MenuCarreraGestion(MenuCarrerasLista parent, Carrera carrera) {
        super("Editando Carrera: " + carrera.getNombre(), carrera.getNombre());
        this.parent  = parent;
        this.carrera = carrera;
        this.addMenuItem(new ActionCarreraRenombrar(this, this.carrera));
        this.addMenuItem(new ActionCarreraCambiarTipo(this.carrera));
        this.addMenuItem(new MenuCarreraSeleccionarGaraje(this.carrera));
        this.addMenuItem(new ActionCarreraEliminarGaraje(this.carrera));
        this.addMenuItem(new MenuCarreraAgregarCoche(this.carrera));
        this.addMenuItem(new MenuCarreraEliminarCoche(this.carrera));
        this.setParentView(parent);
    }

    public void refrescarCarrera() {
        setRunningTitle("Editando Carrera: " + carrera.getNombre());
        setNameInParentMenu(carrera.getNombre());
        parent.refrescarGarajes();
    }
}
