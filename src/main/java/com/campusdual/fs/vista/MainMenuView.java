package com.campusdual.fs.vista;

public class MainMenuView extends MenuViewLocal {


    public MainMenuView() {
        super("Race Control | v-0.0.1", "");
        this.addMenuItem(new MenuCoches());
        this.addMenuItem(new MenuGarajes());
    }
}
