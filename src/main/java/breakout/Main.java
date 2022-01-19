package breakout;

import java.util.ArrayList;
import javafx.animation.Animation.Status;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * Feel free to completely change this code or delete it entirely.
 *
 * @author Saad Lahrichi
 */
public class Main extends Application {

    // useful names for constant values used
    public static final String TITLE = "Breakout Beta";
    public static final int SIZE = 1000;
    public static final String RESOURCE_PATH = "/";
    public static final String BOUNCER_IMAGE = RESOURCE_PATH + "rcd";
    public static final int FRAMES_PER_SECOND = 120;
    public static final double SECOND_DELAY = 1.0 / FRAMES_PER_SECOND;
    public static Ball b;
    public static Paddle p;
    public static AllBricks allBricks;
    public static Text dispLives = new Text();
    public static Text dispScore = new Text();
    public static Timeline animation;
    public static Group root;
    public static Stage myStage;
    public static Scene scene;
    public static int lives = 3;
    public static int score = 0;

    /**
     * Initialize what will be displayed.
     */

    @Override
    public void start(Stage stage) {
        root = addElements(1);

        myStage=new Stage();
        addToScene();
        makeAnimation();
        myStage.setTitle(TITLE);
        myStage.show();
    }

    public static void handleKeyInput(KeyCode code) {
        // NOTE new Java syntax that some prefer (but watch out for the many special cases!)
        //   https://blog.jetbrains.com/idea/2019/02/java-12-and-intellij-idea/
        switch (code) {
            case RIGHT -> Paddle.move('R');
            case LEFT -> Paddle.move('L');
            case L -> updateLives(1);
            case P -> pause();
            case R -> resume();
            case DIGIT0 -> resetLevel();
            case DIGIT1 ->  changeLevel(1);
            case DIGIT2 ->  changeLevel(2);
            case DIGIT3 ->  changeLevel(3);

        }
    }

    public static void resetLevel() {
        b.resetBall();
        p.resetPaddle();
    }

    public static void updateLives(int i) {
        root.getChildren().remove(dispLives);
        lives = lives + i;
        dispLives.setText("Lives: " + lives);
        root.getChildren().add(dispLives);
    }

    public static void updateScore(int i) {
        root.getChildren().remove(dispScore);
        score = score + i;
        dispScore.setText("Score: " + score);
        root.getChildren().add(dispScore);
    }

    private static void makeAnimation() {
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames()
            .add(new KeyFrame(Duration.seconds(SECOND_DELAY), e -> step(SECOND_DELAY)));
        animation.play();

    }

    private static void addToScene() {
        scene = new Scene(root, SIZE, SIZE, Color.DIMGRAY);
        myStage.setScene(scene);
        myStage.show();
        scene.setOnKeyPressed(e -> handleKeyInput(e.getCode()));

    }

    private static Group addElements(int level) {
        Group newroot= new Group();
        p = new Paddle();
        newroot.getChildren().add(p.paddle_rect);

        dispScore.setText("Score: " + score);
        dispScore.setY(SIZE * 0.03);
        dispScore.setX(SIZE * 0.8);
        dispScore.setFill(Color.GREEN);
        dispScore.setOpacity(1);
        dispScore.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 20));
        newroot.getChildren().add(dispScore);

        dispLives.setText("Lives: " + lives);
        dispLives.setY(SIZE * 0.03);
        dispLives.setX(SIZE * 0.05);
        dispLives.setFill(Color.GREEN);
        dispLives.setOpacity(1);
        dispLives.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 20));
        newroot.getChildren().add(dispLives);

        b = new Ball(Main.SIZE * 0.5, Main.SIZE * 0.35);
        newroot.getChildren().add(b.ball_circle);

        allBricks = new AllBricks(b, level);
        newroot.getChildren().add(allBricks.bricks_group);
        return newroot;
    }

    public static void step(double elapsedTime) {
        // update "actors" attributes
        // bouncer moves at a "constant" rate now matter how many frames are drawn per second
        b.bounce();
        b.move(elapsedTime);
        ArrayList<PowerUp> allPowerUps = allBricks.removeBrick();
        for (PowerUp powerUp : allPowerUps) {
            powerUp.move(elapsedTime);
        }
    }

    public static void pause() {
        if (animation.getStatus() == Status.STOPPED) {
            animation.play();
        }
        animation.stop();
    }

    public static void resume() {
        animation.play();
    }


    public static void changeLevel( int level) {
        root=addElements(level);
        scene.setRoot(root);
        myStage.setScene(scene);




    }

}
