package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class Hoe extends Tool {

    public Hoe(String name, String description, int level, int inSlot) {
        super(name, description, level, inSlot);

    }

    @Override
    public void setupEntities () {
        HoeSprite hoeSprite = new HoeSprite(new Coordinate2D(0, 0));
        addEntity(hoeSprite);
    }



}
