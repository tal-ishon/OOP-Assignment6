import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Tal Ishon.
 * EndScreen class.
 * This class represents the end message on screen whether the player won or lost.
 */
public class EndScreen implements Animation {
    private boolean win;
    private int score;

    /**
     * Constructor of a new Pause screen.
     *
     * @param win   the win
     * @param score the score
     */
    public EndScreen(boolean win, int score) {
        this.win = win;
        this.score = score;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (!win) {
            d.setColor(Color.black);
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.red);
            d.drawText(180, d.getHeight() / 2, "GAME OVER. Your score is: " + score, 32);
        } else {
            d.setColor(new Color(200, 100, 3).brighter().brighter());
            d.fillRectangle(0, 0, 800, 600);
            d.setColor(Color.white);
            d.drawText(180, d.getHeight() / 2, "YOU WIN! Your score is: " + score, 32);
        }
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}

