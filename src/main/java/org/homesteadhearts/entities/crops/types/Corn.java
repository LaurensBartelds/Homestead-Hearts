package org.homesteadhearts.entities.crops.types;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.homesteadhearts.entities.crops.Crops;

public class Corn extends Crops {
    private static final int STARTING_SPRITE_INDEX = 4;
    private static final int MAX_GROWTH_STAGE = 3;
    private static final int SEED_SPRITE_INDEX = 1;

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

    @Override
    protected int getSeedSpriteIndex() {
        return SEED_SPRITE_INDEX;
    }
}
