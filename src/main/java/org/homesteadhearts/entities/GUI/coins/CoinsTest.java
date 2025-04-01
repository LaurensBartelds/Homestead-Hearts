package org.homesteadhearts.entities.GUI.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CoinsTest extends TextEntity {
    public CoinsTest(Coordinate2D initialLocation) {
        super(initialLocation, "Coins: 0");
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }
}
