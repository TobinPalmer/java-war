package Entities;

public abstract class Renderable {
    public final static class Position {
        public int x;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int y;

    }

    public abstract Position getPosition();

    public abstract String[] getOverlay();
}
