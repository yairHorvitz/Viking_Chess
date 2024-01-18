import java.lang.reflect.Array;

public class King extends ConcretePiece {

    private String type = "♔";
    private Position kingPosition;

    public void setKingPosition(Position kingPosition, Position kingB)//change the king place
    {
        kingPosition.setX(kingB.getX());
        kingPosition.setY(kingB.getY());
    }
    public King(Player owner) {
        super(owner);
    }

    public String getType() {
        return this.type;
    }
}
