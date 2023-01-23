import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tal Ishon.
 * Ass6Game class.
 * this class include the main.
 */
public class Ass6Game {
    /**
     * Main method.
     * runs the game.
     * @param args do nothing
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        KeyboardSensor sensor = gui.getKeyboardSensor();
        AnimationRunner ar = new AnimationRunner(gui, sensor);
        ScoreTrackingListener score = new ScoreTrackingListener(new Counter());
        int i = 0;
        LevelInformation gameLevel = null;
        List<LevelInformation> levels = new ArrayList<>();
        boolean runLevel = true;
        for (i = 0; i < args.length; i++) {
            // which level do we want to play
            switch (Integer.parseInt(args[i])) {
                case 1 -> gameLevel = new DirectHit();
                case 2 -> gameLevel = new WideEasy();
                case 3 -> gameLevel = new Green3();
                case 4 -> gameLevel = new FinalFour();
                // if there is not a valid input - don't add it to list
                default -> runLevel = false;
            }
            if (runLevel) {
                levels.add(gameLevel);
            }
            // make sure to continue adding the valid input to list
            runLevel = true;
        }
        if (args.length == 0 || levels.size() == 0) {
            // if there are no args in input or args are not valid for game
            // we just run the game from beginning till the end.
            levels.add(new DirectHit());
            levels.add(new WideEasy());
            levels.add(new Green3());
            levels.add(new FinalFour());
        }
        // run the game whether there is a valid input or not.
            GameFlow game = new GameFlow(ar, sensor);
            game.runLevels(levels);

    }
}
