package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.animals.bunny.Bunny;

public class GameLevel extends DynamicScene {

    private final HomesteadHearts homestead;

    public GameLevel(HomesteadHearts homestead) {
        this.homestead = homestead;
    }

    @Override
    public void setupScene() {
        // Configure your scene here (background, etc.)
    }

    @Override
    public void setupEntities() {
        Bunny bunny = new Bunny(new Coordinate2D(300, 300));
        addEntity(bunny);
    }
}
