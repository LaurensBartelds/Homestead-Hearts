package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.GUI.ChickenPoints;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.GUI.coins.Coins;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.animals.chicken.Chicken;
import org.homesteadhearts.entities.buttons.menu.GetBackButton;
import org.homesteadhearts.entities.buttons.menu.LeaveGameButton;
import org.homesteadhearts.entities.crops.types.*;
import org.homesteadhearts.entities.buttons.menu.IngameExitButton;

import org.homesteadhearts.entities.crops.types.Carrot;
import org.homesteadhearts.entities.crops.types.Corn;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer, MouseButtonPressedListener {
    private TopLayerMap topLayerMap;
    private Player player;
    private GroundLayerMap groundLayerMap;
    private final HomesteadHearts homestead;


    public GameLevel(HomesteadHearts homestead) {
        this.homestead = homestead;
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.WHITE);
        setSize(new Size(2000, 2000));
        setRelativeScrollPosition(0.1, 0.1);
    }

    @Override
    public void setupEntities() {
        // Create maps first
        groundLayerMap = new GroundLayerMap();
        topLayerMap = new TopLayerMap();

        // Add entities
        player = new Player(new Coordinate2D(1000, 1000));
        addEntity(player);

        ChickenPoints points = new ChickenPoints(new Coordinate2D(45, 80), "points: ", 0);
        addEntity(points, true);


        Bunny bunny = new Bunny(new Coordinate2D(1000, 1000), player);
        addEntity(bunny);
        Chicken chicken1 = new Chicken(new Coordinate2D(1200, 300), 90, points);
        Chicken chicken2 = new Chicken(new Coordinate2D(1200, 700), 270, points);
        Chicken chicken3 = new Chicken(new Coordinate2D(1200, 1100), 90, points);


        addEntity(chicken1);
        addEntity(chicken2);
        addEntity(chicken3);

        Hotbar hotbar = new Hotbar(new Coordinate2D(getViewportWidth() / 2 - 4 * 72, 30), 9);
        addEntity(hotbar, true);

        addEntity(new Coins(new Coordinate2D(45, 50), "coins ", 0), true);

        IngameExitButton exitButton = new IngameExitButton(new Coordinate2D(getViewportWidth() / 2+ 25, getViewportHeight() / 2), homestead);
        addEntity(exitButton, true);
        GetBackButton getBackButton = new GetBackButton(new Coordinate2D(getViewportWidth() / 2 - 325, getViewportHeight() / 2), exitButton);
        addEntity(getBackButton, true);

        LeaveGameButton leaveGameButton= new LeaveGameButton(new Coordinate2D(getViewportWidth() - 100, 50), exitButton, getBackButton);
        addEntity(leaveGameButton, true);

    }

    @Override
    public void explicitUpdate(final long timestamp) {
        var playerLocation = player.getAnchorLocation();
        setScrollPosition(playerLocation);
    }

    public void setupTileMaps() {
        addTileMap(groundLayerMap);
        addTileMap(topLayerMap);
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        System.out.println("Tile clicked at: " + coordinate2D);

        switch (Hotbar.getSelectedSlot()) {
            case 2 -> {
                var carrot = new Carrot(coordinate2D);
                addEntity(carrot);
            }
            case 3 -> {
                var corn = new Corn(coordinate2D);
                addEntity(corn);
            }
            case 4 -> {
                var tomato = new Tomato(coordinate2D);
                addEntity(tomato);
            }
            case 5 -> {
                var strawberry = new Strawberry(coordinate2D);
                addEntity(strawberry);
            }
            case 6 -> {
                var pumpkin = new Pumpkin(coordinate2D);
                addEntity(pumpkin);
            }
            default -> {
            }
        }
    }

}
