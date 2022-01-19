package breakout;

import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PowerUp extends Ball{

  public PowerUp(double centerX, double centerY){
    super(centerX, centerY);
    this.ball_circle.setFill(Color.PURPLE);
  }


}
