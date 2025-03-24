package org.homesteadhearts.entities.crops.wheat;

import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class WheatSprite extends DynamicSpriteEntity {
    public WheatSprite(Coordinate2D location) {
        super("sprites/crops/wheat.png", location);
    }
}
