package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.GUI.Hotbar;
import org.homesteadhearts.entities.crops.CropsInteractionText;
import org.homesteadhearts.entities.tools.Tool;

import java.awt.*;

public class CarrotHitbox extends DynamicRectangleEntity implements Collider, MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
int initialPositionX;
int initialPositionY;
private TextEntity interactionCarrotText;
private Hotbar hotbar;

    public CarrotHitbox(Coordinate2D initialPosition, Hotbar hotbar) {
        super(initialPosition);
        this.initialPositionX = (int) initialPosition.getX();
        this.initialPositionY = (int) initialPosition.getY();
        setWidth(50);
        setHeight(50);
        setFill(Color.TRANSPARENT);

    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        System.out.println("MousePressed test carrot");
//        hotbar.useTool();

    }
    @Override
    public void onMouseEntered() {
        setStrokeColor(Color.ORANGE);
        setStrokeWidth(5);
        setCursor(Cursor.HAND);

//        CropsInteractionText cropsInteractionText = new CropsInteractionText(new Coordinate2D(getPositionX(),getPositionY()), "Click to interact");
//        System.out.println(cropsInteractionText.getText() + " dit moet later op scherm komen!  " + MouseInfo.getPointerInfo().getLocation().getX() );
    }

    @Override
    public void onMouseExited() {
       setStrokeColor(Color.TRANSPARENT);
        setCursor(Cursor.DEFAULT);

    }

}
