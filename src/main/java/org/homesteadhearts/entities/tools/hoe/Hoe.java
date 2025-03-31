package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.animals.bunny.BunnySprite;
import org.homesteadhearts.entities.tools.Tool;

public class Hoe extends Tool {
    private HoeSprite hoeSprite;


    public Hoe(String name, String description, int level, int inSlot) {
        super(name, description, level, inSlot);

    }

    @Override
    public void setupEntities () {
        hoeSprite = new HoeSprite(new Coordinate2D(1000,1000));
        addEntity(hoeSprite);
    }



}
