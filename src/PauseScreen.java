import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Tal Ishon.
 * PauseScreen class.
 * represents the pause screen of the game.
 */
public class PauseScreen implements Animation {
    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(new Color(50, 100, 100).brighter().brighter());
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.white);
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
    }
    @Override
    public boolean shouldStop() {
        return false;
    }
}
