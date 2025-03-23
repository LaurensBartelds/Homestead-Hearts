package org.homesteadhearts;

import com.github.hanyaeger.api.YaegerGame;
import org.homesteadhearts.scenes.TitleScene;

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
        addScene(0, new TitleScene(this));
    }
}

//test
