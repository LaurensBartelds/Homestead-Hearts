package org.homesteadhearts.entities.animals;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Animal extends DynamicCompositeEntity {


    protected Animal(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {

    }
}
