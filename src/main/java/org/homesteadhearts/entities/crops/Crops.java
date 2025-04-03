package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.entities.crops.hitbox.PlantHitbox;
import org.homesteadhearts.entities.crops.sprites.PlantSprite;

public abstract class Crops extends DynamicCompositeEntity implements MouseButtonPressedListener {
    protected boolean isWatered = false;
    protected int growthStage = 0;
    protected DynamicSpriteEntity cropSprite;

    public Crops(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        cropSprite = createSprite();
        addEntity(cropSprite);
        PlantHitbox hitbox = new PlantHitbox(new Coordinate2D(-37.5, -37.5));
        addEntity(hitbox);
    }

    protected PlantSprite createSprite() {
        return new PlantSprite(new Coordinate2D(-37.5, -37.5), getCurrentSpriteIndex());
    }

    protected int getCurrentSpriteIndex() {
            return getStartingSpriteIndex() + growthStage; // Plant stages
    }

    protected abstract int getStartingSpriteIndex();
    protected abstract int getMaxGrowthStage();
    protected abstract String getCropName();

    public void water() {
        if (isWatered) {
            System.out.println(getCropName() + " already watered");
        } else {
            isWatered = true;
            System.out.println("Watered the " + getCropName());
        }
    }

    public void grow() {
        if (isWatered && growthStage <= getMaxGrowthStage()) {
            growthStage++;
            updateSpriteFrame();
            System.out.println(getCropName() + " has grown to stage " + growthStage);
        } else if (growthStage >= getMaxGrowthStage()) {
            System.out.println(getCropName() + " is fully grown and ready to harvest");
        } else {
            System.out.println(getCropName() + " is not watered yet");
        }
    }

    protected void updateSpriteFrame() {
        if (cropSprite != null) {
            cropSprite.setCurrentFrameIndex(getCurrentSpriteIndex());
        }
    }

    public void harvest() {
        if (growthStage >= getMaxGrowthStage()) {
            System.out.println("Harvested " + getCropName());
            // Implement harvesting logic here - could generate items, etc.
            remove();
        } else {
            System.out.println(getCropName() + " is not ready to harvest yet");
        }
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        if (button == MouseButton.PRIMARY) {
            water();
        } else if (button == MouseButton.SECONDARY) {
            grow();
        }
    }
}
