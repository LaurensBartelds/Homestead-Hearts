package org.homesteadhearts.entities.tools.fertilizer;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class FertilizerSprite extends DynamicSpriteEntity {
    public FertilizerSprite(Coordinate2D location, int sprite) {
        super("sprites/tools/item_bucket_narrow_slime.png", location, new com.github.hanyaeger.api.Size(75, 75));
        setCurrentFrameIndex(sprite);
    }
}
