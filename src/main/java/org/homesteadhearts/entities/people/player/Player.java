package org.homesteadhearts.entities.people.player;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.homesteadhearts.entities.crops.carrot.CarrotHitbox;

import java.util.List;

public class Player extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collided {

    private boolean canMove = true;

    public Player(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        PlayerSprite playerSprite = new PlayerSprite(new Coordinate2D(10, 3), this);
        addEntity(playerSprite);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        // Handle boundary crossing
    }

    @Override
    public void onCollision(List<Collider> collidingObject) {
        for (Collider collider : collidingObject) {
            if (collider instanceof CarrotHitbox) {

                canMove = false;
                System.out.println("Player collided with carrot");
            }
        }
    }

    public boolean canMove() {
        return canMove;
    }

}