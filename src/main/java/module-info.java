module Homestead.Hearts {
    requires hanyaeger;

    exports org.homesteadhearts;
    exports org.homesteadhearts.scenes;
    exports org.homesteadhearts.entities.buttons;

    opens sprites.animals;
}