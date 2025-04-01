package org.homesteadhearts.entities.tools.axe;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class AxeSprite extends DynamicSpriteEntity {

    public AxeSprite(Coordinate2D location, int sprite) {
        super("sprites/farming/crops_winter_wet.png", location, new Size(75, 75), 37, 6);
        setCurrentFrameIndex(sprite);

        {


        }
    }
}
