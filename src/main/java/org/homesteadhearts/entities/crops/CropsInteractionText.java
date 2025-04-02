package org.homesteadhearts.entities.crops;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class CropsInteractionText extends TextEntity {
    public String clickToInteract;


    public CropsInteractionText(Coordinate2D initialLocation, String clickToInteract) {
        super(initialLocation);
        this.clickToInteract = clickToInteract;
        setFill(Color.BROWN);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 15));
    }

    public String getText () {
        return clickToInteract;
    }
}
