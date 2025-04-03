package org.homesteadhearts.entities.animals.chicken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.homesteadhearts.entities.animals.Animal;
import org.homesteadhearts.entities.animals.bunny.BunnySprite;

import java.util.Random;

public class Chicken extends Animal implements SceneBorderTouchingWatcher {

    private ChickenSprite chickenSprite;

    public Chicken(Coordinate2D initialLocation, int direction) {
        super(initialLocation);
        setMotion(8, direction);
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
            case LEFT -> {
                setAnchorLocationX(getSceneWidth() - getWidth());
                setAnchorLocationY(new Random().nextDouble() * (getSceneHeight() - getHeight())); // Random y-coordinate
            }

            case RIGHT -> {
                setAnchorLocationX(0);
                setAnchorLocationY(new Random().nextDouble() * (getSceneHeight() - getHeight())); // Random y-coordinate
            }

            case TOP ->                 setAnchorLocationY(getSceneHeight() - getHeight()); // Reappear at the bottom

            case BOTTOM ->  setAnchorLocationY(0);
        }
    }
}
