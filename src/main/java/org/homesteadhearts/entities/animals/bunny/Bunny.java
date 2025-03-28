package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Bunny extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider {

    public Bunny(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        BunnySprite bunnySprite = new BunnySprite(new Coordinate2D(30, 0));
        addEntity(bunnySprite);

        BunnyHitbox bunnyHitbox = new BunnyHitbox(new Coordinate2D(30, 0));
        addEntity(bunnyHitbox);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
    }



}