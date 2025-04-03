
package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;

import org.homesteadhearts.entities.people.player.Player;

import java.util.Random;

public class Bunny extends DynamicCompositeEntity implements SceneBorderCrossingWatcher, Collider, TimerContainer {
private Player player;
    public Bunny(Coordinate2D location, Player player) {
        super(location);
        if (player != null) {
            this.player = player;
        } else {
            System.out.println("Error: Player instance is null! Bunny cannot follow.");
        }

        setMotion(2, 0);
    }

    private BunnySprite bunnySprite;

    @Override
    protected void setupEntities() {
        bunnySprite = new BunnySprite(new Coordinate2D(30, 0));
        addEntity(bunnySprite);

        BunnyHitbox bunnyHitbox = new BunnyHitbox(new Coordinate2D(30, 0));
        addEntity(bunnyHitbox);
    }

//    @Override
//    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
//        if (pressedKeys.contains(KeyCode.LEFT)) {
//            setMotion(5, 270d);
//            bunnySprite.setAuto(3, 100);
//        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
//            setMotion(5, 90d);
//            bunnySprite.setAuto(2, 100);
//        } else if (pressedKeys.contains(KeyCode.UP)) {
//            setMotion(5, 180d);
//            bunnySprite.setAuto(1, 100);
//        } else if (pressedKeys.contains(KeyCode.DOWN)) {
//            setMotion(5, 0d);
//            bunnySprite.setAuto(0, 100);
//        } else if (pressedKeys.isEmpty()) {
//            setMotion(0, 0);
//            bunnySprite.setAuto(4, 500);
//        }
//
//    }

    @Override
    public void setupTimers() {
        addTimer(new BunnyTimer(this));
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder border) {
        changeDirection();
    }

    public void changeDirection() {
        changeDirection(180D);
        bunnySprite.setAutoCycleRow((bunnySprite.getAutoCycleRow() + 1) % 2);
        if(bunnySprite.getDirection()== 270d){ bunnySprite.setAuto(3, 100);}
        else if(bunnySprite.getDirection()== 90d){ bunnySprite.setAuto(2, 100);}
        else if(bunnySprite.getDirection()== 180d){ bunnySprite.setAuto(1, 100);}
        else if(bunnySprite.getDirection()== 0d){ bunnySprite.setAuto(4, 500);}

    }

    public void followPlayer(){
        setDirection(angleTo(player));

        if(getDirection() > 0 && getDirection() < 180){
            bunnySprite.setAutoCycleRow(1);
        } else {
            bunnySprite.setAutoCycleRow(0);
        }
    }

    private static class BunnyTimer extends Timer {
        private final Bunny bunny;

        protected BunnyTimer(Bunny bunny) {
            super(new Random().nextInt(500) + 200);
            this.bunny = bunny;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            if (new Random().nextInt(6) < 1) {
                bunny.followPlayer();
            }
        }
    }
}
