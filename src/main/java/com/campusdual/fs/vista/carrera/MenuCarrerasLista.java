package com.campusdual.fs.vista.carrera;


import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.ActionViewLocal;
import com.campusdual.fs.vista.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCarrerasLista extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Garaje", "");

    public MenuCarrerasLista() {
        super("Elige un Garaje", "Editar Garajes");

    }

    @Override
    public void executeCustomAction() {
        refrescarGarajes();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    public void refrescarGarajes() {
        Collection<Carrera> carreras = CarreraDao.getInstance().getCarreras();
        ArrayList<AbstractView> carreramenu = new ArrayList<>();
        for (Carrera carrera : carreras) {
            carreramenu.add(new MenuCarreraGestion(this, carrera));
        }
        menuViewLocal.setMenuItems(carreramenu);
    }
}
