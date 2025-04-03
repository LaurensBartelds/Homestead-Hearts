package org.homesteadhearts.entities.crops.types;

import com.github.hanyaeger.api.Coordinate2D;
import org.homesteadhearts.entities.crops.Crops;

public class Corn extends Crops {
    private static final int STARTING_SPRITE_INDEX = 24;
    private static final int MAX_GROWTH_STAGE = 4;

    public Corn(Coordinate2D location) {
        super(location);
    }

    @Override
    protected int getStartingSpriteIndex() {
        return STARTING_SPRITE_INDEX;
    }

    @Override
    protected int getMaxGrowthStage() {
        return MAX_GROWTH_STAGE;
    }

    @Override
    public String getCropName() {
        return "Corn";
    }
}
