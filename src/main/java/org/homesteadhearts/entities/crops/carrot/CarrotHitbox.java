package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.tools.Tool;

public class CarrotHitbox extends DynamicRectangleEntity implements Collider {

    public CarrotHitbox(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(50);
        setHeight(80);
        setFill(Color.TRANSPARENT);
    }


}
