package org.homesteadhearts.entities.tools.plow;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;

public class Plow extends Tool {

    public Plow(String name, String description, int level, int inSlot) {
        super(name, description, level, inSlot);

    }

    @Override
    public void setupEntities () {
        PlowSprite plowSprite = new PlowSprite(new Coordinate2D(0, 0));
        addEntity(plowSprite);
    }



}
