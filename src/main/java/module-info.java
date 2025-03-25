module Homestead.Hearts {
    requires hanyaeger;
    requires javafx.controls;

    exports org.homesteadhearts.maps.tiles to hanyaeger;

    exports org.homesteadhearts;
    exports org.homesteadhearts.scenes;
    exports org.homesteadhearts.entities.buttons.menu;

    opens sprites.animals;
    opens sprites.tiles;
}