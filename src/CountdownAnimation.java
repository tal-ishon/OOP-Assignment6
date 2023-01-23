import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Tal Ishon.
 * CountdownAnimation class.
 * This class represents the count down before every level.
 */
public class CountdownAnimation implements Animation {
    private boolean running;
    private long numOfMillis;
    private int cFrom;
    private int initialCount;
    private SpriteCollection screen;
    private long initiationTime;


    /**
     * CountdownAnimation constructor.
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        running = true;
        numOfMillis = (long) (numOfSeconds * 1000);
        cFrom = countFrom;
        initialCount = countFrom;
        screen = gameScreen;
        initiationTime = System.currentTimeMillis();
    }
    @Override
    public void doOneFrame(DrawSurface d) {
        if (cFrom == 0) { // end of count down.
            this.running = false;
        }
        d.setColor(new Color(100, 250, 125));
        screen.drawAllOn(d);
        d.setColor(Color.decode("#fed88a"));
        d.drawText(370, 350, Integer.toString(cFrom), 100);
        if (System.currentTimeMillis() - initiationTime
                > numOfMillis / initialCount) {
            initiationTime = System.currentTimeMillis();
            // after every count decrease number of counts that are left.
            cFrom--;
        }
    }
    @Override
    public boolean shouldStop() {
        return !running;
    }
}
