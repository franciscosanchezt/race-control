package com.campusdual.fs.vista.local;

import io.bretty.console.view.MenuView;

public class MenuViewLocal extends MenuView implements IRefreshable {

    public MenuViewLocal(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu, LocalizationConfig.viewConfig);
    }
}
