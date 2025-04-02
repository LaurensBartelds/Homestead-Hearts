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
import org.homesteadhearts.entities.tools.axe.Axe;
import org.homesteadhearts.entities.tools.hoe.Hoe;
import org.homesteadhearts.entities.tools.wateringCan.WateringCan;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Hotbar extends CompositeEntity implements KeyListener, MouseButtonPressedListener {
    private final List<RectangleEntity> slots;
    private final int numberOfSlots;
    private final List<Tool> toolSlot = new ArrayList<>();
    boolean testingTrue = true;
    static int selectedSlot = 1;

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
        addToolsToToolbar(); // test hotbar

        IntStream.range(0, Math.min(slots.size(), toolSlot.size()))
                .forEach(i -> {
                    Tool tool = toolSlot.get(i);
                    if (tool != null) {
                        RectangleEntity slot = slots.get(i);
                        Coordinate2D slotLocation = slot.getAnchorLocation();

                        // Compute offsets (assuming your sprite is 75x75)
                        double offsetX = (slot.getWidth() - 75) / 2.0;
                        double offsetY = (slot.getHeight() - 75) / 2.0;

                        // Set the tool's position relative to its slot
                        tool.setAnchorLocation(new Coordinate2D(
                                slotLocation.getX() + offsetX,
                                slotLocation.getY() + offsetY
                        ));

                        // Add the tool entity to the scene so its sprite is rendered.
                        addEntity(tool);
                    }
                });
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
        if (pressedKey.contains(KeyCode.P)) {
            emptyHotbar();
        }
        if(pressedKey.contains(KeyCode.T)){
            addToolsToToolbar();
        }
//        if(pressedKey.contains(KeyCode.E)){
//           useTool();
//        }
    }

    public void useTool() {
                    toolSlot.get(selectedSlot).useTool();
    }

    public void addToolsToToolbar() {
        if (testingTrue) {
            toolSlot.add(new WateringCan("Wooden wateringcan", "CAN water your plants", 1, 1, "Wood"));
            toolSlot.add(new Hoe("Iron Hoe", "Hoe description", 1, 2, "Wood"));
            toolSlot.add(new Axe("Wooden Axe", "Axe description", 1, 3, "Wood"));
            toolSlot.add(new WateringCan("Metal wateringcan", "CAN water your plants", 2, 4, "Metal"));
            toolSlot.add(new Hoe("Metal Hoe", "Hoe description", 2, 5, "Metal"));
            toolSlot.add(new Axe("Metal Axe", "Axe description", 2, 6, "Metal"));
            toolSlot.add(new WateringCan("Iron wateringcan", "CAN water your plants", 3, 7, "Iron"));
            toolSlot.add(new Hoe("Iron Hoe", "Hoe description", 3, 8, "Iron"));
            toolSlot.add(new Axe("Iron Axe", "Axe description", 3, 9, "Iron"));
// prima, alleen nog sprites dus aanpassen
        }
    }

    public void selectSlot(int index) {
        for (int i = 0; i < slots.size(); i++) {
            RectangleEntity slot = slots.get(i);
            if (i == index) {
                selectedSlot = i;
                slot.setFill(Color.ROSYBROWN);
            } else {
                slot.setFill(Color.BEIGE);
            }
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
                System.out.println("Slot " + (i + 1) + " selected.");

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

    public void emptyHotbar() {
        for (int i = 0; i < numberOfSlots; i++) {

            toolSlot.set(i, null); // Set each slot to null
            slots.get(i).setFill(Color.BEIGE); // Reset the color of the slot
        }
    }

    public static int getSelectedSlot() {
        return selectedSlot;
    }
}
