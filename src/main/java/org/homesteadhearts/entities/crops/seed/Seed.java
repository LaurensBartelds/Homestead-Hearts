package org.homesteadhearts.entities.crops.seed;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;

public class Seed extends DynamicCompositeEntity implements MouseButtonPressedListener {
    private static final int STARTING_FRAME_INDEX = 1;
    private static final int ENDING_FRAME_INDEX = 6;

    private DynamicSpriteEntity seedSprite;
    private int currentFrameIndex = STARTING_FRAME_INDEX;

    public Seed(Coordinate2D location) {
        super(location);
    }

    @Override
    public void setupEntities() {
        seedSprite = new SeedSprite(new Coordinate2D(-50, -50));
        seedSprite.setCurrentFrameIndex(currentFrameIndex);
        addEntity(seedSprite);
    }

    public void grow() {
        if (currentFrameIndex <= ENDING_FRAME_INDEX) {
            currentFrameIndex++;
        }
        seedSprite.setCurrentFrameIndex(currentFrameIndex);
    }


    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        System.out.println("Seed clicked at: " + coordinate2D);
        grow();
    }
}
