public class Pawn extends ConcretePiece {
    private int _kills;
    private String type;


    public Pawn(Player owner) {
        super(owner);
    }

    public int get_kills() {
        return _kills;
    }

    @Override
    public String getType() {
        if (super.getOwner().isPlayerOne()) {
            return "♙";
        } else {
            return "♟";
        }
    }
}
