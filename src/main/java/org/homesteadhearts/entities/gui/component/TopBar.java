package org.homesteadhearts.entities.gui.component;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.buttons.menu.GetBackButton;
import org.homesteadhearts.entities.buttons.menu.IngameExitButton;
import org.homesteadhearts.entities.buttons.menu.LeaveGameButton;
import org.homesteadhearts.entities.gui.coins.Coins;

public class TopBar extends DynamicCompositeEntity {
    private final double SCENE_WIDTH;
    private final double SCENE_HEIGHT;
    private final HomesteadHearts HOMESTEAD;

    public TopBar(Coordinate2D initialLocation, double SCENE_WIDTH, double SCENE_HEIGHT, HomesteadHearts homestead) {
        super(initialLocation);
        this.SCENE_WIDTH = SCENE_WIDTH;
        this.SCENE_HEIGHT = SCENE_HEIGHT;
        this.HOMESTEAD = homestead;
    }

    @Override
    protected void setupEntities() {
        Hotbar hotbar = new Hotbar(new Coordinate2D( SCENE_WIDTH / 6, 20), 9);
        addEntity(hotbar);

        addEntity(new Coins(new Coordinate2D(45, 50), "coins ", 0));

        IngameExitButton exitButton = new IngameExitButton(new Coordinate2D(SCENE_WIDTH / 2+ 25, SCENE_HEIGHT / 2), HOMESTEAD);
        addEntity(exitButton);
        GetBackButton getBackButton = new GetBackButton(new Coordinate2D(SCENE_WIDTH / 2 - 325, SCENE_HEIGHT / 2), exitButton);
        addEntity(getBackButton);
        LeaveGameButton leaveGameButton= new LeaveGameButton(new Coordinate2D(SCENE_WIDTH - 100, 50), exitButton, getBackButton);
        addEntity(leaveGameButton);
    }
}
