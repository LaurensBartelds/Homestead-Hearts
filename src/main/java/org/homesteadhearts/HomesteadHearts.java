package org.homesteadhearts;

import com.github.hanyaeger.api.YaegerGame;

public class HomesteadHearts extends YaegerGame
{
    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Homestead Hearts");
    }

    @Override
    public void setupScenes() {
        addScene();
    }
}

//test
