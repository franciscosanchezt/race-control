package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.IRefreshable;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;

public class MenuGarajeGestion extends MenuViewLocal {

    private final IRefreshable parent;
    private final Garaje garaje;

    public MenuGarajeGestion(IRefreshable parent, Garaje garaje) {
        super("Editando Garage: " + garaje.getNombre(), garaje.getNombre());
        this.parent = parent;
        this.garaje = garaje;
        this.addMenuItem(new ActionGarajeRenombrar(this, this.garaje));
        this.addMenuItem(new MenuGarajeRegistrarCoches(this, this.garaje));
        this.addMenuItem(new MenuGarajeEliminarCoche(this.garaje));
        this.addMenuItem(new ActionGarajeRegistroMasivo(this.garaje));
        this.setParentView((AbstractView) parent);
    }

    @Override
    public void refreshView() {
        setRunningTitle("Editando Garage: " + garaje.getNombre());
        setNameInParentMenu(garaje.getNombre());
        parent.refreshView();
    }
}
