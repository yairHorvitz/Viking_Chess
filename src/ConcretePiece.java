public abstract class ConcretePiece implements Piece {
    //I built abstract class that contain the tings that we need to built piece
    private Player owner;

    public ConcretePiece(Player owner) {
        this.owner = owner;
    }

    @Override
    public Player getOwner() {
        return owner;
    }

}
