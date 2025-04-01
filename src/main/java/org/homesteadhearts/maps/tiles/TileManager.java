package org.homesteadhearts.maps.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.maps.GroundLayerMap;
import org.homesteadhearts.maps.TopLayerMap;

public class TileManager {
    private static final int TILE_SIZE = 75; // Adjust based on your tile size
    private final GroundLayerMap groundMap;
    private final TopLayerMap topMap;

    public TileManager(GroundLayerMap groundMap, TopLayerMap topMap) {
        this.groundMap = groundMap;
        this.topMap = topMap;
    }

    public void plowTile(Coordinate2D position) {
        // Convert world position to tile indices
        int tileX = (int) (position.getX() / TILE_SIZE);
        int tileY = (int) (position.getY() / TILE_SIZE);

        // Check if the position is valid within the map
        if (isValidTilePosition(tileX, tileY)) {
            // Clear top layer (remove grass/flowers)
            topMap.setTileValue(tileX, tileY, TopLayerMap.TopTileType.EMPTY.getValue());

            // Set farmland in top layer
            topMap.setTileValue(tileX, tileY, TopLayerMap.TopTileType.FARM_LAND_1.getValue());

        }
    }

    private boolean isValidTilePosition(int x, int y) {
        int[][] topMapData = topMap.defineMap();
        return y >= 0 && y < topMapData.length && x >= 0 && x < topMapData[0].length;
    }

    public GroundLayerMap getGroundMap() {
        return groundMap;
    }
}