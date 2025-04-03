package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import org.homesteadhearts.entities.GUI.Hotbar;

public class Carrot extends DynamicCompositeEntity {

    Hotbar hotbar;
    int carrotGrowthStage;
    public Carrot(Coordinate2D location, Hotbar hotbar) {
        super(location);

        this.hotbar = hotbar;
        this.carrotGrowthStage = carrotGrowthStage;
    }

    @Override
    protected void setupEntities() {
        CarrotSprite carrotSprite = new CarrotSprite(new Coordinate2D(200, 100), carrotGrowthStage);
        addEntity(carrotSprite);


       // CarrotHitbox carrotHitbox = new CarrotHitbox(new Coordinate2D(222, 140),hotbar);
       // addEntity(carrotHitbox);
    }

    public void growCrops(){

    }



}
