import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tal Ishon.
 * WideEasy class.
 * one of the levels in game.
 */
public class WideEasy implements LevelInformation {
    /**
     * WideEasy constructor.
     * Instantiates a new Wide easy.
     */
    public WideEasy() {
    }
    @Override
    public int numberOfBalls() {
        return 10;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        for (double i = 1; i <= numberOfBalls() / 2; i++) {
            v.add(Velocity.fromAngleAndSpeed(-60 / 4.5 * i, 5));
        }
        for (double i = 1; i <= numberOfBalls() / 2; i++) {
            v.add(Velocity.fromAngleAndSpeed(60 / 4.5 * i, 5));
        }
        return v;
    }

    @Override
    public int paddleSpeed() {
        return 5;
    }

    @Override
    public int paddleWidth() {
        return 600;
    }

    @Override
    public String levelName() {
        return "Wide Easy";
    }

    @Override
    public Sprite getBackground() {
        return new Background(levelName());
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        Random rand = new Random();
        float r = rand.nextFloat();
        float g = rand.nextFloat();
        float b = rand.nextFloat();
        for (int i = 25; i <= 725; i += 50) {
            Color randColor = new Color(r, g, b);
            Block newBlock = new Block(new Rectangle(new Point(i, 300), 50, 20), randColor.brighter());
            blocks.add(newBlock);
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
