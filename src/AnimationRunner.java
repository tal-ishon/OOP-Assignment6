import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

/**
 * @author Tal Ishon.
 * AnimationRunner class.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond = 60;
    private Sleeper sleeper;
    private biuoop.KeyboardSensor keyboard;

    /**
     * constructor of a new Animation runner.
     *
     * @param gui      the gui
     * @param keyboard the keyboard
     */
    public AnimationRunner(GUI gui, KeyboardSensor keyboard) {
        this.gui = gui;
        this.sleeper = new biuoop.Sleeper();
        this.keyboard = keyboard;
    }

    /**
     * GetKeyboard method.
     *
     * @return the keyboard
     */
    public KeyboardSensor getKeyboard() {
        return keyboard;
    }

    /**
     * GetGui method.
     *
     * @return the gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     * Run method.
     *
     * @param animation the animation which we run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 1000 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();
            animation.doOneFrame(d);
            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
