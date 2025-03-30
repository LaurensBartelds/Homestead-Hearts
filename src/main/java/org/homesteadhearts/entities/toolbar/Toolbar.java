
package org.homesteadhearts.entities.toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Toolbar extends JPanel {
    private int selectedSlot = 0;
    private int hotbarX;
    private int hotbarY;

    public Toolbar() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                checkHotBarSelected(e.getX(), e.getY());
            }
        });
    }

    private void checkHotBarSelected(int mouseX, int mouseY) {
        for (int i = 0; i < 10; i++) {
            int slotX = hotbarX + (i * 50);
            if (mouseX >= slotX && mouseX <= slotX + 50 && mouseY >= hotbarY && mouseY <= hotbarY + 50) {
                selectedSlot = i;
                repaint();
                break;
            }
        }
    }

    private void drawHotBar(Graphics2D toolbar2d) {
        int hotbarX = 0;
        int hotbarY = 0;

        toolbar2d.setColor(Color.YELLOW);
        toolbar2d.fillRect(hotbarX - 3, hotbarY - 3, 10 * 50 + 10, 60);

        for (int i = 0; i < 10; i++) {
            int slotX = hotbarX + (i * 50);
            toolbar2d.setColor(Color.BLACK);
            toolbar2d.drawRect(slotX, hotbarY, 50, 50);
            if (i == selectedSlot) {
                toolbar2d.setColor(Color.RED);
                toolbar2d.drawRect(slotX, hotbarY, 50, 50);
            }
        }
    }
}