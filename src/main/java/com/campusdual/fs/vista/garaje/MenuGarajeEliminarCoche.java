package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuGarajeEliminarCoche extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Coche", "");
    private final Garaje garaje;

    public MenuGarajeEliminarCoche(Garaje garaje) {
        super("Selecciona un coche a eliminar", "Eliminar Coche Registrado");
        this.garaje = garaje;
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
            cochesMenu.add(new ActionGarajeEliminarCoche(this, garaje, coche));
        }
        menuViewLocal.setMenuItems(cochesMenu);
    }
}
