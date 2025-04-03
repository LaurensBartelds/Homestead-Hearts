package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.gui.component.ChickenPoints;
import org.homesteadhearts.entities.gui.component.Hotbar;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.animals.chicken.Chicken;
import org.homesteadhearts.entities.crops.types.*;

import org.homesteadhearts.entities.crops.types.Carrot;
import org.homesteadhearts.entities.crops.types.Corn;
import org.homesteadhearts.entities.gui.component.TopBar;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;

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
        addEntity(chicken1);addEntity(chicken2);addEntity(chicken3);

        TopBar topbar = new TopBar(new Coordinate2D(0, 0), (int) getViewportWidth());
        addEntity(topbar, true);
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
            case 3 -> {
                var carrot = new Carrot(coordinate2D);
                addEntity(carrot);
            }
            case 4 -> {
                var corn = new Corn(coordinate2D);
                addEntity(corn);
            }
            case 5 -> {
                var tomato = new Tomato(coordinate2D);
                addEntity(tomato);
            }
            case 6 -> {
                var strawberry = new Strawberry(coordinate2D);
                addEntity(strawberry);
            }
            case 7 -> {
                var pumpkin = new Pumpkin(coordinate2D);
                addEntity(pumpkin);
            }
            default -> {
            }
        }
    }

}
