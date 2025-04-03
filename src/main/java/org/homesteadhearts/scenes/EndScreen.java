package org.homesteadhearts.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.FontWeight;
import org.homesteadhearts.HomesteadHearts;


public class EndScreen extends StaticScene {

    public void setupScene() {
        setBackgroundImage("Sprites/background/backgroundEndScreen.png");
    }

    public EndScreen(HomesteadHearts homesteadHearts) {
    }

    @Override
    public void setupEntities() {
        var EndText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2 - 5),
                "Homestead Hearts"
        );

        EndText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        EndText.setFill(Color.LIGHTPINK);
        EndText.setFont(javafx.scene.text.Font.font("Roboto", FontWeight.EXTRA_BOLD, 80));
        EndText.setStrokeWidth(2);
        EndText.setStrokeColor(Color.BLACK);

        addEntity(EndText);


    }
    }

