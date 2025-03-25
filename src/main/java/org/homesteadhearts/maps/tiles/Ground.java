package org.homesteadhearts.maps.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Ground extends SpriteEntity {

    public Ground(Coordinate2D initialPosition, Size size, String image, int rows, int columns) {
        super(image, initialPosition, size, rows, columns);
        setCurrentFrameIndex(0);
    }

    public void setTile(int row, int column, int totalColumns) {
        int index = (row * totalColumns) + column;
        setCurrentFrameIndex(index);
    }
}