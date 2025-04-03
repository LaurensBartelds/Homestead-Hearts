package org.homesteadhearts.entities.buttons.menu;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.HomesteadHearts;

public class StartButton extends SpriteEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final HomesteadHearts HOMESTEAD;

    public StartButton(Coordinate2D initialLocation, HomesteadHearts HOMESTEAD) {
        super("sprites/ui/button_maker.png", initialLocation, new Size(200, 200), 5,4);
        setCurrentFrameIndex(0);
        this.HOMESTEAD = HOMESTEAD;

    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        HOMESTEAD.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setCursor(Cursor.DEFAULT);
    }
}