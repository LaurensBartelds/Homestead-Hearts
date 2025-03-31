package org.homesteadhearts.entities.tools;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Tool extends DynamicCompositeEntity {
    String name;
    String description;
    int level;
    int inSlot;

    public Tool(String name, String description, int level, int inSlot) {
        super(new Coordinate2D(0,0));
        this.name = name;
        this.description = description;
        this.level = level;
        this.inSlot = inSlot;
    }

    @Override
    protected void setupEntities() {

    }

    public String getName() {
        return this.name;
    }
}
