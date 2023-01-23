import biuoop.DrawSurface;

/**
 * The interface Animation.
 */
public interface Animation {
    /**
     * DoOneFrame method.
     *
     * @param d the draw surface of game animation.
     */
    void doOneFrame(DrawSurface d);

    /**
     * ShouldStop method.
     *
     * @return true- if game should stop, false- if game should continue.
     */
    boolean shouldStop();
}
