package org.homesteadhearts.maps.tiles;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class ClickableTile extends SpriteEntity implements MouseButtonPressedListener {

    public ClickableTile(Coordinate2D initialPosition, Size size, String image) {
        super(image, initialPosition, size);
    }

    @Override
    public void onMouseButtonPressed(final MouseButton button, final Coordinate2D coordinate2D) {
        if (org.homesteadhearts.entities.gui.component.Hotbar.getSelectedSlot() == 1) {
            System.out.println("Tile clicked at: " + coordinate2D);
        }
    }
}