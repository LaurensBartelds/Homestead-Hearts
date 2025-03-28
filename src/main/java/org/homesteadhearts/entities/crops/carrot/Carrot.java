package org.homesteadhearts.entities.crops.carrot;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Carrot extends DynamicCompositeEntity {


    public Carrot(Coordinate2D location) {
        super(location);

    }

    @Override
    protected void setupEntities() {
        CarrotSprite carrotSprite = new CarrotSprite(new Coordinate2D(200, 100));
        addEntity(carrotSprite);

        CarrotHitbox carrotHitbox = new CarrotHitbox(new Coordinate2D(222, 105));
        addEntity(carrotHitbox);
    }





}
