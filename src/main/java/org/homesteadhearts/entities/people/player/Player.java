package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.homesteadhearts.maps.tiles.TileManager;

import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener, Collider {
    private PlayerSprite sprite;
    private TileManager tileManager;
    private boolean hasHoe = true; // For simplicity, player starts with a hoe
    private int selectedTool = 0; // 0 = no tool, 1 = hoe, etc.

    public Player(Coordinate2D location, int playerCoinAmountText) {
        super(location );

    }

    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    protected void setupEntities() {
        sprite = new PlayerSprite(new Coordinate2D(0, 0), this);
        addEntity(sprite);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // Handle movement (using existing code from the Bunny class as example)
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(4, 270d);
            sprite.setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(4, 90d);
            sprite.setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(4, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(4, 0d);
        } else if (pressedKeys.isEmpty()) {
            setMotion(0, 0);
        }

        // Handle tile interaction
        if (pressedKeys.contains(KeyCode.SPACE) && selectedTool == 1 && tileManager != null) {
            // Plow the tile the player is standing on
            tileManager.plowTile(getAnchorLocation());
        }

        // Tool selection
        if (pressedKeys.contains(KeyCode.DIGIT1)) {
            selectedTool = 1; // Select hoe
        } else if (pressedKeys.contains(KeyCode.DIGIT0)) {
            selectedTool = 0; // No tool
        }
    }

    public boolean canMove() {
        return true;
    }
}