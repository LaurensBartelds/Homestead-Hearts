package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class HoeSprite extends DynamicSpriteEntity {
    public HoeSprite(Coordinate2D location) {
        super("sprites/farming/scarecrows.png", location, new Size(75, 75), 1, 1);
        setAutoCycleRow(4);
        setAutoCycle(500);
    }
}
