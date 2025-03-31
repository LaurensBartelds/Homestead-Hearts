package org.homesteadhearts.entities.GUI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.entities.tools.plow.Plow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hotbar extends CompositeEntity implements KeyListener {
    private final List<RectangleEntity> slots;
    private final int numberOfSlots;

    public Hotbar(Coordinate2D initialLocation, int numberOfSlots) {
        super(initialLocation);
        this.numberOfSlots = numberOfSlots;
        slots = new ArrayList<>();
    }

    @Override
    public void setupEntities() {
        double slotWidth = 70;
        double slotHeight = 70;
        double spacing = 2;

        // Create individual slots
        for (int i = 0; i < numberOfSlots; i++) {
            double xPosition = i * (slotWidth + spacing);
            Coordinate2D slotPosition = new Coordinate2D(xPosition, 0);

            RectangleEntity slot = new RectangleEntity(slotPosition) {
                {
                    setWidth(slotWidth);
                    setHeight(slotHeight);
                    setFill(Color.BEIGE);
                }
            };
            slots.add(slot);
            addEntity(slot);
        }

        //-- add arrayList with tools max 9
        ArrayList<Tool> tools = new ArrayList<Tool>();
        tools.add(new Plow("Plow", "Plow description", 1, 0));
        System.out.println(tools.get(0).getName());
    }

    public void selectSlot(int index) {
        for(int i = 0; i < slots.size(); i++) {
            RectangleEntity slot = slots.get(i);
            if (i == index) {
                slot.setFill(Color.ROSYBROWN);
            } else {
                slot.setFill(Color.BEIGE);
            }
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKey) {
        if (pressedKey.contains(KeyCode.DIGIT1)) {
            selectSlot(0);
        } else if (pressedKey.contains(KeyCode.DIGIT2)) {
            selectSlot(1);
        } else if (pressedKey.contains(KeyCode.DIGIT3)) {
            selectSlot(2);
        } else if (pressedKey.contains(KeyCode.DIGIT4)) {
            selectSlot(3);
        } else if (pressedKey.contains(KeyCode.DIGIT5)) {
            selectSlot(4);
        } else if (pressedKey.contains(KeyCode.DIGIT6)) {
            selectSlot(5);
        } else if (pressedKey.contains(KeyCode.DIGIT7)) {
            selectSlot(6);
        } else if (pressedKey.contains(KeyCode.DIGIT8)) {
            selectSlot(7);
        } else if (pressedKey.contains(KeyCode.DIGIT9)) {
            selectSlot(8);
        }
    }
}