package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class BunnySprite extends DynamicSpriteEntity {

    public BunnySprite(Coordinate2D location) {
        super("sprites/animals/bunny_animations.png", location, new Size(75, 75), 5, 4);
        setAutoCycleRow(4);
        setAutoCycle(500);
    }

    public void setAuto(int row, int duration) {
        super.setAutoCycleRow(row);
        super.setAutoCycle(duration);
    }
}
