package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.maps.tiles.TileManager;

public class Hoe extends Tool {
    private final TileManager tileManager;

    public Hoe(String name, String description, int level, int inSlot, String material, TileManager tileManager) {
        super(name, description, level, inSlot, material);
        this.tileManager = tileManager;
    }

    @Override
    public void setupEntities() {
        // Implementation here
    }

    @Override
    public void useTool(Coordinate2D position) {
        changeLand(position);
    }

    @Override
    public void useTool() {
        // Default implementation when no position is provided
        // Could use a default position or log a message that position is required
        System.out.println("Hoe requires a position to be used");
    }

    public void changeLand(Coordinate2D position) {
        tileManager.plowTile(position);
        System.out.println("Changed Land at position: " + position);
    }
}