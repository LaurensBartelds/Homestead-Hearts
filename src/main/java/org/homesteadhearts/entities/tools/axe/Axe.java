package org.homesteadhearts.entities.tools.axe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class Axe extends Tool {

    public Axe(String name, String description, int level, int inSlot) {
        super(name, description, level, inSlot);
    }

    @Override
    public void setupEntities() {
        AxeSprite axeSprite = new AxeSprite(new Coordinate2D(0, 0), level);
        addEntity(axeSprite);
    }

    @Override
    public void useTool() {
        chopWood();
    }

    public void chopWood() {
        // Logic to chop wood
    }


}
