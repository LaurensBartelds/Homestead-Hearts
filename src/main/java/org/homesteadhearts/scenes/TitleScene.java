package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import org.homesteadhearts.HomesteadHearts;


public class TitleScene extends StaticScene {

    public TitleScene(HomesteadHearts homesteadHearts) {
    }

    public void setupScene() {
        setBackgroundColor(Color.BLACK);
    }

    public void setupEntities() {
        var homesteadText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2),
                "Homestead Hearts"
        );
        homesteadText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        homesteadText.setFill(Color.DARKBLUE);
        homesteadText.setFont(javafx.scene.text.Font.font("Roboto", javafx.scene.text.FontWeight.SEMI_BOLD, 50));
        addEntity(homesteadText);
    }
}
