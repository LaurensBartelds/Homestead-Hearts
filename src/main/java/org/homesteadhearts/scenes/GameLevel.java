package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.GUI.ChickenPoints;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.GUI.coins.CoinsTest;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.animals.chicken.Chicken;
import org.homesteadhearts.entities.crops.types.*;
import org.homesteadhearts.entities.buttons.menu.IngameExitButton;

import org.homesteadhearts.entities.crops.types.Carrot;
import org.homesteadhearts.entities.crops.types.Corn;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;
import org.homesteadhearts.maps.tiles.TileManager;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer, MouseButtonPressedListener {
    private TopLayerMap topLayerMap;
    private Player player;
    private GroundLayerMap groundLayerMap;

    public GameLevel() {
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
        TileManager tileManager = new TileManager(groundLayerMap, topLayerMap);

        // Add entities
        player = new Player(new Coordinate2D(1000, 1000), 500);
        player.setTileManager(tileManager);
        addEntity(player);

        ChickenPoints points = new ChickenPoints(new Coordinate2D(50, 100), "points: ", 0);
        addEntity(points, true);


        Bunny bunny = new Bunny(new Coordinate2D(1000, 1000), player);
        addEntity(bunny);
        Chicken chicken1 = new Chicken(new Coordinate2D(1200, 300), 90, points);
        Chicken chicken2 = new Chicken(new Coordinate2D(1200, 700), 270, points);
        Chicken chicken3 = new Chicken(new Coordinate2D(1200, 1100), 90, points);


        addEntity(chicken1);addEntity(chicken2);addEntity(chicken3);

        Hotbar hotbar = new Hotbar(new Coordinate2D(getViewportWidth() / 2 - 4 * 72, 30), 9);
        addEntity(hotbar, true);

        addEntity(new CoinsTest(new Coordinate2D(50, 50), "coins ", 50), true);

        IngameExitButton exitButton = new IngameExitButton(new Coordinate2D(getViewportWidth() - 85, 35));
        addEntity(exitButton, true);
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
            case 1 -> {
                var carrot = new Carrot(coordinate2D);
                addEntity(carrot);
            }
            case 2 -> {
                var corn = new Corn(coordinate2D);
                addEntity(corn);
            }
            case 3 -> {
                var tomato = new Tomato(coordinate2D);
                addEntity(tomato);
            }
            case 4 -> {
                var strawberry = new Strawberry(coordinate2D);
                addEntity(strawberry);
            }
            case 5 -> {
                var pumpkin = new Pumpkin(coordinate2D);
                addEntity(pumpkin);
            }
            default -> {
            }
        }
    }

}
