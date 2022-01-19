package breakout;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball {

  public static double BOUNCER_x_SPEED = 350;
  public static double BOUNCER_y_SPEED = 350;
  public static double centerX = Main.SIZE * 0.5;
  public static double centerY = Main.SIZE * 0.35;
  public Circle ball_circle;
  private final int radius = 12;


  public Ball(double centerX, double centerY) {
    ball_circle = new Circle(centerX, centerY, radius);
    ball_circle.setFill(Color.ROYALBLUE);

  }


  public void resetBall() {
    ball_circle.setCenterX(centerX);
    ball_circle.setCenterY(centerY);
  }

  public void move(double elapsedTime) {
    ball_circle.setCenterX(ball_circle.getCenterX() + Ball.BOUNCER_x_SPEED * elapsedTime);
    ball_circle.setCenterY(ball_circle.getCenterY() + Ball.BOUNCER_y_SPEED * elapsedTime);
  }

  public Boolean touchesPaddleY() {
    return ball_circle.getCenterY() + ball_circle.getRadius() >= Paddle.paddle_rect.getY();
  }

  public Boolean touchesPaddleX() {
    return ball_circle.getCenterX() - ball_circle.getRadius()
        <= Paddle.paddle_rect.getX() + Paddle.width
        && ball_circle.getCenterX() + ball_circle.getRadius() >= Paddle.paddle_rect.getX();
  }

  public Boolean touchesPaddle() {
    if (touchesPaddleY() && touchesPaddleX()) {
      System.out.println("touches paddle");
      return true;
    }
    return false;
  }

  public Boolean touchesTop() {
    /// touches bottom too, will update later
    if (ball_circle.getCenterY() - ball_circle.getRadius() <= 0) {
      System.out.println("touches top");
      return true;
    }
    return false;
  }


  public Boolean touchesBottom() {
    if (ball_circle.getCenterY() + ball_circle.getRadius() >= Main.SIZE) {
      System.out.println("You Lost a live");
      Main.updateLives(-1);
      Main.updateScore(-3);
      Main.animation.stop();
      return true;
    }
    return false;
  }

  public Boolean touchesLeftPaddle() {
    if (touchesPaddle()) {
      if (ball_circle.getCenterX() <= Paddle.paddle_rect.getX() + Paddle.width / 3) {
        System.out.println("touches left");
        return true;
      }
    }
    return false;
  }

  public Boolean touchesRightPaddle() {
    if (touchesPaddle()) {
      if (ball_circle.getCenterX() >= Paddle.paddle_rect.getX() + 2 * Paddle.width / 3) {
        System.out.println("touches right");
        return true;
      }
    }
    return false;
  }

  public boolean touchesWall() {
    return ball_circle.getCenterX() - ball_circle.getRadius() <= 0
        || ball_circle.getCenterX() + ball_circle.getRadius() >= Main.SIZE;
  }

  public void bounce() {
    if (touchesPaddle() || touchesTop()) {
      BOUNCER_y_SPEED = -BOUNCER_y_SPEED;
    }
    if (touchesWall()) {
      BOUNCER_x_SPEED = -BOUNCER_x_SPEED;
    }
    if (touchesBottom()) {
      BOUNCER_x_SPEED = 0;
      BOUNCER_y_SPEED = 0;
    }

    if (touchesRightPaddle()) {
      BOUNCER_x_SPEED -= BOUNCER_x_SPEED * 0.350;
    }

    if (touchesLeftPaddle()) {
      BOUNCER_x_SPEED += BOUNCER_x_SPEED * 0.35;
    }
  }
}



