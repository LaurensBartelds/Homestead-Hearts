package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.GUI.coins.CoinsTest;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.animals.chicken.Chicken;
import org.homesteadhearts.entities.crops.Crops;
import org.homesteadhearts.entities.crops.Seed;
import org.homesteadhearts.entities.crops.types.Carrot;
import org.homesteadhearts.entities.crops.types.Corn;
import org.homesteadhearts.entities.people.player.Player;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;
import org.homesteadhearts.maps.tiles.TileManager;

import java.lang.reflect.Constructor;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer, TileMapContainer, MouseButtonPressedListener {
    private TopLayerMap topLayerMap;
    private Bunny bunny;
    private Chicken chicken;
    private Player player;
    private GroundLayerMap groundLayerMap;
    private Hotbar hotbar;

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

        hotbar = new Hotbar(new Coordinate2D(getViewportWidth() / 2 - 4 * 72, 30), 9);

        bunny = new Bunny(new Coordinate2D(1000, 1000), player);
        addEntity(bunny);
        chicken = new Chicken(new Coordinate2D(1200, 1200) , 270 );
        addEntity(chicken);

        Hotbar hotbar = new Hotbar(new Coordinate2D(getViewportWidth() / 2 - 4 * 72, 30), 9);
        addEntity(hotbar, true);

        addEntity(new CoinsTest(new Coordinate2D(100, 30), "coins ", 50), true);
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
        Tool selectedItem = hotbar.getSelectedItem();

        if (selectedItem instanceof Seed seed) {
            try {
                Class<? extends Crops> cropClass = seed.getCropType();
                Constructor<? extends Crops> constructor = cropClass.getConstructor(Coordinate2D.class);
                Crops crop = constructor.newInstance(coordinate2D);
                addEntity(crop);
                System.out.println("Planted " + cropClass.getSimpleName());
            } catch (Exception e) {
                System.out.println("Failed to plant crop: " + e.getMessage());
            }
        }
    }
}
