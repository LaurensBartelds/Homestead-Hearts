package org.homesteadhearts.maps;

import com.github.hanyaeger.api.scenes.TileMap;

public class GameLevelMap extends TileMap {

    public GameLevelMap() {
        super();
    }

    @Override
    public void setupEntities() {
        addEntity(1, Ground.class, "sprites/tiles/individual_tiles/ground-1.png");
        addEntity(2, Ground.class, "sprites/tiles/individual_tiles/flowers-1.png");
        addEntity(3, Ground.class, "sprites/tiles/individual_tiles/path-grass-right.png");
        addEntity(4, Ground.class, "sprites/tiles/individual_tiles/path-grass-left.png");
        addEntity(5, Ground.class, "sprites/tiles/individual_tiles/path-texture-1.png");
        addEntity(6, Ground.class, "sprites/tiles/individual_tiles/path-texture-2.png");
        addEntity(7, Ground.class, "sprites/tiles/individual_tiles/path-texture-3.png");
        addEntity(8, Ground.class, "sprites/tiles/individual_tiles/path-grass-top.png");
        addEntity(9, Ground.class, "sprites/tiles/individual_tiles/path-grass-bottom.png");
        addEntity(10, Ground.class, "sprites/tiles/individual_tiles/grass-path-corner-top-left.png");
        addEntity(11, Ground.class, "sprites/tiles/individual_tiles/grass-path-corner-top-right.png");
        addEntity(12, Ground.class, "sprites/tiles/individual_tiles/path-grass-corner-bottom-right.png");
        addEntity(13, Ground.class, "sprites/tiles/individual_tiles/path-grass-corner-bottom-left.png");
        addEntity(14, Ground.class, "sprites/tiles/individual_tiles/path-grass-corner-top-left.png");
        addEntity(15, Ground.class, "sprites/tiles/individual_tiles/path-grass-corner-top-right.png");

    }

    @Override
    public int[][] defineMap() {
        return new int[][]{
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 8, 8, 8, 8, 8, 8, 8, 10, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 6, 7, 5, 7, 5, 5, 3, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 7, 5, 6, 5, 6, 6, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 7, 5, 6, 5, 5, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 4, 7, 6, 5, 5, 5, 6, 7, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 4, 6, 12, 9, 9, 9, 9, 9, 9, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 6, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 7, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 11, 8, 14, 5, 15, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 10, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 7, 5, 6, 5, 6, 6, 7, 5, 7, 6, 6, 5, 5, 7, 5, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 6, 12, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 13, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 10, 8, 8, 8, 8, 8, 8, 11, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 4, 5, 7, 6, 5, 7, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 4, 7, 15, 8, 8, 8, 8, 8, 8, 14, 6, 5, 7, 6, 5, 7, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 4, 5, 5, 6, 5, 7, 5, 5, 7, 5, 7, 5, 7, 5, 6, 7, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 6, 12, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4, 5, 12, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 13, 9, 13, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        };
    }
}