import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Tal Ishon.
 * DirectHit class.
 * This class represents one of game's levels.
 */
public class DirectHit implements  LevelInformation {
    /**
     * DirectHit constructor.
     * Instantiates a new Direct hit.
     */
    public DirectHit() {
    }
    @Override
    public int numberOfBalls() {
        return 1;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        for (double i = 1; i <= numberOfBalls(); i++) {
            v.add(new Velocity(0, 5));
        }
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 110;
    }

    @Override
    public String levelName() {
        return "Direct Hit";
    }

    @Override
    public Sprite getBackground() {
        return new Background(levelName());
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            blocks.add(new Block(new Rectangle(new Point(380, 150), 40,  40), Color.PINK));
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
