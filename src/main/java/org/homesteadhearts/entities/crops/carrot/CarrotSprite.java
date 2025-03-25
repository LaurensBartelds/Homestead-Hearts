package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class CarrotSprite extends DynamicSpriteEntity {
    public CarrotSprite(Coordinate2D location) {
        super("sprites/farming/crops_all.png", location, new Size(100, 100), 37, 25);
        setCurrentFrameIndex(6);
        // 0 = seedpack, 1= seeds, 2 = carrot ontkiem, 3 = carrot kiem, 4 = carrot growing, 5 = carrot full, 6 = full grown carrot
    }
}