package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class LeaveGameButton extends SpriteEntity implements MouseButtonPressedListener{
    private final IngameExitButton LEAVE_GAME_BUTTON;
    private final GetBackButton GET_BACK_BUTTON;

    public LeaveGameButton(Coordinate2D initialLocation, IngameExitButton LEAVE_GAME_BUTTON, GetBackButton GET_BACK_BUTTON) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(80, 80), 5,4);
        this.LEAVE_GAME_BUTTON = LEAVE_GAME_BUTTON;
        this.GET_BACK_BUTTON = GET_BACK_BUTTON;
        setCurrentFrameIndex(5);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (LEAVE_GAME_BUTTON != null) {
            LEAVE_GAME_BUTTON.setButtonVisible(true); // Make exit button visible
            GET_BACK_BUTTON.setButtonVisible(true);
            System.out.println("Exit button activated!");
        } else {
            System.out.println("Error: Exit button reference is null.");
        }
    }


}
