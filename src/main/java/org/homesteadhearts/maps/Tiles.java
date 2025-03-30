package org.homesteadhearts.maps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

public class Tiles extends SpriteEntity {

    public Tiles(Coordinate2D initialPosition, Size size, String image) {
        super(image, initialPosition, size);
    }
}
