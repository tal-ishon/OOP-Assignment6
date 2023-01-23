import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tal Ishon.
 * FinalFour class.
 * This class reprents one of the game's levels.
 */
public class FinalFour implements LevelInformation {
    @Override
    public int numberOfBalls() {
        return 3;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(45, 5));
        v.add(new Velocity(0, -5));
        v.add(Velocity.fromAngleAndSpeed(-45, 5));
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
        return "Final Four";
    }

    @Override
    public Sprite getBackground() {
        return new Background(levelName());
    }

    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 7; i++) { // 7 rows of blocks
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat() / 3;
            float b = rand.nextFloat();
            Color randColor = new Color(r, g, b);
            for (int j = 15; j > 0; j--) {
                Block block = new Block(new Rectangle(new Point(800 - 25
                        - (50 * j), 150 + (20 * i)),
                        50, 20), randColor.brighter());
                blocks.add(block);
            }
        }
        return blocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
