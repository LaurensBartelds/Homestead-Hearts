package org.homesteadhearts.entities.gui.component;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.buttons.menu.GetBackButton;
import org.homesteadhearts.entities.buttons.menu.IngameExitButton;
import org.homesteadhearts.entities.buttons.menu.LeaveGameButton;
import org.homesteadhearts.entities.gui.coins.Coins;

public class TopBar extends DynamicCompositeEntity {
    private final double sceneWidth;
    private final double sceneHeight;
    private final HomesteadHearts homestead;

    public TopBar(Coordinate2D initialLocation, double sceneWidth, double sceneHeight, HomesteadHearts homestead) {
        super(initialLocation);
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
        this.homestead = homestead;
    }

    @Override
    protected void setupEntities() {
        Hotbar hotbar = new Hotbar(new Coordinate2D( sceneWidth / 6, 20), 9);
        addEntity(hotbar);

        addEntity(new Coins(new Coordinate2D(45, 50), "coins ", 0));

        IngameExitButton exitButton = new IngameExitButton(new Coordinate2D(sceneWidth / 2+ 25, sceneHeight / 2), homestead);
        addEntity(exitButton);
        GetBackButton getBackButton = new GetBackButton(new Coordinate2D(sceneWidth / 2 - 325, sceneHeight / 2), exitButton);
        addEntity(getBackButton);
        LeaveGameButton leaveGameButton= new LeaveGameButton(new Coordinate2D(sceneWidth - 100, 50), exitButton, getBackButton);
        addEntity(leaveGameButton);
    }
}
