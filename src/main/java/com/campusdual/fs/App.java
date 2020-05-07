package com.campusdual.fs;

import com.campusdual.fs.data.Persistencia;
import com.campusdual.fs.vista.MainMenuView;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class App {

    public static final String defaultPath = "res/data.dat";

    public static void main(String[] args) {

        Path path = Paths.get(defaultPath);
        if (Files.exists(path)) {
            System.out.println("Archivo de datos localizado. Cargando...");
            if (Persistencia.carga(path))
                System.out.println("Carga Satisfactoria");
            else
                System.out.println("Error en carga, iniciando sin datos.");
        }

        MainMenuView menu = new MainMenuView();
        menu.display();
    }
}
