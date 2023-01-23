import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Tal Ishon.
 * Green 3 class.
 * This class represents one of game's levels.
 */
public class Green3 implements LevelInformation {
    /**
     * Green3 constructor.
     * Instantiates a new Green 3.
     */
    public Green3() {
    }
    @Override
    public int numberOfBalls() {
        return 2;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> v = new ArrayList<>();
        v.add(Velocity.fromAngleAndSpeed(45, 5));
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
        return "Green 3";
    }

    @Override
    public Sprite getBackground() {
        return new Background(levelName());
    }
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 0; i < 6; i++) { // 6 rows of blocks
            Random rand = new Random();
            float r = rand.nextFloat();
            float g = rand.nextFloat() / 3;
            float b = rand.nextFloat();
            Color randomcolor = new Color(r, g, b);
            for (int j = 10 - i; j > 0; j--) {
                Block block = new Block(new Rectangle(new Point(800 - 25
                        - (55 * j), 150 + (25 * i)),
                        55, 25), randomcolor.brighter());
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
