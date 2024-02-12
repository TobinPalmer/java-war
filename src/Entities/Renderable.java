package Entities;

public abstract class Renderable {
    protected final Position position;

    protected Renderable(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public abstract String[] getOverlay();
}
