package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

public class Bunny extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {

    private BunnySprite bunnySprite;

    public Bunny(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        bunnySprite = new BunnySprite(new Coordinate2D(0, 0));
        addEntity(bunnySprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        // This method is called when the bunny crosses a scene border
        // You can customize what happens here
        setAnchorLocationX(0);
    }
}