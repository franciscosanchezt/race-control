package com.campusdual.fs.vista;

import com.campusdual.fs.vista.carrera.MenuCarreras;
import com.campusdual.fs.vista.coche.MenuCoches;
import com.campusdual.fs.vista.garaje.MenuGarajes;
import com.campusdual.fs.vista.local.MenuViewLocal;
import com.campusdual.fs.vista.persistencia.MenuPersistencia;
import com.campusdual.fs.vista.torneo.MenuTorneos;

public class MainMenuView extends MenuViewLocal {


    public MainMenuView() {
        super("Race Control | v-0.0.1", "");
        this.addMenuItem(new MenuCoches());
        this.addMenuItem(new MenuGarajes());
        this.addMenuItem(new MenuCarreras());
        this.addMenuItem(new MenuTorneos());
        this.addMenuItem(new MenuPersistencia());
    }
}
