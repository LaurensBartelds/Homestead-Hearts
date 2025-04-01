package org.homesteadhearts.entities.GUI.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CoinsTest extends TextEntity {
    public CoinsTest(Coordinate2D initialLocation, String text, int money) {
        super(initialLocation, text + money);
        setFill(Color.LIGHTGOLDENRODYELLOW);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    public void setCoinAmount(int coinAmount) {

        setText("Coins" + coinAmount);
    }

}
