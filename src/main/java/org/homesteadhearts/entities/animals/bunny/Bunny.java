package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Bunny extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    public Bunny(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        BunnySprite bunnySprite = new BunnySprite(new Coordinate2D(0, 0));
        addEntity(bunnySprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        setAnchorLocationX(0);
    }
}