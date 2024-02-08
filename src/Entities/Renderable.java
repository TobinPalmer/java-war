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
    public final static class Position {
        public int x;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int y;

    }
}
