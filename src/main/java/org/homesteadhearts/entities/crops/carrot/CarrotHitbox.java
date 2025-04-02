package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.crops.CropsInteractionText;
import org.homesteadhearts.entities.tools.Tool;

public class CarrotHitbox extends DynamicRectangleEntity implements Collider, MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    public CarrotHitbox(Coordinate2D initialPosition) {
        super(initialPosition);
        setWidth(50);
        setHeight(80);
        setFill(Color.TRANSPARENT);
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        System.out.println("MousePressed test carrot");
    }
    @Override
    public void onMouseEntered() {
        setFill(Color.RED);
        setCursor(Cursor.HAND);
        CropsInteractionText cropsInteractionText = new CropsInteractionText(new Coordinate2D(0, 0), "Click to interact");
        System.out.println(cropsInteractionText.getText() + " dit moet later op scherm komen" );
    }

    @Override
    public void onMouseExited() {
        setFill(Color.TRANSPARENT);
        setCursor(Cursor.DEFAULT);
    }
}
