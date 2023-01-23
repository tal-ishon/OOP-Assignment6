import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * @author Tal Ishon.
 * GameFlow class.
 * This class is in charge of the game flow.
 */
public class GameFlow {
    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private ScoreTrackingListener score;

    /**
     * Instantiates a new Game flow.
     *
     * @param ar the ar
     * @param ks the ks
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {
        keyboardSensor = ks;
        animationRunner = ar;
        gui = animationRunner.getGui();
        score = new ScoreTrackingListener(new Counter());

    }

    /**
     * RunLevels method.
     *
     * @param levels the levels of the game.
     */
    public void runLevels(List<LevelInformation> levels) {
        boolean win = true;
        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo,
                    this.keyboardSensor,
                    this.animationRunner, score, gui);

            level.initialize();

             do {
                level.run();
            } while (!level.shouldStop());

            if (level.getBallsLeft().getValue() == 0) {
                win = false;
                break;
            }
        }
        this.animationRunner.run(
                new KeyPressStoppableAnimation(keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new EndScreen(win, score.getCurrentScore().getValue())));
        if (keyboardSensor.isPressed(KeyboardSensor.SPACE_KEY)) {
            gui.close();
        }
    }
}