/**
 *
 * @author Tal Ishon.
 * The interface Collidable.
 */
public interface Collidable {
    /**
     * getCollisionRectangle method.
     *
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * hit method.
     * Notify the object that we collided with it at collisionPoint with
     * a given velocity.
     *
     * @param ball               the ball which makes the hit
     * @param collisionPoint  the collision point
     * @param currentVelocity the current velocity
     * @return the new velocity expected after the hit (based on the force the object inflicted on us).
     */
    Velocity hit(Ball ball, Point collisionPoint, Velocity currentVelocity);
}
