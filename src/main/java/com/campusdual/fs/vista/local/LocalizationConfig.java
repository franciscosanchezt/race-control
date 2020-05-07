package com.campusdual.fs.vista.local;

import io.bretty.console.view.ViewConfig;

public class LocalizationConfig {

    public static ViewConfig viewConfig = new ViewConfig.Builder()
        .setMenuSelectionMessage("Introduce un numero para continuar: ")
        .setPauseMessage("Presiona INTRO para continuar...")
        .setQuitMessage("Cerrando...")
        .setActionCanceledMessage("Accion Cancelada")
        .setActionSuccessfulMessage("Accion Exitosa")
        .setActionFailedMessage("Accion Fallida")
        .setBackMenuName("Volver")
        .setQuitMenuName("Salir")
        .build();
}
