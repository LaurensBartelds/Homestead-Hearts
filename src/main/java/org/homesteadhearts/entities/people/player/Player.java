package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import org.homesteadhearts.entities.crops.hitbox.PlantHitbox;

import java.util.List;
import java.util.Set;

public class Player extends DynamicCompositeEntity implements KeyListener, Collided {
    private PlayerSprite sprite;

    public Player(Coordinate2D location) {
        super(location );
    }

    @Override
    protected void setupEntities() {
        sprite = new PlayerSprite(new Coordinate2D(0, 0), this);
        addEntity(sprite);


    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        // Handle movement (using existing code from the Bunny class as example)
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(4, 270d);
            sprite.setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(4, 90d);
            sprite.setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(4, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(4, 0d);
        } else if (pressedKeys.isEmpty()) {
            setMotion(0, 0);
        }
    }

        @Override
        public void onCollision(List<Collider> collidingObjects) {
            for (Collider collider : collidingObjects) {
                if (collider instanceof PlantHitbox) {
                    setSpeed(0);
                    }
                }
            }
        }