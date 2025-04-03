package org.homesteadhearts.entities.animals.chicken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.homesteadhearts.entities.animals.Animal;
import org.homesteadhearts.entities.animals.bunny.BunnySprite;

public class Chicken extends Animal implements SceneBorderTouchingWatcher {

    private ChickenSprite chickenSprite;

    public Chicken(Coordinate2D initialLocation) {
        super(initialLocation);
        setMotion(2, 90d);
    }

//    public int randomDirection() {
//        randomDirection = (int) (Math.random() * 360);
//        return randomDirection;
//    }

    @Override
    protected void setupEntities() {
        chickenSprite = new ChickenSprite(new Coordinate2D(30, 0));
        addEntity(chickenSprite);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder sceneBorder) {
        switch (sceneBorder) {
            case LEFT -> setMotion(2, 0d);
            case RIGHT -> setAnchorLocationX(getSceneWidth() - getWidth()); // Reappear on the right side
            case TOP -> setMotion(2, 270d);
            case BOTTOM -> setMotion(2, 90d);
        }
    }
}
