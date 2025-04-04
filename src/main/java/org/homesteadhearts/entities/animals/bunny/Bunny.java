
package org.homesteadhearts.entities.animals.bunny;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Timer;
import com.github.hanyaeger.api.TimerContainer;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import org.homesteadhearts.entities.animals.Animal;
import org.homesteadhearts.entities.people.player.Player;

import java.util.Random;

public class Bunny extends Animal implements SceneBorderCrossingWatcher, Collider, TimerContainer {
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
        if(bunnySprite.angleTo(player)>= 225 && bunnySprite.angleTo(player) < 315d){ bunnySprite.setAuto(3, 100);}
        else if(bunnySprite.angleTo(player)>= 45d && bunnySprite.angleTo(player)< 135d ){ bunnySprite.setAuto(2, 100);}
        else if(bunnySprite.angleTo(player)>= 135d &&bunnySprite.angleTo(player) <225  ){ bunnySprite.setAuto(1, 100);}
        else if(bunnySprite.angleTo(player)>= 315d && bunnySprite.angleTo(player) < 45){ bunnySprite.setAuto(4, 500);
        }
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
        private final Bunny BUNNY;

        protected BunnyTimer(Bunny bunny) {
            super(new Random().nextInt(500) + 200);
            this.BUNNY = bunny;
        }

        @Override
        public void onAnimationUpdate(long timestamp) {
            if (new Random().nextInt(6) < 1) {
                BUNNY.followPlayer();
            }
        }
    }
}
