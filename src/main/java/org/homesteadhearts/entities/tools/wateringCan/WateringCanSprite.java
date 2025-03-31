package org.homesteadhearts.entities.tools.wateringCan;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class WateringCanSprite extends DynamicSpriteEntity {
    public WateringCanSprite(Coordinate2D location, int sprite) {
        super("sprites/farming/scarecrows.png", location, new Size(75, 75), 3, 6);
        setCurrentFrameIndex(sprite);
    }
}
