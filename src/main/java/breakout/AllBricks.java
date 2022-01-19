package breakout;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class AllBricks {

  public static Group bricks_group = new Group();
  public static int rows;
  public static int columns;
  public static Brick[][] bricks_array;
  public Ball b;
  public Random rand = new Random();
  public int MAX_POWER_UP = 3;
  public String RESOURCE_PATH;

  public AllBricks(Ball b, int level) {
    this.b = b;
    String RESOURCE_PARENT="src/main/resources/lvl_0";
    String LEVEL= String.valueOf(level);
    String RESOURCE_EXTENSION = ".txt";
    RESOURCE_PATH = RESOURCE_PARENT + LEVEL + RESOURCE_EXTENSION;

    ArrayList<ArrayList<Integer>> fullMatrix = getBricksLayout();
    bricks_array = new Brick[rows][columns];
    int powerUpCount = 0;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        int strength = fullMatrix.get(i).get(j);
        int xPos = Brick.width*j;
        int yPos = Brick.height*(i+2);
        boolean hasPowerUp = generatePowerUp(powerUpCount);
        Brick current_brick = new Brick(strength, xPos, yPos, Color.RED, hasPowerUp);
        if (strength==0){
          bricks_array[i][j] = null;
        }
        else{
        bricks_array[i][j] = current_brick;
        bricks_group.getChildren().add(current_brick.brick_rect);
      }
      }
    }
  }

  private boolean generatePowerUp(int powerUpCount) {
    boolean hasPowerUp = rand.nextBoolean();
    if(hasPowerUp){
      powerUpCount++;
    }
    else if (powerUpCount>= MAX_POWER_UP){
      hasPowerUp = false;
    }
  return hasPowerUp;
  }

  public ArrayList<ArrayList<Integer>> getBricksLayout() {
    File file = new File(RESOURCE_PATH);
    ArrayList<ArrayList<Integer>> fullMatrix = new ArrayList<ArrayList<Integer>>();
    try {
      Scanner scanner = new Scanner(file);
      rows=0;
      while (scanner.hasNextLine()) {
        rows++;
        String line = scanner.nextLine();
        ArrayList currentRow = new ArrayList<Integer>();
        String[] split_line = line.split(" ");
        columns = split_line.length;
        for (String digit:split_line){
          currentRow.add(Integer.parseInt(digit));
        }
        fullMatrix.add(currentRow);
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
    return fullMatrix;
  }

   public ArrayList<PowerUp> removeBrick(){
    ArrayList<PowerUp> allPowerUps = new ArrayList<PowerUp>();
    for (int i=0; i<rows; i++){
      for (int j=0; j<columns; j++){
        Brick current_brick = bricks_array[i][j];
        if(current_brick == null){
          continue;
        }
        if (ballIntersects(current_brick)){
          if (ballHitsTopOrBottomOf(current_brick)){
            Ball.BOUNCER_y_SPEED = - Ball.BOUNCER_y_SPEED;
          }
          if (ballHitsSidesOf(current_brick)){
            Ball.BOUNCER_x_SPEED = - Ball.BOUNCER_x_SPEED;
          }
          current_brick.strength--;
          current_brick.color = Brick.pickColor(current_brick.strength);
          if (current_brick.strength == 0) {
            bricks_group.getChildren().remove(current_brick.brick_rect);
            if (current_brick.hasPowerUp){
              PowerUp pow = new PowerUp(current_brick.brick_rect.getX()+current_brick.width/2, current_brick.brick_rect.getY()+current_brick.height/2);
              Main.root.getChildren().add(pow.ball_circle);
              allPowerUps.add(pow);
            }
            bricks_array[i][j] = null;
            Main.updateScore(1);
          }
        }
      }
    }
    return allPowerUps;
   }



  private boolean ballHitsSidesOf(Brick current_brick) {
    if((b.ball_circle.getCenterY() >= current_brick.brick_rect.getY()
        && b.ball_circle.getCenterX() <= current_brick.brick_rect.getY()+current_brick.height)){
      return true;
    }
    return false;
  }

  private boolean ballHitsTopOrBottomOf(Brick current_brick) {
    if(b.ball_circle.getCenterX() >= current_brick.brick_rect.getX()
        && b.ball_circle.getCenterX() <= current_brick.brick_rect.getX()+current_brick.width){
      return true;
    }
    return false;
  }

  private boolean ballIntersects(Brick current_brick){
        if(b.ball_circle.intersects(current_brick.brick_rect.getBoundsInLocal())){
          return true;
        }
        return false;
      }

    }

