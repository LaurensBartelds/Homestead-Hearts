package org.homesteadhearts.entities.crops.seed;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class SeedSprite extends DynamicSpriteEntity {
    protected SeedSprite(Coordinate2D initialLocation) {
        super("sprites/farming/crops.png", initialLocation, new Size(100, 100), 37, 6);
    }
}
