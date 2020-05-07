package com.campusdual.fs.vista.control;


import com.campusdual.fs.data.CarreraDao;
import com.campusdual.fs.data.TorneoDao;
import com.campusdual.fs.modelo.Carrera;
import com.campusdual.fs.vista.carrera.MenuCarreraGestion;
import com.campusdual.fs.vista.local.ActionViewLocal;
import com.campusdual.fs.vista.local.MenuViewLocal;
import io.bretty.console.view.AbstractView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MenuControlListaCarreras extends ActionViewLocal {

    private final MenuViewLocal menuViewLocal = new MenuViewLocal("Elige un Carrera", "");

    public MenuControlListaCarreras() {
        super("Elige una Carrera", "Lista de Carreras Independientes");

    }

    @Override
    public void executeCustomAction() {
        refreshView();
        menuViewLocal.setParentView(this);
        menuViewLocal.display();
    }

    @Override
    public void refreshView() {
        Collection<Carrera> carreras = CarreraDao.getInstance()
                                                 .getCarreras()
                                                 .stream()
                                                 .filter(carrera -> TorneoDao.getInstance().carreraEnTorneo(carrera))
                                                 .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<AbstractView> carreramenu = new ArrayList<>();
        for (Carrera carrera : carreras) {
            carreramenu.add(new MenuCarreraGestion(this, carrera));
        }
        menuViewLocal.setMenuItems(carreramenu);
    }
}
