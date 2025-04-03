package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;

public class GetBackButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final IngameExitButton leaveGameButton;

    public GetBackButton(Coordinate2D initialLocation, IngameExitButton leaveGameButton) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(300, 300), 4,4);
        this.leaveGameButton = leaveGameButton;
        setCurrentFrameIndex(7);
        setButtonVisible(false);

    }


    public void setButtonVisible(boolean visible) {
        // Default: hidden
        setVisible(visible); // Use Yaeger’s setVisible() method
    }
    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if (leaveGameButton != null) {
            leaveGameButton.setButtonVisible(false); // Make exit button visible
            setButtonVisible(false);
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
