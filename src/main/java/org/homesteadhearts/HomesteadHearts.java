package org.homesteadhearts;

import com.github.hanyaeger.api.YaegerGame;
import org.homesteadhearts.scenes.GameLevel;
import org.homesteadhearts.scenes.TitleScene;

public class HomesteadHearts extends YaegerGame {

    public static void main( String[] args ) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Homestead Hearts");
    } // Set the title of the game

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this)); // Add the TitleScene to the game
        addScene(1, new GameLevel()); // Add the GameLevel to the game
    }
}
