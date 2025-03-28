package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class BunnySprite extends DynamicSpriteEntity implements KeyListener {

    public BunnySprite(Coordinate2D location) {
        super("sprites/animals/bunny_animations.png", location, new Size(75, 75), 5, 4);
        setAutoCycleRow(4);
        setAutoCycle(500);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.LEFT)) {
            setMotion(3, 270d);
            setAutoCycleRow(3);
            setAutoCycle(125);
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            setMotion(3, 90d);
            setAutoCycleRow(2);
            setAutoCycle(125);
        } else if (pressedKeys.contains(KeyCode.UP)) {
            setMotion(3, 180d);
            setAutoCycleRow(1);
            setAutoCycle(125);
        } else if (pressedKeys.contains(KeyCode.DOWN)) {
            setMotion(3, 0d);
            setAutoCycleRow(0);
            setAutoCycle(125);
        } else if (pressedKeys.isEmpty()) {
            setMotion(0, 0);
            setAutoCycleRow(4);
            setAutoCycle(500);
        }

    }
}
