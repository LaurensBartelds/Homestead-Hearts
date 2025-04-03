package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.crops.sprites.SeedBagSprite;
import org.homesteadhearts.entities.tools.Tool;

public class Seed extends Tool {
    private final Class<? extends Crops> cropType;
    private final int spriteIndex;

    public Seed(String cropName, Class<? extends Crops> cropType, int spriteIndex, int slotNumber) {
        super(cropName + " Seeds", "Plant " + cropName + " crops", 1, slotNumber, "Seeds");
        this.cropType = cropType;
        this.spriteIndex = spriteIndex;
    }

    @Override
    protected void setupEntities() {
        SeedBagSprite seedBagSprite = new SeedBagSprite(new Coordinate2D(0, 0), spriteIndex);
        addEntity(seedBagSprite);
    }

    public Class<? extends Crops> getCropType() {
        return cropType;
    }

    @Override
    public void useTool() {
        System.out.println("Ready to plant " + name);
    }
}
