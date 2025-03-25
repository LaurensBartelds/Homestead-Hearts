module Homestead.Hearts {
    requires hanyaeger;

    exports org.homesteadhearts;
    exports org.homesteadhearts.scenes;
    exports org.homesteadhearts.entities.buttons.menu;

    opens sprites.animals;
    opens sprites.farming;
    opens sprites.tiles;
}