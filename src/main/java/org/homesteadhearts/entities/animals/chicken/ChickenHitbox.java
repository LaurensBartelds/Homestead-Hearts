package org.homesteadhearts.entities.animals.chicken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class ChickenHitbox extends DynamicRectangleEntity implements Collider {

    public ChickenHitbox(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);
    }
}