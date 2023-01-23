import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Tal Ishon.
 * LevelIndicator class.
 * This class represents the sprite which shows the name level on screen.
 */
public class LevelIndicator implements Sprite {
    private LevelInformation level;
    private int width;
    private int height;

    /**
     * ScoreIndicator constructor.
     *
     * @param level  level's information.
     * @param width  the width of the indicator.
     * @param height the height of the indicator.
     */
    public LevelIndicator(LevelInformation level, int width, int height) {
        this.level = level;
        this.width = width;
        this.height = height;
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText((this.width / 2) + 200, 15, "Level Name: " + level.levelName(), 12);
    }

    @Override
    public void timePassed() {
    }

    /**
     * addToGame method.
     * This method add this ScoreIndicator to the game.
     *
     * @param g a game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}

