package org.homesteadhearts.entities.tools;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Tool extends DynamicCompositeEntity {
    protected String name;
    protected String description;
    protected int level;
    protected int inSlot;
    protected String material;

    public Tool(String name, String description, int level, int inSlot, String material) {
        super(new Coordinate2D(0,0));
        this.name = name;
        this.description = description;
        this.level = level;
        this.inSlot = inSlot;
        this.material = material;
    }

    @Override
    protected void setupEntities() {
        // Implementation here
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getLevel() {
        return this.level;
    }

    public String getMaterial() {
        return this.material;
    }

    public void useTool(Coordinate2D position) {
        // Default implementation (if any)
    }

    public abstract void useTool();
}