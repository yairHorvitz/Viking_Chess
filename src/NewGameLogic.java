//public class NewGameLogic implements PlayableLogic{
//    private boolean flagTurns = false;//A Boolean value that will help transfer turns
//    ConcretePiece [][] map = new ConcretePiece [11][11];
//
//    ConcretePlayer defender = new ConcretePlayer(true);// this player own the king
//    ConcretePlayer attacker = new ConcretePlayer(false);// need to play first
//
//    public NewGameLogic (){
//        startGame();
//
//    }
//    public void startGame(){// Default opening
//
//        map[5][5] = new King(defender,"K7");//white
//        map[3][5] = new Pawn(defender,"D1");// "♙" - white
//        map[4][4] = new Pawn(defender,"D2");
//        map[4][5] = new Pawn(defender,"D3");
//        map[4][6] = new Pawn(defender,"D4");
//        map[5][3] = new Pawn(defender,"D5");
//        map[5][4] = new Pawn(defender,"D6");
//        map[5][6] = new Pawn(defender,"D8");
//        map[5][7] = new Pawn(defender,"D9");
//        map[6][4] = new Pawn(defender,"D10");
//        map[6][5] = new Pawn(defender,"D11");
//        map[6][6] = new Pawn(defender,"D12");
//        map[7][5] = new Pawn(defender,"D13");
//
//        map[0][3] = new Pawn(attacker,"A1");// "♟" - black
//        map[0][4] = new Pawn(attacker,"A2");
//        map[0][5] = new Pawn(attacker,"A3");
//        map[0][6] = new Pawn(attacker,"A4");
//        map[0][7] = new Pawn(attacker,"A5");
//        map[1][5] = new Pawn(attacker,"A6");
//        map[3][0] = new Pawn(attacker,"A7");
//        map[4][0] = new Pawn(attacker,"A9");
//        map[5][0] = new Pawn(attacker,"A11");
//        map[6][0] = new Pawn(attacker,"A15");
//        map[7][0] = new Pawn(attacker,"A17");
//        map[5][1] = new Pawn(attacker,"A12");
//        map[3][10] = new Pawn(attacker,"A8");
//        map[4][10] = new Pawn(attacker,"A10");
//        map[5][10] = new Pawn(attacker,"A14");
//        map[6][10] = new Pawn(attacker,"A16");
//        map[7][10] = new Pawn(attacker,"A18");
//        map[5][9] = new Pawn(attacker,"A13");
//        map[10][3] = new Pawn(attacker,"A20");
//        map[10][4] = new Pawn(attacker,"A21");
//        map[10][5] = new Pawn(attacker,"A22");
//        map[10][6] = new Pawn(attacker,"A23");
//        map[10][7] = new Pawn(attacker,"A24");
//        map[9][5] = new Pawn(attacker,"A19");
//
//    }
//
//    @Override
//    public boolean move(Position a, Position b) {
//        if(isSecondPlayerTurn()){if(getPieceAtPosition(a).getOwner().equals(defender)){return false;}}//Who can't move (whose turn is it)
//        if(!isSecondPlayerTurn()){if(getPieceAtPosition(a).getOwner().equals(attacker)){return false;}}
//
//        if (map[b.get_x()][b.get_y()] != null) {return false;}//The desired place is taken
//
//        if ((a.get_x() != b.get_x()) && (a.get_y() != b.get_y())) {return false;}//Diagonal displacement
//        if ((b.get_x() == 0 && b.get_y() == 0) || (b.get_x() == 0 && b.get_y() == 10) || (b.get_x() == 10 && b.get_y() == 0) || (b.get_x() == 10 && b.get_y() == 10)) {
//            if (!getPieceAtPosition(a).getType().equals("♔")) {return false;}//Pawn wants to go to the corner
//        }
//        //You want to move to another empty square, and you are not a Pawn who wants to go to a corner
//        if (a.get_x() == b.get_x()) {
//            int min = Math.min(a.get_y(), b.get_y());
//            int max = Math.max(a.get_y(), b.get_y());
//            for (int i = min + 1; i < max; i++) {if (map[a.get_x()][i] != null) {return false;} }
//
//            map[b.get_x()][b.get_y()] = map[a.get_x()][a.get_y()];//column update
//            map[a.get_x()][a.get_y()] = null;
//            flagTurns = !flagTurns;//change of turn
//            eat(b);
//            return true;
//        }
//        if (a.get_y() == b.get_y()) {
//            int min = Math.min(a.get_x(), b.get_x());
//            int max = Math.max(a.get_x(), b.get_x());
//            for (int i = min + 1; i < max; i++) {if (map[i][a.get_y()] != null) {return false;}}
//
//            map[b.get_x()][b.get_y()] = map[a.get_x()][a.get_y()];//row update
//            map[a.get_x()][a.get_y()] = null;
//            flagTurns = !flagTurns;//change of turn
//            eat(b);
//            return true;
//        }
//        return true;//Moving to a free space without moving over other tools
//    }
//
//    @Override
//    public Piece getPieceAtPosition(Position position) {return map[position.get_x()][position.get_y()];}
//    @Override
//    public Player getFirstPlayer() {return defender;}
//    @Override
//    public Player getSecondPlayer() {return attacker;}//He plays first
//    @Override
//    public boolean isGameFinished() {
//        if(isKingAtEdge()){return true;}
//        //TODO (1) All soldiers of a certain player are eaten (2) The king is surrounded on all sides
//
//        return false;
//    }
//
//    @Override
//    public boolean isSecondPlayerTurn() {return !flagTurns;}//The use of this function is to transfer turns
//    @Override
//    public void reset() {startGame();}
//    @Override
//    public void undoLastMove() {}
//    @Override
//    public int getBoardSize() {return 11;}
//    public boolean isKingAtEdge (){
//        if (map[0][0] != null && map[0][0].getType().equals("♔")){return true;}
//        if (map[10][0] != null && map[10][0].getType().equals("♔")){return true;}
//        if (map[0][10] != null && map[0][10].getType().equals("♔")){return true;}
//        if (map[10][10] != null && map[10][10].getType().equals("♔")){return true;}
//        return false;
//    }
//    public void eat (Position b){
//        if (getPieceAtPosition(b).getType().equals("♔")) {return ;}//the king do not eat any piece
//
//        if(b.get_x() >=2 && b.get_x() <=7 && b.get_y() >=2 && b.get_y() <=7){
//            if(map[b.get_x()+1][b.get_y()]!=null && !map[b.get_x()+1][b.get_y()].getType().equals("♔") && !map[b.get_x()+1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                if(map[b.get_x()+2][b.get_y()]!=null&& !map[b.get_x()+2][b.get_y()].getType().equals("♔") && map[b.get_x()+2][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                    map[b.get_x()+1][b.get_y()] = null;
//
//                }
//            }
//        }
//        if(b.get_x() >=2 && b.get_x() <=7 && b.get_y() >=2 && b.get_y() <=7){
//            if(map[b.get_x()-1][b.get_y()]!=null && !map[b.get_x()-1][b.get_y()].getType().equals("♔") && !map[b.get_x()-1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                if(map[b.get_x()-2][b.get_y()]!=null && !map[b.get_x()-2][b.get_y()].getType().equals("♔") && map[b.get_x()-2][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                    map[b.get_x()-1][b.get_y()] = null;
//
//                }
//            }
//        }
//        if(b.get_x() >=2 && b.get_x() <=7 && b.get_y() >=2 && b.get_y() <=7){
//            if(map[b.get_x()][b.get_y()+1]!=null && !map[b.get_x()][b.get_y()+1].getType().equals("♔") && !map[b.get_x()][b.get_y()+1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                if(map[b.get_x()][b.get_y()+2]!=null&& !map[b.get_x()][b.get_y()+2].getType().equals("♔") && map[b.get_x()][b.get_y()+2].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                    map[b.get_x()][b.get_y()+1] = null;
//
//                }
//            }
//        }
//        if(b.get_x() >=2 && b.get_x() <=7 && b.get_y() >=2 && b.get_y() <=7){
//            if(map[b.get_x()][b.get_y()-1]!=null && !map[b.get_x()][b.get_y()-1].getType().equals("♔") && !map[b.get_x()][b.get_y()-1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                if(map[b.get_x()][b.get_y()-2]!=null && !map[b.get_x()][b.get_y()-2].getType().equals("♔") && map[b.get_x()][b.get_y()-2].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                    map[b.get_x()][b.get_y()-1] = null;
//                    ((Pawn) getPieceAtPosition(b)).addKills();
//
//                }
//            }
//        }
//   /* if(b.get_x() == 0 && b.get_y() >0 && b.get_y() <9){
//        if(map[b.get_x()+1][b.get_y()]!=null && !map[b.get_x()+1][b.get_y()].getType().equals("♔") && !map[b.get_x()+1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//            if(map[b.get_x()+2][b.get_y()]!=null && !map[b.get_x()+2][b.get_y()].getType().equals("♔") && map[b.get_x()+2][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
//                map[b.get_x()+1][b.get_y()] = null;
//
//            }
//        }
//    }*/
//
//
//
//
//
//    }
//}
