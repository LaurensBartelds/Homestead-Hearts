package org.homesteadhearts.entities.crops.wheat;

import com.github.hanyaeger.api.Coordinate2D;

public class Wheat {
    private WheatSprite wheatSprite;

    public Wheat (Coordinate2D location) {
//      super(location);
        super();
    }

    public void placeWheat(Coordinate2D location){
        wheatSprite = new WheatSprite(location);

    }

    public WheatSprite getWheatSprite(){
        return wheatSprite;
    }
}
