module Homestead.Hearts {
        requires hanyaeger;
        requires org.checkerframework.checker.qual;

        exports org.homesteadhearts;
        exports org.homesteadhearts.scenes;
        exports org.homesteadhearts.entities.buttons.menu;

        opens sprites.animals;
        opens sprites.tiles;
        opens sprites.farming;
        opens sprites.avatar;
        }