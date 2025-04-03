package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.crops.sprites.SeedBagSprite;
import org.homesteadhearts.entities.tools.Tool;

public class Seed extends Tool {

    private final Class<? extends Crops> cropType;
    private final int SPRITE_INDEX;

    public Seed(String cropName, Class<? extends Crops> cropType, int SPRITE_INDEX, int slotNumber) {
        super(cropName + " Seeds", "Plant " + cropName + " crops", 1, slotNumber, "Seeds");
        this.cropType = cropType;
        this.SPRITE_INDEX = SPRITE_INDEX;
    }

    @Override
    protected void setupEntities() {
        SeedBagSprite seedBagSprite = new SeedBagSprite(new Coordinate2D(0, 0), SPRITE_INDEX);
        addEntity(seedBagSprite);
    }

    public Class<? extends Crops> getCropType() {
        return cropType;
    }

}
