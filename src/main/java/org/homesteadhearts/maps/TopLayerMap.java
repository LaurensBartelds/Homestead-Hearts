package org.homesteadhearts.maps;

import com.github.hanyaeger.api.scenes.TileMap;
import org.homesteadhearts.maps.tiles.ClickableTile;
import org.homesteadhearts.maps.tiles.Tiles;

public class TopLayerMap extends TileMap {

    public enum TopTileType {
        EMPTY(0),
        FLOWERS(2),
        FARM_LAND_1(16),
        FARM_LAND_2(17),
        FARM_LAND_3(18),
        GRASS_1(19),
        GRASS_2(20),
        GRASS_3(21),
        GRASS_4(22),
        GRASS_5(23),
        GRASS_6(24),
        GRASS_7(25);

        private final int VALUE;

        TopTileType(int value) {
            this.VALUE = value;
        }

        public int getValue() {
            return VALUE;
        }
    }

    public TopLayerMap() {
        super();
    }

    @Override
    public void setupEntities() {
        addEntity(TopTileType.EMPTY.getValue(), ClickableTile.class, "sprites/tiles/individual_tiles/empty.png");
        // Add farm land variants
        addEntity(TopTileType.FARM_LAND_1.getValue(), ClickableTile.class, "sprites/tiles/individual_tiles/farm-land-1.png");
        addEntity(TopTileType.FARM_LAND_2.getValue(), Tiles.class, "sprites/tiles/individual_tiles/farm-land-2.png");
        addEntity(TopTileType.FARM_LAND_3.getValue(), Tiles.class, "sprites/tiles/individual_tiles/farm-land-3.png");

        // Add flower tiles
        addEntity(TopTileType.FLOWERS.getValue(), Tiles.class, "sprites/tiles/individual_tiles/flowers-1.png");

        // Add grass variants   -- hier kan je for-loop van maken
        addEntity(TopTileType.GRASS_1.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-1.png");
        addEntity(TopTileType.GRASS_2.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-2.png");
        addEntity(TopTileType.GRASS_3.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-3.png");
        addEntity(TopTileType.GRASS_4.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-4.png");
        addEntity(TopTileType.GRASS_5.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-5.png");
        addEntity(TopTileType.GRASS_6.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-6.png");
        addEntity(TopTileType.GRASS_7.getValue(), Tiles.class, "sprites/tiles/individual_tiles/grass-7.png");
    }

    private int[][] currentMap;

    @Override
    public int[][] defineMap() {
        if (currentMap == null ) {
            currentMap = createInitialMap();
        }
        return currentMap;
    }

    private int[][] createInitialMap() {
        return new int[][]{
                {2, 2, 19, 0, 20, 0, 0, 21, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 19, 0, 0, 20, 0, 23, 0, 0, 22, 0, 24, 0},
                {2, 2, 0, 20, 0, 23, 0, 0, 22, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 20, 0, 0, 19, 0, 22, 0, 0},
                {0, 21, 0, 0, 19, 0, 22, 0, 0, 21, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 19, 0, 0, 22, 0, 0, 19, 0, 21},
                {0, 0, 22, 0, 0, 20, 0, 19, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 19, 0, 0, 20, 0, 0, 23, 0, 0, 19},
                {21, 0, 0, 20, 0, 0, 22, 0, 23, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 22, 0, 0, 20, 0, 19, 0, 0, 22, 0, 0},
                {0, 23, 0, 0, 19, 0, 0, 21, 0, 20, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 19, 0, 0, 23, 0, 0, 0, 21, 0, 0, 19, 0},
                {0, 0, 19, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 21, 0, 19, 0, 0, 22, 0, 0},
                {21, 0, 0, 22, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 23, 0, 0, 21, 0, 0, 19},
                {0, 22, 0, 0, 19, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 23, 0, 0, 20, 0, 0, 19, 0, 21},
                {0, 19, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 22, 0, 0, 19, 0, 0, 20, 0},
                {23, 0, 0, 21, 0, 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0},
                {0, 20, 0, 0, 19, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 19, 0, 0, 23, 0, 0, 19},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 22, 0},
                {0, 21, 0, 0, 20, 19, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 20, 0, 0, 19, 0, 0, 23, 0, 0},
                {0, 0, 19, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 19, 0, 0, 0, 0, 23, 0, 0, 21, 20, 0, 0, 22},
                {23, 0, 0, 21, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 16, 0, 0, 0, 23, 0, 0, 0, 0, 19, 0, 0, 21, 0, 0, 19, 0, 0, 20},
                {0, 20, 0, 0, 22, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 16, 0, 0, 19, 0, 0, 22, 0, 0, 0, 23, 0, 0, 21, 0, 0, 19, 0, 0},
                {0, 0, 23, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 16, 16, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 20, 0, 0, 23, 0},
                {19, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 22, 0, 0, 19, 0, 0, 21, 0, 0},
                {0, 21, 0, 0, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 19, 0, 0, 20, 0, 0, 22, 0, 0},
                {0, 0, 20, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 23, 0, 0, 19, 0},
                {0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {2, 2, 19, 0, 0, 23, 0, 0, 21, 0, 0, 22, 0, 0, 19, 0, 0, 20, 0, 0, 23, 0, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 20, 0, 0, 19, 0, 0},
                {2, 2, 0, 21, 0, 0, 19, 0, 0, 22, 0, 0, 20, 0, 0, 23, 0, 0, 21, 0, 0, 19, 0, 0, 22, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0, 20, 0},
                {2, 2, 21, 0, 0, 22, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0, 19, 0, 0, 20, 0, 0, 23, 0, 0, 21, 0, 0, 19, 0, 0, 20, 0, 0, 22, 0, 0},
                {2, 2, 0, 22, 22, 0, 0, 20, 0, 0, 23, 0, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 20, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0, 19, 0, 0, 20},
                {2, 2, 20, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0, 20, 0, 0, 22, 0, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 20, 0, 0, 19, 0, 0, 23, 0, 0},
                {2, 2, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 19, 0, 0, 23, 0, 0, 20, 0, 0, 22, 0, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 20, 0, 0, 19, 0},
                {2, 2, 23, 0, 0, 19, 0, 0, 21, 0, 0, 20, 0, 0, 22, 0, 0, 19, 0, 0, 19, 0, 0, 21, 0, 0, 23, 0, 0, 19, 0, 0, 20, 0, 0, 22, 0, 0},
                {2, 2, 0, 22, 0, 0, 20, 0, 0, 23, 0, 0, 19, 0, 0, 21, 0, 0, 20, 0, 0, 22, 23, 0, 0, 19, 0, 0, 21, 0, 0, 22, 0, 0, 20, 0, 0, 19},
                {2, 2, 19, 0, 0, 21, 0, 0, 22, 0, 0, 19, 0, 0, 23, 0, 0, 21, 0, 0, 20, 0, 0, 19, 0, 0, 22, 0, 0, 20, 0, 0, 23, 0, 0, 19, 0, 21}
        };
    }
}