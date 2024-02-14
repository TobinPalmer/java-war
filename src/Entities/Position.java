package Entities;

public final class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Position add(int x, int y) {
        this.x += x;
        this.y += y;

        return this;
    }

    public Position copy() {
        return new Position(x, y);
    }
}
