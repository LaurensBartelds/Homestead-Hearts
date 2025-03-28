package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import javafx.scene.paint.Color;

public class CarrotHitbox extends DynamicRectangleEntity implements Collider {

    public CarrotHitbox(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(50);
        setHeight(80);
        setFill(Color.TRANSPARENT);
    }
}
