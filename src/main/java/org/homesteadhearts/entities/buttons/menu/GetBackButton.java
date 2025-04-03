package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class GetBackButton extends SpriteEntity implements MouseButtonPressedListener{
    private final IngameExitButton LEAVE_GAME_BUTTON;

    public GetBackButton(Coordinate2D initialLocation, IngameExitButton LEAVE_GAME_BUTTON) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(300, 300), 4,4);
        this.LEAVE_GAME_BUTTON = LEAVE_GAME_BUTTON;
        setCurrentFrameIndex(7);
        setButtonVisible(false);

    }


    public void setButtonVisible(boolean visible) {
        setVisible(visible);
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (LEAVE_GAME_BUTTON != null) {
            LEAVE_GAME_BUTTON.setButtonVisible(false); // Make exit button visible
            setButtonVisible(false);
            System.out.println("Exit button activated!");
        } else {
            System.out.println("Error: Exit button reference is null.");
        }
    }


}
