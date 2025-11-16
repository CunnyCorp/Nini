package org.shondo.nini;

import monster.psyop.client.plugins.JavaAddon;
import org.shondo.nini.modules.ExampleModule;

    @Override
    public void onInit() {
        new ExampleModule().load();
    }
}
