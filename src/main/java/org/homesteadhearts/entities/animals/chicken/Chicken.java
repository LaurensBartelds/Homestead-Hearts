package org.homesteadhearts.entities.animals.chicken;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.entities.gui.component.ChickenPoints;
import org.homesteadhearts.entities.animals.Animal;

import java.util.Random;

public class Chicken extends Animal implements SceneBorderTouchingWatcher, MouseButtonPressedListener {
    private final ChickenPoints CHICKEN_POINTS;
    public Coordinate2D location;

    public Chicken(Coordinate2D location, int direction, ChickenPoints chickenPoints) {
        super(location);
        this.location = location;
        this.CHICKEN_POINTS = chickenPoints;
        setMotion(8, direction);
    }

    @Override
    protected void setupEntities() {
        ChickenSprite chickenSprite = new ChickenSprite(new Coordinate2D(30, 0));
        addEntity(chickenSprite);

        ChickenHitbox chickenHitbox = new ChickenHitbox(new Coordinate2D(43, 25));
        addEntity(chickenHitbox);
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

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        if(mouseButton == MouseButton.PRIMARY) {
            CHICKEN_POINTS.addChickenPoints();
            System.out.println("punt erbij, kippie");
        }
    }
}
