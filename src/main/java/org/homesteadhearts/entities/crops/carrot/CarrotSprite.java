package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.Coordinate2D;

public class CarrotSprite extends DynamicSpriteEntity {
    int carrotGrowthStage;
    public CarrotSprite(Coordinate2D location, int carrotGrowthStage) {
        super("sprites/farming/crops_all.png", location, new Size(100, 100), 37, 25);
       this.carrotGrowthStage = carrotGrowthStage;

       setCurrentFrameIndex(carrotGrowthStage);
        }

        // 0 = seedpack, 1= seeds, 2 = carrot ontkiem, 3 = carrot kiem, 4 = carrot growing, 5 = carrot full, 6 = full grown carrot

}