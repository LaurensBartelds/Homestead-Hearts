package org.homesteadhearts.entities.tools;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Tool extends DynamicCompositeEntity {
    protected String name;
    protected String description;
    protected int level;
    protected int inSlot;

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

    public String getDescription() {
        return this.description;
    }

public void useTool(){


}
}
