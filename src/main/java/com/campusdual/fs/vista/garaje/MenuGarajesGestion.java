package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.ActionViewLocal;
import com.campusdual.fs.vista.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuGarajesGestion extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Garaje", "");

    public MenuGarajesGestion() {
        super("Elige un Garaje", "Gestionar Garajes");

    }

    @Override
    public void executeCustomAction() {
        refrescarGarajes();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    public void refrescarGarajes() {
        Collection<Garaje> garajes = GarajeDao.getInstance().getGarajes();
        ArrayList<AbstractView> garagesMenu = new ArrayList<>();
        for (Garaje garaje : garajes) {
            garagesMenu.add(new MenuGarajeGestion(this, garaje));
        }
        menuViewLocal.setMenuItems(garagesMenu);
    }
}
