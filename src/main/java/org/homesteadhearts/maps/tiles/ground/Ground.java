package org.homesteadhearts.maps.tiles.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Ground extends SpriteEntity {
    protected static final int ROWS = 30;
    protected static final int COLUMNS = 30;

    public Ground(Coordinate2D initialPosition, Size size, String resource) {
        super(resource, initialPosition, size, ROWS, COLUMNS);
        setCurrentFrameIndex(0);
    }

    public void setTile(int row, int column) {
        int index = (row * COLUMNS) + column;
        setCurrentFrameIndex(index);
    }
}