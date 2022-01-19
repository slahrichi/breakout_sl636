module breakout_game {
    // list all imported class packages since they are dependencies
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;
  requires java.desktop;

  // allow other classes to access listed packages in your project
    exports breakout;
}
