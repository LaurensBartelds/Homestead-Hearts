package org.homesteadhearts.entities.GUI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.entities.tools.hoe.Hoe;
import org.homesteadhearts.entities.tools.hoe.WateringCan;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Hotbar extends CompositeEntity implements KeyListener, MouseButtonPressedListener {
    private final List<RectangleEntity> slots;
    private final int numberOfSlots;
    private final List<Tool> toolSlot = new ArrayList<>();

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

        // Populate the toolSlot field after the slots have been created.
        addToolsToToolbar();
    }

    public void addToolsToToolbar(){
        // Remove the local variable declaration; add directly to the field.
        toolSlot.add(new Hoe("Wooden Hoe", "Plow description", 1, 0));
        toolSlot.add(new WateringCan("Wooden wateringcan", "CAN water your plants", 1, 1));
        toolSlot.add(new Hoe("Iron Hoe", "Hoe description", 2, 2));
        toolSlot.add(new WateringCan("Iron wateringcan", "CAN water your plants", 2, 3));
        toolSlot.add(new Hoe("Metal Hoe", "Hoe description", 3, 4));
        toolSlot.add(new WateringCan("Metal wateringcan", "CAN water your plants", 3, 5));
        toolSlot.add(new Hoe("Crystal Hoe", "Hoe description", 4, 6));
        toolSlot.add(new WateringCan("Crystal wateringcan", "CAN water your plants", 4, 7));
        toolSlot.add(new Hoe("Diamond Hoe", "Hoe description", 5, 8));
        toolSlot.add(new WateringCan("Diamond wateringcan", "CAN water your plants", 5, 9));

        // Optional: Verify the tool types
        System.out.println(toolSlot.get(1).getClass().getName());
    }

    public void selectSlot(int index) {
        for (int i = 0; i < slots.size(); i++) {
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

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        for (int i = 0; i < slots.size(); i++) {
            RectangleEntity slot = slots.get(i);
            // Check if the mouse click is within the bounds of the slot.
            if (slot.getAnchorLocation().getX() <= coordinate2D.getX() &&
                    coordinate2D.getX() <= slot.getAnchorLocation().getX() + slot.getWidth() &&
                    slot.getAnchorLocation().getY() <= coordinate2D.getY() &&
                    coordinate2D.getY() <= slot.getAnchorLocation().getY() + slot.getHeight()) {
                selectSlot(i);
                System.out.println("Slot " + ( i + 1)  + " selected.");

                // It’s a good idea to check we have a tool at this slot.
                if (i < toolSlot.size() && toolSlot.get(i) != null) {
                    Tool tool = toolSlot.get(i);
                    System.out.println("Tool name: " + tool.getName());
                } else {
                    System.out.println("No tool assigned to this slot.");
                }
                break;
            }
        }
    }
}
