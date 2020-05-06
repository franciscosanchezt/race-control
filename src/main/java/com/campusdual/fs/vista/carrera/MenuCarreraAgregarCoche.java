package com.campusdual.fs.vista.carrera;

import com.campusdual.fs.data.CocheDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.modelo.Coche;
import com.campusdual.fs.vista.ActionViewLocal;
import com.campusdual.fs.vista.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MenuCarreraAgregarCoche extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Coche", "");
    private final Carrera carrera;

    public MenuCarreraAgregarCoche(Carrera carrera) {
        super("Agregando  Coche", "Agregar Coche");
        this.carrera = carrera;
    }

    @Override
    public void executeCustomAction() {
        refrescarCoches();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();

    }

    public void refrescarCoches() {
        Collection<Coche> coches = CocheDao.getInstance()
                                           .getCoches()
                                           .stream()
                                           .filter(coche -> !carrera.getParticipantes().contains(coche))
                                           .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<AbstractView> cochesMenu = new ArrayList<>();
        for (Coche coche : coches) {
            cochesMenu.add(new ActionCarreraAgregarCoche(this, carrera, coche));
        }
        menuViewLocal.setMenuItems(cochesMenu);
    }
}
