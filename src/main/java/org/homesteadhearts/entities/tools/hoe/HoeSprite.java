package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class HoeSprite extends DynamicSpriteEntity {
    public HoeSprite(Coordinate2D location, int sprite) {
        super("sprites/farming/item_carry.png", location, new Size(75, 75), 12, 10);
        setCurrentFrameIndex(sprite);
//hiervoor nodig: een spritesheet met 3x6 en dan setAutocycleRow elke keer +1 bij een hoger level
    }
}
