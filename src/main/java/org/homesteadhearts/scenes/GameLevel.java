package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

import org.homesteadhearts.entities.GUI.coins.CoinsTest;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.entities.crops.carrot.Carrot;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.tiles.TileManager;
import org.homesteadhearts.maps.TopLayerMap;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer {
    private Bunny bunny;
    private Player player;
    private GroundLayerMap groundLayerMap;
    private TopLayerMap topLayerMap;
    private TileManager tileManager;

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
        tileManager = new TileManager(groundLayerMap, topLayerMap);

        // Add entities
        bunny = new Bunny(new Coordinate2D(1000, 1000));
        addEntity(bunny);

        Carrot carrot = new Carrot(new Coordinate2D(1000, 1000));
        addEntity(carrot);

        player = new Player(new Coordinate2D(1000, 1000),500);
        player.setTileManager(tileManager);
        addEntity(player);

        // Add the hotbar with stickyOnViewPort set to true
        Hotbar hotbar = new Hotbar(new Coordinate2D(getViewportWidth()/2 - 4 * 72, 30), 9);
        addEntity(hotbar, true);

        addEntity(new CoinsTest(new Coordinate2D(100, 50)), true);
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
}