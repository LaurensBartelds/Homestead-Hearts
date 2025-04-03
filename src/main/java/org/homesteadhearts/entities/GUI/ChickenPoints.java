package org.homesteadhearts.entities.GUI;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class ChickenPoints extends TextEntity {
    int chickenPoints;

    public ChickenPoints(Coordinate2D initialLocation, String chickenText, int chickenPoints) {
        super(initialLocation, chickenText);
        this.chickenPoints = chickenPoints;
        setChickenPoints(chickenPoints);
        setFill(Color.LIGHTGOLDENRODYELLOW);
        setFont(Font.font("Roboto", FontWeight.BOLD, 20));
    }

        public void setChickenPoints(int points) {
            setText("Chicken Points: " + points);
        }

        public void addChickenPoints() {
            chickenPoints++;
            setChickenPoints(chickenPoints);
        }

        public int getChickenPoints() {
            return chickenPoints;
        }

    }

