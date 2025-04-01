package org.homesteadhearts.entities.tools.hoe;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import org.homesteadhearts.entities.tools.Tool;
import org.homesteadhearts.maps.TopLayerMap;


public class Hoe extends Tool {


    public Hoe(String name, String description, int level, int inSlot, String material) {
        super(name, description, level, inSlot, material);

    }

    @Override
    public void setupEntities() {
        HoeSprite hoeSprite = new HoeSprite(new Coordinate2D(0, 0), level);
        addEntity(hoeSprite);
    }

    @Override
    public void useTool() {

        // wat ik wil: if(toolSlot.get(selectedSlot) instanceof Hoe) { doe iets}
//        toolSlot.get(selectedSlot).useTool();
        changeLand();

    }

    public void changeLand(){
        System.out.println("Change Land");

    }

}
