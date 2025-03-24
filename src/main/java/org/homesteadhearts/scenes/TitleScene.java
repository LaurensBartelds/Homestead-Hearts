package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import org.homesteadhearts.HomesteadHearts;
import org.homesteadhearts.entities.buttons.menu.StartButton;


public class TitleScene extends StaticScene {

    private final HomesteadHearts homestead;

    public TitleScene(HomesteadHearts homesteadHearts) {
        this.homestead = homesteadHearts;
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
        addEntity(new StartButton(new Coordinate2D(getWidth() / 2 - 75, getHeight() / 2 + 100), homestead));
    }
}