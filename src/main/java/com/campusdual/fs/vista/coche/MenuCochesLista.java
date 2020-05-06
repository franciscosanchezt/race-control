package com.campusdual.fs.vista.coche;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCochesLista extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Coche", "");

    public MenuCochesLista() {
        super("Elige un Garaje", "Editar Coches");

    }

    @Override
    public void executeCustomAction() {
        refrescarCoches();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    public void refrescarCoches() {
        Collection<Coche> coches = CocheDao.getInstance().getCoches();
        ArrayList<AbstractView> cochesMenu = new ArrayList<>();
        for (Coche coche : coches) {
            cochesMenu.add(new MenuCocheGestion(this, coche));
        }
        menuViewLocal.setMenuItems(cochesMenu);
    }
}
