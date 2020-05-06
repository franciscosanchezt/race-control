package com.campusdual.fs.vista.garaje;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.modelo.Garaje;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MenuGarajeRegistrarCoches extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Coche", "");
    private final MenuGarajeGestion parent;
    private final Garaje garaje;

    Collection<Coche> coches = CocheDao.getInstance().getCoches();

    public MenuGarajeRegistrarCoches(MenuGarajeGestion parent, Garaje garaje) {
        super("Registrando coche en el garage " + garaje.getNombre(), "Registrar Coche");
        this.parent = parent;
        this.garaje = garaje;
    }

    @Override
    public void executeCustomAction() {

        if (coches.size() < 1)
            println("No hay coches sin garaje, intenta crear un coche nuevo\n");
        else {
            cargarCochesLibres();
            menuViewLocal.setParentView(this);
            menuViewLocal.display();
        }
    }

    private void cargarCochesLibres() {
        coches = coches.stream()
                       .filter(coche -> coche.getGaraje() == null)
                       .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<AbstractView> garagesMenu = new ArrayList<>();
        for (Coche garaje : coches) {
            garagesMenu.add(new ActionGarajeRegistrarCoche(this.parent, this.garaje, garaje));
        }
        menuViewLocal.setMenuItems(garagesMenu);
    }
}
