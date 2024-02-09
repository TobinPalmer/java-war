package Entities;

public abstract class AnimatedRenderable extends Renderable {
    private final Position targetPosition;
    private final double speed;

    public AnimatedRenderable(Position position, Position targetPosition, double speed) {
        super(position);
        this.targetPosition = targetPosition;
        this.speed = speed;
    }

    public void animate() {
        final double slope = (double) (targetPosition.y - position.y) / (targetPosition.x - position.x);
        final double angle = Math.atan(slope);
        final double x = speed * Math.cos(angle);
        final double y = speed * Math.sin(angle);
        position.add(new Position((int) x, (int) y));
    }
}
