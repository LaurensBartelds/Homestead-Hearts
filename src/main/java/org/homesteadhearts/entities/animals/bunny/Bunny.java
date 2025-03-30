package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Bunny extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider, KeyListener {

    public Bunny(Coordinate2D location) {
        super(location);
    }

    private BunnySprite sprite;

    @Override
    protected void setupEntities() {
        sprite = new BunnySprite(new Coordinate2D(30, 0));
        addEntity(sprite);

        BunnyHitbox bunnyHitbox = new BunnyHitbox(new Coordinate2D(30, 0));
        addEntity(bunnyHitbox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(5, 270d);
            sprite.setAuto(3, 100);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(5, 90d);
            sprite.setAuto(2, 100);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(5, 180d);
            sprite.setAuto(1, 100);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(5, 0d);
            sprite.setAuto(0, 100);
        } else if (pressedKeys.isEmpty()) {
            setMotion(0, 0);
            sprite.setAuto(4, 500);
        }

    }

}