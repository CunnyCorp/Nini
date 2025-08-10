package org.shondo.ninisc;

import org.shondo.client.plugins.JavaAddon;
import org.shondo.ninisc.modules.OnlyControl;

public class NiniSC implements JavaAddon {
    @Override
    public void onInit() {
        new OnlyControl().load();
    }
}
