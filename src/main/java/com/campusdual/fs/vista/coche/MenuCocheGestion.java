package com.campusdual.fs.vista.coche;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.MenuViewLocal;

public class MenuCocheGestion extends MenuViewLocal {

    private final MenuCochesLista parent;
    private final Coche coche;

    public MenuCocheGestion(MenuCochesLista parent, Coche coche) {
        super("Editando Coche: " + coche.toCompactString(), coche.toCompactString());
        this.parent = parent;
        this.coche  = coche;
        this.addMenuItem(new ActionCocheEditar(this, this.coche));
        this.addMenuItem(new ActionCocheEliminarGaraje(this.coche));
        this.addMenuItem(new MenuCocheListaGarajes(this.coche));
        this.setParentView(parent);
    }

    public void refrescarCoche() {
        setRunningTitle("Editando Coche: " + coche.toCompactString());
        setNameInParentMenu(coche.toCompactString());
        parent.refrescarCoches();
    }
}
