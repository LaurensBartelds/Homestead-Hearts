package org.homesteadhearts.entities.GUI.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlayerCoinAmountText extends TextEntity {
int coinAmount;
    public PlayerCoinAmountText(Coordinate2D initialLocation, int coinAmount) {
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.WHITE);
    }

    public void setCoinAmount(int coinAmount) {
        setText("money" + coinAmount);
    }
}
