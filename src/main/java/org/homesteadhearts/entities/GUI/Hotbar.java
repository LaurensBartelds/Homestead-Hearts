package org.homesteadhearts.entities.GUI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hotbar implements KeyListener, java.awt.event.KeyListener {
    private final List<RectangleEntity> slots;


    public Hotbar(Coordinate2D initialLocation, int numberOfSlots) {
        slots = new ArrayList<>();
        double slotWidth = 50;
        double slotHeight = 50;
        double spacing = 5;

        // Create individual slots
        for (int i = 0; i < numberOfSlots; i++) {
            double xPosition = initialLocation.getX() + i * (slotWidth + spacing);
            Coordinate2D slotPosition = new Coordinate2D(xPosition, initialLocation.getY());


            RectangleEntity slot = new RectangleEntity(slotPosition) {
                {
                    setWidth(slotWidth);
                    setHeight(slotHeight);
                    setFill(Color.ROSYBROWN);
                }
            };
            slots.add(slot);
        }

    }

    public List<RectangleEntity> getSlots() {
        return slots;
    }


    public void selectSlot(int index) {
        for(int i = 0 ; i < slots.size(); i++) {
            RectangleEntity slot = slots.get(i);
            if (i == index) {
                slot.setFill(Color.RED);
            } else {
                slot.setFill(Color.ROSYBROWN);
            }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKey) {

        if (pressedKey.contains(KeyCode.DIGIT0)) {
            selectSlot(0);
            System.out.println("hello test");
//        }
//        if (pressedKey.contains(KeyCode.X)) {
//            selectSlot(1);
//
//        }
//        if (pressedKey.contains(KeyCode.C)) {
//            selectSlot(2);
//        }
//        if (pressedKey.contains(KeyCode.V)) {
//            selectSlot(3);
//        }
//        if (pressedKey.contains(KeyCode.B)) {
//            selectSlot(4);
//        }
//        if (pressedKey.contains(KeyCode.N)) {
//            selectSlot(5);
//        }
//        if (pressedKey.contains(KeyCode.M)) {
//            selectSlot(6);
//        }
//        if (pressedKey.contains(KeyCode.DIGIT7)) {
//            selectSlot(7);
//        }
//        if (pressedKey.contains(KeyCode.DIGIT8)) {
//            selectSlot(8);
//        }
//        if (pressedKey.contains(KeyCode.DIGIT9)) {
//            selectSlot(9);
       }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
