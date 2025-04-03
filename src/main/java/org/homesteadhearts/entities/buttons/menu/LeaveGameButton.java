package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;

public class LeaveGameButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final IngameExitButton leaveGameButton;
    private final GetBackButton getBackButton;

    public LeaveGameButton(Coordinate2D initialLocation, IngameExitButton leaveGameButton, GetBackButton GetBackButton) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(80, 80), 5,4);
        this.leaveGameButton = leaveGameButton;
        this.getBackButton = GetBackButton;
        setCurrentFrameIndex(5);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (leaveGameButton != null) {
            leaveGameButton.setButtonVisible(true); // Make exit button visible
            getBackButton.setButtonVisible(true);
            System.out.println("Exit button activated!");
        } else {
            System.out.println("Error: Exit button reference is null.");
        }
    }

    @Override
    public void onMouseEntered() {

    }

    @Override
    public void onMouseExited() {

    }
}
