package Entities;

public abstract class AnimatedRenderable extends Renderable {
    protected final double time;

    public AnimatedRenderable(Position position, double time) {
        super(position.copy());
        this.time = time;
    }

    public abstract void animate(double t);


    public abstract boolean isDone();
}
