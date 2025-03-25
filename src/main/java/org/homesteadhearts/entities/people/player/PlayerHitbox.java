package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

import java.util.List;

public class PlayerHitbox extends RectangleEntity implements Collided {
    public PlayerHitbox(final Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(50);
        setHeight(80);
        setFill(Color.RED);
    }

    @Override
    public void onCollision(List<Collider> list) {

    }
}
