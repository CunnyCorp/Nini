package org.shondo.nini.modules;

import monster.psyop.client.framework.events.EventListener;
import monster.psyop.client.framework.gui.utility.DrawUtils;
import monster.psyop.client.framework.modules.Categories;
import monster.psyop.client.framework.modules.Module;
import monster.psyop.client.framework.modules.settings.GroupedSettings;
import monster.psyop.client.framework.modules.settings.types.BoolSetting;
import monster.psyop.client.framework.modules.settings.types.ColorSetting;
import monster.psyop.client.framework.modules.settings.types.IntSetting;
import monster.psyop.client.framework.modules.settings.wrappers.ImColorW;
import monster.psyop.client.impl.events.OnGuiRender;
import monster.psyop.client.utility.gui.NotificationEvent;
import monster.psyop.client.utility.gui.NotificationManager;

public class ExampleModule extends Module {
    private final GroupedSettings sillyGroup = addGroup(new GroupedSettings("silly", "Erm what the sigma!"));
    private final ColorSetting sillyColor = new ColorSetting.Builder()
            .name("silly-color")
            .defaultTo(new float[]{0.0f, 0.6f, 0.4f, 1.0f})
            .addTo(sillyGroup);
    private final BoolSetting sigma = new BoolSetting.Builder()
            .name("sigma")
            .description("Shows sigma text.")
            .defaultTo(false)
            .addTo(sillyGroup);
    private final ColorSetting sigmaColor = new ColorSetting.Builder()
            .name("sigma-color")
            .defaultTo(new float[]{0.0f, 1.0f, 0.0f, 1.0f})
            .addTo(sillyGroup);
    private final IntSetting delay = new IntSetting.Builder()
            .name("delay")
            .description("Delay for silly notifications")
            .defaultTo(240)
            .range(20, 240)
            .addTo(sillyGroup);

    public int ticks = 0;

    public ExampleModule() {
        super(Categories.MISC, "example", "A silly little module.");
    }

    @EventListener
    public void onRenderGui(OnGuiRender event) {
        DrawUtils.drawText("You're so silly!", 0, (float) (MC.getWindow().getHeight() / 1.5), new ImColorW(sillyColor.get()));

        if (sigma.get()) {
            DrawUtils.drawText("Erm what the sigma!", 0, (float) MC.getWindow().getHeight() / 2, new ImColorW(sigmaColor.get()));
        }
    }

    @Override
    public void update() {
        ticks++;

        if (ticks >= delay.get()) {
            NotificationManager.get().addNotification("Silly Message", "You're so sigma sigma girl!", NotificationEvent.Type.INFO, 2500);
            ticks = 0;
        }
    }
}
