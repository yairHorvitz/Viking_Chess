public class GameLogic implements PlayableLogic {
    ConcretePiece[][] board;
    ConcretePlayer attacker;
    ConcretePlayer defender;
    boolean secondPlayerTurn = true;

    public GameLogic() {
        board = new ConcretePiece[11][11];
        defender = new ConcretePlayer(true);
        attacker = new ConcretePlayer(false);

        board[5][5] = new King(defender);
        board[0][3] = new Pawn(attacker);
        board[0][4] = new Pawn(attacker);
        board[0][5] = new Pawn(attacker);
        board[0][6] = new Pawn(attacker);
        board[0][7] = new Pawn(attacker);
        board[1][5] = new Pawn(attacker);

        board[3][0] = new Pawn(attacker);
        board[4][0] = new Pawn(attacker);
        board[5][0] = new Pawn(attacker);
        board[6][0] = new Pawn(attacker);
        board[7][0] = new Pawn(attacker);
        board[5][1] = new Pawn(attacker);

        board[10][3] = new Pawn(attacker);
        board[10][4] = new Pawn(attacker);
        board[10][5] = new Pawn(attacker);
        board[10][6] = new Pawn(attacker);
        board[10][7] = new Pawn(attacker);
        board[9][5] = new Pawn(attacker);

        board[3][10] = new Pawn(attacker);
        board[4][10] = new Pawn(attacker);
        board[5][10] = new Pawn(attacker);
        board[6][10] = new Pawn(attacker);
        board[7][10] = new Pawn(attacker);
        board[5][9] = new Pawn(attacker);

        board[7][5] = new Pawn(defender);
        board[6][5] = new Pawn(defender);
        board[4][5] = new Pawn(defender);
        board[3][5] = new Pawn(defender);

        board[6][4] = new Pawn(defender);
        board[5][4] = new Pawn(defender);
        board[4][4] = new Pawn(defender);

        board[6][6] = new Pawn(defender);
        board[5][6] = new Pawn(defender);
        board[4][6] = new Pawn(defender);

        board[5][3] = new Pawn(defender);

        board[5][7] = new Pawn(defender);

    }

    @Override
    public boolean move(Position a, Position b)
    {
        //check who is turn
        ConcretePiece moveNow = board[a.getY()][a.getX()];//  the piece that we want to move
      if (moveNow.getOwner().isPlayerOne() == secondPlayerTurn) { return false;} // to check if owner to moveNow is his turn

        if ((b.getX() != a.getX()) && (b.getY() != a.getY())// check that the piece is not walk diagonally
                 || Position.equalsPosition(b, a))// check that the piece is not stay in his place
        {return false;}
        

         if(a.getX()==b.getX())//check that the piece don't walk on other player in his raw
            {
                int minY, maxY;
                minY = Math.min(a.getY(), b.getY());
                maxY = Math.max(a.getY(), b.getY());
                for (int i = minY+1; i < maxY; i++) {
                    if (board[i][a.getX()]!=null)
                        return false;
                }
            }
         if(a.getY()==b.getY()) //check that the piece dont walk on other player in his coll
            {
                int minX, maxX;
                minX = Math.min(a.getX(), b.getX());
                maxX = Math.max(a.getX(), b.getX());
                for (int i = minX+1; i < maxX; i++) {
                    if (board[a.getY()][i]!=null)
                        return false;
                }
            }

if (((moveNow.getType()=="♙")||(moveNow.getType()=="♟"))&& (((b.getX()==0) && (b.getY()==0))||((b.getX()==10) && (b.getY()==0))
       ||((b.getX()==0) && (b.getY()==10))||((b.getX()==10) && (b.getY()==10))))//the pawn will not arrive to the corner
        {
     return false;}



        board[b.getY()][b.getX()] = board[a.getY()][a.getX()];
        board[a.getY()][a.getX()]=null;

        if(secondPlayerTurn==true) {secondPlayerTurn=false;}//after the turn change the turn to the other player
        else {secondPlayerTurn=true;}
        return true;
    }

    @Override
    public Piece getPieceAtPosition(Position position) {
        return board[position.getY()][position.getX()];
    }

    @Override
    public Player getFirstPlayer() {
        return defender;
    }

    @Override
    public Player getSecondPlayer() {
        return attacker;
    }

    @Override
    public boolean isGameFinished() {
        return false;
    }

    //check if it is SecondPlayerTurn
    @Override
    public boolean isSecondPlayerTurn() {
        return secondPlayerTurn;
    }

    @Override
    public void reset() {

    }

    @Override
    public void undoLastMove() {

    }

    @Override
    public int getBoardSize() {
        return 11;
    }
}
