package org.homesteadhearts.maps.tiles.ground;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

public class Ground4 extends Ground {
    public Ground4(Coordinate2D initialPosition, Size size, String resource) {
        super(initialPosition, size, resource);
        setTile(0, 3); // Fourth tile
    }
}