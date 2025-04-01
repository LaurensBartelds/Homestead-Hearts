package org.homesteadhearts.entities.tools.wateringCan;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class WateringCan extends Tool {

    public WateringCan(String name, String description, int level, int inSlot, String material) {
        super(name, description, level, inSlot, material);
    }

    @Override
    public void setupEntities() {
        // Implementation here
    }

    @Override
    public void useTool(Coordinate2D position) {
        waterPlants();
    }

    @Override
    public void useTool() {
        // Default implementation when no position is provided
        waterPlants();
    }

    public void waterPlants() {
        // Your implementation here
        System.out.println("Watering plants with " + getName());
    }
}