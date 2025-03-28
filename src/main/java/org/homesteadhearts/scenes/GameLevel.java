package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.maps.GameLevelMap;
import org.homesteadhearts.entities.crops.carrot.Carrot;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer {

    private Bunny bunny;
    private Carrot carrot;
    private Player player;

    public GameLevel() {
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.WHITE);
        setSize(new Size(2000, 2000));
        setRelativeScrollPosition(0.5, 0.5);
    }

    @Override
    public void setupEntities() {
        bunny = new Bunny(new Coordinate2D(1000, 1000));
        addEntity(bunny);

        Carrot carrot = new Carrot(new Coordinate2D(1000, 1000));
        addEntity(carrot);

        player = new Player(new Coordinate2D(1000,1000));
        addEntity(player);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        // Use player's location instead of bunny's location for scrolling
        var playerLocation = player.getAnchorLocation();
        setScrollPosition(playerLocation);
    }

    public void setupTileMaps(){
        addTileMap(new GameLevelMap());
    }
}