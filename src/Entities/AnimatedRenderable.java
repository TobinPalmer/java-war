package Entities;

public abstract class AnimatedRenderable extends Renderable {
    private final Position startPosition;
    private final Position targetPosition;
    private final double time;

    public AnimatedRenderable(Position position, Position targetPosition, double time) {
        super(position.copy());
        this.startPosition = new Position(position.x, position.y);
        this.targetPosition = targetPosition;
        this.time = time;
    }

    public void animate(double t) {
        double progress = Math.min(t, time) / time;

        double x = (targetPosition.x - startPosition.x) * progress + startPosition.x;
        double y = (targetPosition.y - startPosition.y) * progress + startPosition.y;

        position.set((int) Math.round(x), (int) Math.round(y));
    }

    public boolean isDone() {
        return position.x == targetPosition.x && position.y == targetPosition.y;
    }
}
