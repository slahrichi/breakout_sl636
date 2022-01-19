package breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Brick {

  public static final int myInf = 100000;
  public static int width = Main.SIZE / AllBricks.columns;
  public static int height = 25;
  public Rectangle brick_rect;
  public int strength;
  public Color color;
  public boolean hasPowerUp;

//  public void decay(Brick brick, int strength) {
//    this.strength = strength;
//    if (brick.isHit()) {
//      brick.strength--;
//    }
//  }

  public Brick(int strength, int xPos, int yPos, Color color, boolean hasPowerUp) {
    this.strength = strength;
    if (strength == 8) {
      strength = myInf;
    }
    if (strength != 0) {
      brick_rect = new Rectangle(xPos, yPos, width, height);
      color = pickColor(strength);
      brick_rect.setStroke(Color.BLACK);
      brick_rect.setFill(color);
    }
  }

  public static Color pickColor(int strength) {
    Color color = Color.WHITE;
    switch (strength) {
      case 1:
        color = Color.NAVAJOWHITE;
        break;
      case 2:
        color = Color.YELLOW;
        break;
      case 3:
        color = Color.DARKORANGE;
        break;
      case 4:
        color = Color.RED;
        break;
      case myInf:
        color = Color.BLACK;
        break;
    }
    return color;
  }
}

