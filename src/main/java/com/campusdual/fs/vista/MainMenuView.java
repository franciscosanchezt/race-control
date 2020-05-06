package com.campusdual.fs.vista;

import com.campusdual.fs.vista.carrera.MenuCarreras;
import com.campusdual.fs.vista.coche.MenuCoches;
import com.campusdual.fs.vista.garaje.MenuGarajes;

public class MainMenuView extends MenuViewLocal {


    public MainMenuView() {
        super("Race Control | v-0.0.1", "");
        this.addMenuItem(new MenuCoches());
        this.addMenuItem(new MenuGarajes());
        this.addMenuItem(new MenuCarreras());
    }
}
