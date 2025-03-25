package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Carrot extends DynamicCompositeEntity {
    private CarrotSprite carrotSprite;

    public Carrot(Coordinate2D location) {
        super(location);

    }

    @Override
    protected void setupEntities() {
        carrotSprite = new CarrotSprite(new Coordinate2D(200,100));
        addEntity(carrotSprite);
    }

    public void placeCarrot(Coordinate2D location) {
        carrotSprite = new CarrotSprite(location);

    }


    public CarrotSprite getCarrotSprite() {
        return carrotSprite;
    }
}
