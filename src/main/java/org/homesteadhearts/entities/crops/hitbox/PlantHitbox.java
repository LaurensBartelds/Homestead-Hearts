package org.homesteadhearts.entities.crops.hitbox;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class PlantHitbox extends DynamicRectangleEntity {

    public PlantHitbox(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(100);
        setHeight(100);
        setFill(Color.TRANSPARENT);
        setStrokeColor(Color.RED);
        setStrokeWidth(2);
    }
}
