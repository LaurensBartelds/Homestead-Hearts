package org.homesteadhearts.entities.crops.wheat;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Wheat extends DynamicCompositeEntity {
    private WheatSprite wheatSprite;

    public Wheat (Coordinate2D location) {
//      super(location);
        super();
    }

    @Override
    protected void setupEntities() {

    }

    public void placeWheat(Coordinate2D location){
        wheatSprite = new WheatSprite(location);

    }


    public WheatSprite getWheatSprite(){
        return wheatSprite;
    }
}
