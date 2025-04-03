package org.homesteadhearts.entities.gui.coins;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Coins extends TextEntity {
    private static int money = 0;
    private static Coins instance;

    public Coins(Coordinate2D initialLocation, String coinsText, int initialMoney) {
        super(initialLocation, coinsText + initialMoney);
        money = initialMoney;
        instance = this;

        setFill(Color.LIGHTGOLDENRODYELLOW);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
    }

    public void updateMoneyDisplay() {
        setText("Coins: " + money);
    }

    public static int getMoney() {
        return money;
    }

    public static void setMoney(int amount) {
        money = amount;
        if (instance != null) {
            instance.updateMoneyDisplay();
        }
    }

    public static void addMoney(int amount) {
        setMoney(getMoney() + amount);
    }
}