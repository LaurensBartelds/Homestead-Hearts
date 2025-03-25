package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class CarrotSprite extends DynamicSpriteEntity {
    public CarrotSprite(Coordinate2D location) {
        super("sprites/farming/crops_all.png", location, new Size(100, 100), 37, 25);
        setCurrentFrameIndex(4);
        // 0 = seed, 1 = sprout, 2 = small carrot, 3 = medium carrot, 4 = large carrot
    }
}