package com.campusdual.fs.vista.coche;

import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.IRefreshable;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;

public class MenuCocheGestion extends MenuViewLocal {

    private final IRefreshable parent;
    private final Coche coche;

    public MenuCocheGestion(IRefreshable parent, Coche coche) {
        super("Editando Coche: " + coche.toCompactString(), coche.toCompactString());
        this.parent = parent;
        this.coche  = coche;
        this.addMenuItem(new ActionCocheEditar(this, this.coche));
        this.addMenuItem(new ActionCocheEliminarGaraje(this.coche));
        this.addMenuItem(new MenuCocheListaGarajes(this.coche));
        this.setParentView((AbstractView) parent);
    }

    public void refreshView() {
        setRunningTitle("Editando Coche: " + coche.toCompactString());
        setNameInParentMenu(coche.toCompactString());
        parent.refreshView();
    }
}
