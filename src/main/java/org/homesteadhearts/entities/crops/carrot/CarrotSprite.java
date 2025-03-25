package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class CarrotSprite extends DynamicSpriteEntity {
    public CarrotSprite(Coordinate2D location) {
        super("sprites/farming/crops_all.png", location, new Size(100, 100), 37, 25);
        setAutoCycleRow(4);
    }
}