package com.campusdual.fs.vista.local;

import io.bretty.console.view.ActionView;

public abstract class ActionViewLocal extends ActionView implements IRefreshable {

    public ActionViewLocal(String runningTitle, String nameInParentMenu) {
        super(runningTitle, nameInParentMenu, LocalizationConfig.viewConfig);
    }

}
