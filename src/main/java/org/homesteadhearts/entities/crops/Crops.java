package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.entities.crops.sprites.PlantSprite;
import org.homesteadhearts.entities.crops.sprites.SeedBagSprite;

public abstract class Crops extends DynamicCompositeEntity implements MouseButtonPressedListener {
    protected boolean isWatered = false;
    protected int growthStage = 0;
    protected int maxGrowthStage;
    protected DynamicSpriteEntity cropSprite;
    protected int startingSpriteIndex;

    public Crops(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
        cropSprite = createSprite();
        addEntity(cropSprite);
    }

    protected PlantSprite createSprite() {
        PlantSprite sprite = new PlantSprite(new Coordinate2D(-50, -50), getCurrentSpriteIndex());
        return sprite;
    }

    protected SeedBagSprite createSeedBagSprite() {
        SeedBagSprite sprite = new SeedBagSprite(new Coordinate2D(-37.5, -37.5), getCurrentSpriteIndex());
        return sprite;
    }

    protected int getCurrentSpriteIndex() {
            return getStartingSpriteIndex() + growthStage; // Plant stages
    }

    protected abstract int getStartingSpriteIndex();
    protected abstract int getMaxGrowthStage();
    protected abstract String getCropName();
    protected abstract int getSeedSpriteIndex();

    public void water() {
        if (isWatered) {
            System.out.println(getCropName() + " already watered");
        } else {
            isWatered = true;
            System.out.println("Watered the " + getCropName());
        }
    }

    public void grow() {
        if (isWatered && growthStage <= maxGrowthStage) {
            growthStage++;
            updateSpriteFrame();
            System.out.println(getCropName() + " has grown to stage " + growthStage);
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
