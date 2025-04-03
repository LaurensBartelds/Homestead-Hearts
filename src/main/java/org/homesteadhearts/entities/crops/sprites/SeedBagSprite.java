package org.homesteadhearts.entities.crops.sprites;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SeedBagSprite extends DynamicSpriteEntity {

    public SeedBagSprite(Coordinate2D initialLocation, int frameIndex) {
        super("sprites/farming/seed.png", initialLocation, new Size(75, 75), 6, 7);
        setCurrentFrameIndex(frameIndex);
    }
}
