package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class IngameExitButton extends SpriteEntity implements MouseButtonPressedListener {
    private int currentFrame = 1;

    public IngameExitButton(Coordinate2D initialLocation) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(80, 80), 5,4);


        setCurrentFrameIndex(currentFrame);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        System.exit(0);
    }


    void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;

    }
}
