package org.homesteadhearts.entities.animals.chicken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class ChickenSprite extends DynamicSpriteEntity {

    public ChickenSprite(Coordinate2D location) {
        super("sprites/animals/chicken_animation.png", location, new Size(75, 75), 5, 4);
        setAuto(4, 500);
    }

    public void setAuto(int row, int duration) {
        super.setAutoCycleRow(row);
        super.setAutoCycle(duration);
    }

    public void setAutoCycleRow(int row) {
        super.setAutoCycleRow(row);
    }

    public int getAutoCycleRow() {
        return super.getAutoCycleRow();
    }
}