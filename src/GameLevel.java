import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.List;

/**
 *
 * @author Tal Ishon.
 * GameLevel class.
 * This class creates a game level.
 */
public class GameLevel implements Animation {
    private AnimationRunner runner;
    private boolean running;
    private LevelInformation levelInformation;
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private int screenWidth = 800;
    private int screenHeight = 600;
    private BlockRemover remover;
    private Counter ballsLeft;
    private Paddle paddle;
    private ScoreTrackingListener score;
    private ScoreTrackingListener scoreTrackingListener;
    private ScoreIndicator scoreIndicator;
    private LevelIndicator levelIndicator;
    private biuoop.KeyboardSensor keyboard;

    /**
     * Game method.
     * This method constructs a game object.
     *
     * @param levelInfo the level info
     * @param kb        the kb
     * @param ar        the ar
     * @param sc        the sc
     * @param gui       the gui
     */
    public GameLevel(LevelInformation levelInfo, KeyboardSensor kb, AnimationRunner ar,
                     ScoreTrackingListener sc, GUI gui) {
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        remover = new BlockRemover(this, new Counter());
        ballsLeft = new Counter();
        score = new ScoreTrackingListener(sc.getCurrentScore());
        scoreTrackingListener = new ScoreTrackingListener(score.getCurrentScore());
        scoreIndicator = new ScoreIndicator(score.getCurrentScore(), screenWidth, screenHeight);
        levelIndicator = new LevelIndicator(levelInfo, screenWidth, screenHeight);
        runner = ar;
        levelInformation = levelInfo;
        keyboard = kb;
    }

    /**
     * AddCollidable Method.
     * This method adds a given collidable object to game.
     *
     * @param c a Collidable.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * GetBallsLeft method.
     *
     * @return the balls left
     */
    public Counter getBallsLeft() {
        return ballsLeft;
    }

    /**
     * GetRemainingBlocks method.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBlocks() {
        return remover.getRemainingBlocks();
    }

    /**
     * AddSprite method.
     * this method adds a given sprite object to game.
     *
     * @param s a sprite.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * RemoveCollidable method.
     *
     * @param c the collidable we want to remove
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * RemoveSprite method.
     *
     * @param s the sprite we want to remove
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * CreatePaddle method.
     * this method creates the paddle of the game.
     */
    public void setPaddle() {
        Rectangle r = new Rectangle(new Point((screenWidth - levelInformation.paddleWidth()) / 2, 560),
                levelInformation.paddleWidth(), 20);
        this.paddle = new Paddle(r, Color.orange, screenWidth, screenHeight, runner.getKeyboard());
        paddle.addToGame(this);
        this.addSprite(paddle);
    }

    /**
     * SetBalls method.
     * this method creates the balls of the game.
     */
    public void setBalls() {
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball = new Ball(new Point(screenWidth / 2, screenHeight / 1.1), 7, Color.white);
            ball.setVelocity(levelInformation.initialBallVelocities().get(i));
            ball.setGameEnvironment(this.environment);
            ball.addToGame(this);
            ball.setPaddle(paddle);
            ballsLeft.increase(1);
        }
    }

    /**
     * SetBlocks method.
     * initialize game's blocks.
     */
    public void setBlocks() {
        List<Block> blockList = levelInformation.blocks();
        for (int i = 0; i < levelInformation.numberOfBlocksToRemove(); i++) {
            blockList.get(i).addToGame(this);
            blockList.get(i).addHitListener(remover);
            blockList.get(i).addHitListener(scoreTrackingListener);
            remover.getRemainingBlocks().increase(1);
        }
    }

    /**
     * SetFrame method.
     * initialize game's frame.
     */
    public void setFrame() {
        addSprite(levelInformation.getBackground());
        Block[] frameBlocks = new Block[4];
        frameBlocks[0] = new Block(new Rectangle(new Point(0, 20), 800, 25), Color.lightGray);
        frameBlocks[1] = new Block(new Rectangle(new Point(0, 20), 25, 600), Color.lightGray);
        frameBlocks[2] = new Block(new Rectangle(new Point(775, 20), 25, 600), Color.lightGray);
        frameBlocks[3] = new Block(new Rectangle(new Point(0, 600), 800, 0), Color.lightGray);
        for (Block block : frameBlocks) {
            block.addToGame(this);
        }
        BallRemover ballRemover = new BallRemover(this, ballsLeft);
        // creating balls' death-region
        frameBlocks[3].addHitListener(ballRemover);
        scoreIndicator.addToGame(this);
        levelIndicator.addToGame(this);
    }

    /**
     * Initialize method.
     * Initialize a new game: create the Blocks and Ball (and Paddle),
     * and add them to the game.
     */
    public void initialize() {
        setFrame();
        setBlocks();
        setPaddle();
        setBalls();
    }

    /**
     * Run method.
     * Run the game -- start the animation loop.
     */
    public void run() {
        // countdown before turn starts.
        this.runner.run(new CountdownAnimation(2, 3, sprites));
        this.running = true;
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (getRemainingBlocks().getValue() == 0 || getBallsLeft().getValue() == 0) {
            if (getRemainingBlocks().getValue() == 0) { // if we removed all blocks in game
                score.getCurrentScore().increase(100);
            }
            running = false;
        }
        if (runner.getKeyboard().isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(keyboard, KeyboardSensor.SPACE_KEY, new PauseScreen()));
        }
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}
