package org.homesteadhearts.maps.tiles.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Ground3 extends Ground {
    public Ground3(Coordinate2D initialPosition, Size size, String resource) {
        super(initialPosition, size, resource);
        setTile(0, 1); // Second tile
    }
}