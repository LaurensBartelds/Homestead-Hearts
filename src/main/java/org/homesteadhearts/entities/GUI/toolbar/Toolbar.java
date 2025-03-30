package org.homesteadhearts.entities.GUI.toolbar;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Toolbar extends Pane {
    private int selectedSlot = 0;
    private final int hotbarX;
    private final int hotbarY;

    public Toolbar(int hotbarX, int hotbarY) {
        this.hotbarX = hotbarX;
        this.hotbarY = hotbarY;
        setPrefSize(500, 60);
        drawHotBar();
        setOnMouseClicked(event -> checkHotBarSelected((int) event.getX(), (int) event.getY()));
    }

    private void checkHotBarSelected(int mouseX, int mouseY) {
        for (int i = 0; i < 10; i++) {
            int slotX = hotbarX + (i * 50);
            if (mouseX >= slotX && mouseX <= slotX + 50 && mouseY >= hotbarY && mouseY <= hotbarY + 50) {
                selectedSlot = i;
                drawHotBar();
                break;
            }
        }
    }

    private void drawHotBar() {
        getChildren().clear();
        int hotbarX = 0;
        int hotbarY = 0;

        Rectangle background = new Rectangle(hotbarX - 3, hotbarY - 3, 10 * 50 + 10, 60);
        background.setFill(Color.YELLOW);
        getChildren().add(background);

        for (int i = 0; i < 10; i++) {
            int slotX = hotbarX + (i * 50);
            Rectangle slot = new Rectangle(slotX, hotbarY, 50, 50);
            slot.setFill(Color.TRANSPARENT);
            slot.setStroke(Color.BLACK);
            getChildren().add(slot);
            if (i == selectedSlot) {
                slot.setStroke(Color.RED);
            }
        }
    }
}