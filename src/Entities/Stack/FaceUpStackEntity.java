package Entities.Stack;

public class FaceUpStackEntity extends StackEntity {
    public Position position;

    public FaceUpStackEntity(Position position) {
        super(position, 0);
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public String[] getOverlay() {
        return new String[0];
    }
}
