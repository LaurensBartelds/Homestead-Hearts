package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class PlayerSprite extends DynamicSpriteEntity implements KeyListener {

    public PlayerSprite(Coordinate2D location) {
        super("sprites/avatar/player.png", location, new Size(200,200), 1,2);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if (pressedKeys.contains(KeyCode.A)) {
            setMotion(3, 270d);
            setCurrentFrameIndex(0);
        } else if (pressedKeys.contains(KeyCode.D)) {
            setMotion(3, 90d);
            setCurrentFrameIndex(1);
        } else if (pressedKeys.contains(KeyCode.W)) {
            setMotion(3, 180d);
        } else if (pressedKeys.contains(KeyCode.S)) {
            setMotion(3, 0d);
        } else if(pressedKeys.isEmpty()){
            setMotion(0,0);
        }
    }
}
