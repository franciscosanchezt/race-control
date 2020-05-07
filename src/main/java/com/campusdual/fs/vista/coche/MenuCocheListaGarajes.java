package com.campusdual.fs.vista.coche;

import com.campusdual.fs.data.GarajeDao;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCocheListaGarajes extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Garaje", "");
    private final Coche coche;

    public MenuCocheListaGarajes(Coche coche) {
        super("Selecciona un Garaje", "Seleccionar Garaje");
        this.coche = coche;
    }

    @Override
    public void executeCustomAction() {
        refreshView();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    public void refreshView() {
        Collection<Garaje> garajes = GarajeDao.getInstance().getGarajes();
        ArrayList<AbstractView> garagesMenu = new ArrayList<>();
        for (Garaje garaje : garajes) {
            garagesMenu.add(new ActionCocheSeleccionarGaraje(this, coche, garaje));
        }
        menuViewLocal.setMenuItems(garagesMenu);
    }
}
