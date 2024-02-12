package Entities;

import jdk.jfr.Timespan;

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

        public void add(Position position) {
            this.x += position.x;
            this.y += position.y;
        }

        public void set(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int y;

    }
}
