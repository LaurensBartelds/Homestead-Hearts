package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;

import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.entities.crops.carrot.Carrot;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;


public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer {

    private Player player;
    private Bunny bunny;


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

        bunny = new Bunny(new Coordinate2D(1000, 1000));
        addEntity(bunny);

        Carrot carrot = new Carrot(new Coordinate2D(1000, 1000));
        addEntity(carrot);

        player = new Player(new Coordinate2D(1000, 1000));
        addEntity(player);

        Hotbar hotbar = new Hotbar(new Coordinate2D(1000, 1000), 9);
        hotbar.getSlots().forEach(this::addEntity);
    }



    @Override
    public void addEntity(final YaegerEntity yaegerEntity) {
        super.addEntity(yaegerEntity);
    }


    @Override
    public void explicitUpdate(final long timestamp) {
        var bunnyLocation = bunny.getAnchorLocation();
        setScrollPosition(bunnyLocation);
    }

    public void setupTileMaps() {
        addTileMap(new GroundLayerMap());
        addTileMap(new TopLayerMap());
    }
}