package org.homesteadhearts.entities.tools.fertilizer;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class Fertilizer extends Tool {

    public Fertilizer(String name, String description, int level, int inSlot, String material) {
        super(name, description, level, inSlot, material);
    }

    @Override
    public void setupEntities() {
        FertilizerSprite fertilizerSprite = new FertilizerSprite(new Coordinate2D(0, 0), level);
        addEntity(fertilizerSprite);
    }
}
