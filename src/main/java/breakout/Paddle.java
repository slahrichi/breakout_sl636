package breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Paddle {

  public static Rectangle paddle_rect;
  public static int width = 200;
  public static int height = 10;
  private static final int SPEED = 20;
  private static final int xPos = Main.SIZE / 2 - width / 2;
  private static final int yPos = Main.SIZE - 50;

  public Paddle() {
    paddle_rect = new Rectangle(xPos, yPos, width, height);
    paddle_rect.setFill(Color.LIME);

  }

  public static void resetPaddle() {
    paddle_rect.setX(xPos);
    paddle_rect.setY(yPos);
  }

  public static void move(char dir) {
    switch (dir) {
      case 'R':
        if (paddle_rect.getX() + width < Main.SIZE) {
          paddle_rect.setX(paddle_rect.getX() + SPEED);
        }
        break;
      case 'L':
        if (paddle_rect.getX() > 0) {
          paddle_rect.setX(paddle_rect.getX() - SPEED);
        }
        break;
    }
  }
}


