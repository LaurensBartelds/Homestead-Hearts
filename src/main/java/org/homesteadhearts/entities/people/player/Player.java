package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;


public class Player extends DynamicCompositeEntity implements SceneBorderCrossingWatcher {
    private PlayerSprite playerSprite;


    public Player(Coordinate2D initialLocation) {
        super(initialLocation);

    }

    @Override
    protected void setupEntities() {
        playerSprite = new PlayerSprite(new Coordinate2D(0, 0));
        addEntity(playerSprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {

    }

}
