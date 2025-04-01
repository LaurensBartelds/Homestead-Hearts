package org.homesteadhearts.entities.tools.wateringCan;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class WateringCan extends Tool {


    public WateringCan(String name, String description, int level, int inSlot, String material) {
        super(name, description, level, inSlot, material);

    }

    @Override
    public void setupEntities () {
        WateringCanSprite wateringCanSprite = new WateringCanSprite(new Coordinate2D(15, 0), level);
        addEntity(wateringCanSprite);
    }

    @Override
    public void useTool () {
        waterPlants();
    }
    public void waterPlants () {
        System.out.println("Water Plants");
    }

}
