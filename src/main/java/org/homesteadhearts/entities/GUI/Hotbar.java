package org.homesteadhearts.entities.GUI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.CompositeEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import org.homesteadhearts.entities.crops.Seed;
import org.homesteadhearts.entities.crops.types.Carrot;
import org.homesteadhearts.entities.crops.types.Corn;
import org.homesteadhearts.entities.crops.types.Pumpkin;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.entities.tools.wateringCan.WateringCan;
import org.homesteadhearts.scenes.GameLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Hotbar extends CompositeEntity implements KeyListener, MouseButtonPressedListener {
    private final List<RectangleEntity> hotbarSlots;
    private final int numberOfSlots;
    private final List<Tool> itemsList = new ArrayList<>();
    static int selectedSlot = 0;

    public Hotbar(Coordinate2D initialLocation, int numberOfSlots) {
        super(initialLocation);
        this.numberOfSlots = numberOfSlots;
        hotbarSlots = new ArrayList<>();
    }

    @Override
    public void setupEntities() {
        double slotWidth = 75;
        double slotHeight = 75;
        double spacing = 5;

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
            hotbarSlots.add(slot);
            addEntity(slot);
        }
        addItemsToHotbar();

        IntStream.range(0, Math.min(hotbarSlots.size(), itemsList.size()))
                .forEach(i -> {
                    Tool item = itemsList.get(i);
                    if (item != null) {
                        RectangleEntity slot = hotbarSlots.get(i);
                        Coordinate2D slotLocation = slot.getAnchorLocation();

                        double offsetX = (slot.getWidth() - 75) / 2.0;
                        double offsetY = (slot.getHeight() - 75) / 2.0;

                        item.setAnchorLocation(new Coordinate2D(slotLocation.getX() + offsetX, slotLocation.getY() + offsetY));
                        addEntity(item);

                        // If it's a seed, set the game level reference
                    }
                });

        // Select the first slot by default
        selectSlot(0);
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

    public void useSelectedItem() {
        if (selectedSlot < itemsList.size() && itemsList.get(selectedSlot) != null) {
            itemsList.get(selectedSlot).useTool();
        }
    }

    public void addItemsToHotbar() {
        // Add watering can
        itemsList.add(new WateringCan("Wooden wateringcan", "CAN water your plants", 1, 1, "Wood"));

        // Add seeds for different crop types
    }

    public void selectSlot(int index) {
        for (int i = 0; i < hotbarSlots.size(); i++) {
            RectangleEntity slot = hotbarSlots.get(i);
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
        for (int i = 0; i < hotbarSlots.size(); i++) {
            RectangleEntity slot = hotbarSlots.get(i);
            // Check if the mouse click is within the bounds of the slot.
            if (slot.getAnchorLocation().getX() <= coordinate2D.getX() &&
                    coordinate2D.getX() <= slot.getAnchorLocation().getX() + slot.getWidth() &&
                    slot.getAnchorLocation().getY() <= coordinate2D.getY() &&
                    coordinate2D.getY() <= slot.getAnchorLocation().getY() + slot.getHeight()) {
                selectSlot(i); // Select the clicked slot
                break;
            }
        }
    }

    public void emptyHotbar() {
        for (int i = 0; i < numberOfSlots; i++) {
            if (i < itemsList.size()) {
                itemsList.set(i, null); // Set each slot to null
            }
            hotbarSlots.get(i).setFill(Color.BEIGE); // Reset the color of the slot
        }
    }

    public static int getSelectedSlot() {
        return selectedSlot;
    }

    public List<Tool> getItemsInHotbar() {
        return itemsList;
    }

    public Tool getSelectedItem() {
        if (selectedSlot < itemsList.size()) {
            return itemsList.get(selectedSlot);
        }
        return null;
    }
}
