package com.campusdual.fs.vista.local;

import io.bretty.console.view.ActionView;

public abstract class ActionViewLocal extends ActionView {

    public ActionViewLocal(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu, MenuViewLocal.viewConfig);
    }

}
