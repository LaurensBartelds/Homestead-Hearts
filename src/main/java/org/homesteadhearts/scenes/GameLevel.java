package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.UpdateExposer;
import com.github.hanyaeger.api.scenes.ScrollableDynamicScene;
import javafx.scene.paint.Color;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.animals.bunny.Bunny;
import org.homesteadhearts.entities.crops.carrot.Carrot;

public class GameLevel extends ScrollableDynamicScene implements UpdateExposer {

    private Bunny bunny;
    private Carrot carrot;

    public GameLevel(HomesteadHearts homestead) {
    }

    @Override
    public void setupScene() {
        setBackgroundColor(Color.WHITE);
        setSize(new Size(2000, 2000));
        setRelativeScrollPosition(0.5, 0.5);
    }

    @Override
    public void setupEntities() {
        bunny = new Bunny(new Coordinate2D(1000, 1000));
        addEntity(bunny);

        carrot = new Carrot(new Coordinate2D(1000, 1000));
        addEntity(carrot);
    }

    @Override
    public void explicitUpdate(final long timestamp) {
        var bunnyLocation = bunny.getAnchorLocation();
        setScrollPosition(bunnyLocation);
    }
}