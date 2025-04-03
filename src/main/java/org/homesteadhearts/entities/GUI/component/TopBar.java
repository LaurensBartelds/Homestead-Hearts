package org.homesteadhearts.entities.gui.component;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.homesteadhearts.entities.buttons.menu.IngameExitButton;
import org.homesteadhearts.entities.gui.coins.Coins;

public class TopBar extends DynamicCompositeEntity {
    private final int sceneWidth;

    public TopBar(Coordinate2D initialLocation, int sceneWidth) {
        super(initialLocation);
        this.sceneWidth = sceneWidth;
    }

    @Override
    protected void setupEntities() {
        Hotbar hotbar = new Hotbar(new Coordinate2D((double) sceneWidth / 6, 20), 9);
        addEntity(hotbar);

        addEntity(new Coins(new Coordinate2D(45, 50), "coins ", 0));

        IngameExitButton exitButton = new IngameExitButton(new Coordinate2D(getSceneWidth() - 85, 35));
        addEntity(exitButton);
    }
}
