package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public abstract class Crops extends DynamicCompositeEntity {

    boolean isWatered = false;

    public Crops(Coordinate2D location) {
        super(location);
    }

    @Override
    protected void setupEntities() {
    }

    public void water(){
        if(isWatered){
            System.out.println("Already watered");
        } else {
            isWatered = true;
            System.out.println("Watered the crop");
        }
    }

    public void updateGrowthStage() {
        // Implement growth stage update logic here
    }

    public void harvest() {
        // Implement harvesting logic here
    }

    public void plant() {
        // Implement planting logic here
    }

}
