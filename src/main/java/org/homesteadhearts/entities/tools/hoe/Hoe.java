package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.maps.TopLayerMap;


public class Hoe extends Tool {


    public Hoe(String name, String description, int level, int inSlot, String material) {
        super(name, description, level, inSlot, material);

    }

    @Override
    public void setupEntities() {
        HoeSprite hoeSprite = new HoeSprite(new Coordinate2D(0, 0), level);
        addEntity(hoeSprite);
    }

    @Override
    public void useTool() {
        changeLand();

    }

    public void changeLand(){
    }

}
