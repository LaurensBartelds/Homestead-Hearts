module Homestead.Hearts {
        requires hanyaeger;
        requires org.checkerframework.checker.qual;
    requires java.desktop;

    exports org.homesteadhearts;
        exports org.homesteadhearts.scenes;
        exports org.homesteadhearts.entities.buttons.menu;
        exports org.homesteadhearts.maps;

        opens sprites.animals;
        opens sprites.tiles;
        opens sprites.farming;
        opens sprites.avatar;
        opens sprites.tiles.individual_tiles;

    exports org.homesteadhearts.maps.tiles;
}