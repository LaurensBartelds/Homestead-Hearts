package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.HomesteadHearts;

public class IngameExitButton extends SpriteEntity implements MouseButtonPressedListener {
    private final HomesteadHearts homestead;

    public IngameExitButton(Coordinate2D initialLocation, HomesteadHearts homestead) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(300, 300), 5,4);
        setButtonVisible(false);
        this.homestead = homestead;
        int currentFrame = 1;
        setCurrentFrameIndex(currentFrame);
    }


    public void setButtonVisible(boolean visible) {
        setVisible(visible);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        homestead.setActiveScene(2);
    }
}
