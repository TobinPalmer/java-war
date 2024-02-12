package Entities;

public abstract class AnimatedRenderable extends Renderable {
    private final Position startPosition;
    private final Position targetPosition;
    private final double time;

    public AnimatedRenderable(Position position, Position targetPosition, double time) {
        super(position);
        this.startPosition = position;
        this.targetPosition = targetPosition;
        this.time = time;
    }

    public void animate(double t) {
        double x = (targetPosition.x - startPosition.x) * (t / time) + position.x;
        double y = (targetPosition.y - startPosition.y) * (t / time) + position.y;
        position.set((int) x, (int) y);
    }

    public boolean isDone() {
        return position.x == targetPosition.x && position.y == targetPosition.y;
    }
}
