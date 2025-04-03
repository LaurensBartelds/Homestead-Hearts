package org.homesteadhearts.entities.tools.wateringCan;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class WateringCanSprite extends DynamicSpriteEntity {
    public WateringCanSprite(Coordinate2D location, int sprite) {
        super("sprites/tools/item_bucket_narrow_water.png", location, new Size(75, 75));
        setCurrentFrameIndex(sprite);
    }
}
