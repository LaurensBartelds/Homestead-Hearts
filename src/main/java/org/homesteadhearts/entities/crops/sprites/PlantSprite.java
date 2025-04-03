package org.homesteadhearts.entities.crops.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlantSprite extends DynamicSpriteEntity {

    public PlantSprite(Coordinate2D initialLocation, int frameIndex) {
        super("sprites/farming/crops.png", initialLocation, new Size(100, 100), 37, 6);
        setCurrentFrameIndex(frameIndex);
    }
}
