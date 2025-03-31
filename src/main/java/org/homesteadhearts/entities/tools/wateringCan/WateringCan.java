package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.entities.tools.wateringCan.WateringCanSprite;

public class WateringCan extends Tool {
    private WateringCanSprite wateringCanSprite;


    public WateringCan(String name, String description, int level, int inSlot) {
        super(name, description, level, inSlot);

    }

    @Override
    public void setupEntities () {
        wateringCanSprite = new WateringCanSprite(new Coordinate2D(1000,1000));
        addEntity(wateringCanSprite);
    }



}
