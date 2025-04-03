package org.homesteadhearts;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import org.homesteadhearts.scenes.EndScreen;
import org.homesteadhearts.scenes.GameLevel;
import org.homesteadhearts.scenes.TitleScene;


public class HomesteadHearts extends YaegerGame {

    public static final Size GAME_SIZE = new Size(1024, 698);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Homestead Hearts");
        setSize(GAME_SIZE);
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this)); // Add the TitleScene to the game
        addScene(1, new GameLevel(this)); // Add the GameLevel to the game
        addScene(2, new EndScreen(this));
    }
}