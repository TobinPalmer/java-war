package Entities.Stack;

public class FaceUpStackEntity extends StackEntity {
    public Position position;

    public FaceUpStackEntity(Position position) {
        super(position);
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
