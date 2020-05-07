package com.campusdual.fs.vista.carrera;


import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;

public class MenuCarrerasLista extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Carrera", "");

    public MenuCarrerasLista() {
        super("Elige una Carrera", "Editar Carrera");

    }

    @Override
    public void executeCustomAction() {
        refreshView();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    @Override
    public void refreshView() {
        Collection<Carrera> carreras = CarreraDao.getInstance().getCarreras();
        ArrayList<AbstractView> carreramenu = new ArrayList<>();
        for (Carrera carrera : carreras) {
            carreramenu.add(new MenuCarreraGestion(this, carrera));
        }
        menuViewLocal.setMenuItems(carreramenu);
    }
}
