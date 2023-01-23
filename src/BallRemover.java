/**
 * @author Tal Ishon.
 * BallRemover class.
 * in charge of removing balls from screen when it's needed.
 */
public class BallRemover implements HitListener {
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * Constructor of a new Block remover.
     *
     * @param gameLevel          the game
     * @param removedBall the removed ball
     */
    public BallRemover(GameLevel gameLevel, Counter removedBall) {
        this.gameLevel = gameLevel;
        this.remainingBalls = removedBall;
    }

    /**
     * GetRemainingBlocks.
     *
     * @return the remaining blocks
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     * GetGame method.
     *
     * @return the game
     */
    public GameLevel getGame() {
        return gameLevel;
    }

    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (getRemainingBalls().getValue() != 0) {
            getRemainingBalls().decrease(1); // only 1 block was hit
            hitter.removeFromGame(getGame());
        }
    }
}
