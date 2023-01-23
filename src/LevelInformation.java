import java.util.List;

/**
 * @author Tal Ishon.
 * The interface LevelInformation.
 */
public interface LevelInformation {
    /**
     * NumberOfBalls class.
     *
     * @return the number of balls in game.
     */
    int numberOfBalls();

    /**
     * InitialBallVelocities method.
     * The initial velocity of each ball.
     *
     * @return the list of balls' velocities.
     */
    List<Velocity> initialBallVelocities();

    /**
     * PaddleSpeed method.
     *
     * @return the paddle's speed.
     */
    int paddleSpeed();

    /**
     * PaddleWidth method.
     *
     * @return the paddle's width.
     */
    int paddleWidth();

    /**
     * LevelNameString method.
     *
     * @return the name of game's level.
     */
    String levelName();

    /**
     * GetBackground method.
     *
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * Blocks method.
     *
     * @return the list of blocks that make up this level. Each block contains its size, color and location.
     */
    List<Block> blocks();

    /**
     * NumberOfBlocksToRemove method.
     *
     * @return the number of blocks that should be removed before the level is considered to be "cleared".
     */
    int numberOfBlocksToRemove();
}
