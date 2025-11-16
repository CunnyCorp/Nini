package org.shondo.nini;

import monster.psyop.client.plugins.JavaAddon;
import org.shondo.nini.modules.ExampleModule;

public class Nini implements JavaAddon {
    @Override
    public void onInit() {
        new ExampleModule().load();
    }
}
