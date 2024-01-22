import java.util.Arrays;

public class GameLogic implements PlayableLogic{

    private boolean flagTurns = false;//A Boolean value that will help transfer turns
    ConcretePiece [][] map = new ConcretePiece [11][11];

    ConcretePlayer defender = new ConcretePlayer(true);// this player own the king
    ConcretePlayer attacker = new ConcretePlayer(false);// need to play first
    ConcretePiece[] attackPositions = {
            new Pawn(attacker, "A1", 1, new Position(3, 0)),
            new Pawn(attacker, "A2", 2, new Position(4, 0)),
            new Pawn(attacker, "A3", 3, new Position(5, 0)),
            new Pawn(attacker, "A4", 4, new Position(6, 0)),
            new Pawn(attacker, "A5", 5, new Position(7, 0)),
            new Pawn(attacker, "A6", 6, new Position(5, 1)),
            new Pawn(attacker, "A7", 7, new Position(3, 0)),
            new Pawn(attacker, "A9", 9, new Position(0, 4)),
            new Pawn(attacker, "A11", 11, new Position(0, 5)),
            new Pawn(attacker, "A15", 15, new Position(0, 6)),
            new Pawn(attacker, "A17", 17, new Position(0, 7)),
            new Pawn(attacker, "A12", 12, new Position(1, 5)),
            new Pawn(attacker, "A8", 8, new Position(10, 3)),
            new Pawn(attacker, "A10", 10, new Position(10, 4)),
            new Pawn(attacker, "A14", 14, new Position(10, 5)),
            new Pawn(attacker, "A16", 16, new Position(10, 6)),
            new Pawn(attacker, "A18", 18, new Position(10, 7)),
            new Pawn(attacker, "A13", 13, new Position(9, 5)),
            new Pawn(attacker, "A20", 20, new Position(3, 10)),
            new Pawn(attacker, "A21", 21, new Position(4, 10)),
            new Pawn(attacker, "A22", 22, new Position(5, 10)),
            new Pawn(attacker, "A23", 23, new Position(6, 10)),
            new Pawn(attacker, "A24", 24, new Position(7, 10)),
            new Pawn(attacker, "A19", 19, new Position(5, 9))
    };
    ConcretePiece[] defencePositions = {
            new King(defender, "K7", 7, new Position(5, 5)), // white
            new Pawn(defender, "D1", 1, new Position(5, 3)), // "♙" - white
            new Pawn(defender, "D2", 2, new Position(4, 4)),
            new Pawn(defender, "D3", 3, new Position(5, 4)),
            new Pawn(defender, "D4", 4, new Position(6, 4)),
            new Pawn(defender, "D5", 5, new Position(3, 5)),
            new Pawn(defender, "D6", 6, new Position(4, 5)),
            new Pawn(defender, "D8", 8, new Position(6, 5)),
            new Pawn(defender, "D9", 9, new Position(7, 5)),
            new Pawn(defender, "D10", 10, new Position(4, 6)),
            new Pawn(defender, "D11", 11, new Position(5, 6)),
            new Pawn(defender, "D12", 12, new Position(6, 6)),
            new Pawn(defender, "D13", 13, new Position(5, 7))
    };


    /* ArrayList <ArrayList<Position>> defencePosition = new ArrayList<>();
    ArrayList <ArrayList<Position>> attackPosition = new ArrayList<>();*/
    public GameLogic (){
        startGame();

    }
       public void startGame(){// Default opening

           for (int i = 0; i <= 10; i++) {//Applying all cells as null
               for (int j = 0; j <= 10; j++) {
                   map[i][j] = null;
               }
           }
       //Manual application of the cells, on which game pieces sit
       map[5][5] = defencePositions[0];//new King(defender,"K7",7,new Position(5,5));//white
       map[5][3] = defencePositions[1];//new Pawn(defender,"D1",1,new Position(5,3));// "♙" - white
       map[4][4] = defencePositions[2];//new Pawn(defender,"D2",2,new Position(4,4));
       map[5][4] = defencePositions[3];//new Pawn(defender,"D3",3,new Position(5,4));
       map[6][4] = defencePositions[4];//new Pawn(defender,"D4",4,new Position(6,4));
       map[3][5] = defencePositions[5];//new Pawn(defender,"D5",5,new Position(3,5));
       map[4][5] = defencePositions[6];//new Pawn(defender,"D6",6,new Position(4,5));
       map[6][5] = defencePositions[7];//new Pawn(defender,"D8",8,new Position(6,5));
       map[7][5] = defencePositions[8];//new Pawn(defender,"D9",9,new Position(7,5));
       map[4][6] = defencePositions[9];//new Pawn(defender,"D10",10,new Position(4,6));
       map[5][6] = defencePositions[10];//new Pawn(defender,"D11",11,new Position(5,6));
       map[6][6] = defencePositions[11];//new Pawn(defender,"D12",12,new Position(6,6));
       map[5][7] = defencePositions[12];//new Pawn(defender,"D13",13,new Position(5,7));

       map[3][0]  = attackPositions[0];//new Pawn(attacker,"A1",1,new Position(3,0));// "♟" - black
       map[4][0]  = attackPositions[1];//new Pawn(attacker,"A2",2,new Position(4,0));
       map[5][0]  = attackPositions[2];//new Pawn(attacker,"A3",3,new Position(5,0));
       map[6][0]  = attackPositions[3];//new Pawn(attacker,"A4",4,new Position(6,0));
       map[7][0]  = attackPositions[4];//new Pawn(attacker,"A5",5,new Position(7,0));
       map[5][1]  = attackPositions[5];//new Pawn(attacker,"A6",6,new Position(5,1));
       map[0][3]  = attackPositions[6];//new Pawn(attacker,"A7",7,new Position(3,0));
       map[0][4]  = attackPositions[7];//new Pawn(attacker,"A9",9,new Position(0,4));
       map[0][5]  = attackPositions[8];//new Pawn(attacker,"A11",11,new Position(0,5));
       map[0][6]  = attackPositions[9];//new Pawn(attacker,"A15",15,new Position(0,6));
       map[0][7]  = attackPositions[10];//new Pawn(attacker,"A17",17,new Position(0,7));
       map[1][5]  = attackPositions[11];//new Pawn(attacker,"A12",12,new Position(1,5));
       map[10][3] = attackPositions[12];//new Pawn(attacker,"A8",8,new Position(10,3));
       map[10][4] = attackPositions[13];//new Pawn(attacker,"A10",10,new Position(10,4));
       map[10][5] = attackPositions[14];//new Pawn(attacker,"A14",14,new Position(10,5));
       map[10][6] = attackPositions[15];//new Pawn(attacker,"A16",16,new Position(10,6));
       map[10][7] = attackPositions[16];//new Pawn(attacker,"A18",18,new Position(10,7));
       map[9][5]  = attackPositions[17];//new Pawn(attacker,"A13",13,new Position(9,5));
       map[3][10] = attackPositions[18];//new Pawn(attacker,"A20",20,new Position(3,10));
       map[4][10] = attackPositions[19];//new Pawn(attacker,"A21",21,new Position(4,10));
       map[5][10] = attackPositions[20];//new Pawn(attacker,"A22",22,new Position(5,10));
       map[6][10] = attackPositions[21];//new Pawn(attacker,"A23",23,new Position(6,10));
       map[7][10] = attackPositions[22];//new Pawn(attacker,"A24",24,new Position(7,10));
       map[5][9]  = attackPositions[23];//new Pawn(attacker,"A19",19,new Position(5,9));

          /* for (int i = 0; i < 14; i++) {
               defencePosition.add(new ArrayList<Position>());
           }
           for (int i = 0; i < 25; i++) {
               attackPosition.add(new ArrayList<Position>());
           }

           for (int i = 0; i < 10; i++) {
               for (int j = 0; j < 10; j++) {
                   if(map[i][j]!=null && map[i][j].getOwner().equals(attacker)){attackPosition.get(map[i][j].get_number()).add(new Position(i,j));}
                   if(map[i][j]!=null && map[i][j].getOwner().equals(defender)){defencePosition.get(map[i][j].get_number()).add(new Position(i,j));}
               }
           }
*/
    }
    @Override
    public boolean move(Position a, Position b) {
        if(isSecondPlayerTurn()){if(getPieceAtPosition(a).getOwner().equals(defender)){return false;}}//Who can't move (whose turn is it)
        if(!isSecondPlayerTurn()){if(getPieceAtPosition(a).getOwner().equals(attacker)){return false;}}

            if (map[b.get_x()][b.get_y()] != null) {return false;}//The desired place is taken

            if ((a.get_x() != b.get_x()) && (a.get_y() != b.get_y())) {return false;}//Diagonal displacement
            if ((b.get_x() == 0 && b.get_y() == 0) || (b.get_x() == 0 && b.get_y() == 10) || (b.get_x() == 10 && b.get_y() == 0) || (b.get_x() == 10 && b.get_y() == 10)) {
                if (!getPieceAtPosition(a).getType().equals("♔")) {return false;}//Pawn wants to go to the corner
            }
            //You want to move to another empty square, and you are not a Pawn who wants to go to a corner
            if (a.get_x() == b.get_x()) {
                int min = Math.min(a.get_y(), b.get_y());
                int max = Math.max(a.get_y(), b.get_y());
                for (int i = min + 1; i < max; i++) {if (map[a.get_x()][i] != null) {return false;} }

                map[b.get_x()][b.get_y()] = map[a.get_x()][a.get_y()];//row update
                map[a.get_x()][a.get_y()] = null;
                    flagTurns = !flagTurns;//change of turn

                map[b.get_x()][b.get_y()].AddPosition(b);
                System.out.print(map[b.get_x()][b.get_y()].get_ID() + ":");
                System.out.print("[");
                map[b.get_x()][b.get_y()].getAllPositions();
                System.out.println("]");
                eat(b);
                if(!getPieceAtPosition(b).getType().equals("♔")){System.out.println(((Pawn)getPieceAtPosition(b)).get_ID() + ":" + ((Pawn)getPieceAtPosition(b)).get_kills());}

                return true;
            }
            if (a.get_y() == b.get_y()) {
                int min = Math.min(a.get_x(), b.get_x());
                int max = Math.max(a.get_x(), b.get_x());
                for (int i = min + 1; i < max; i++) {if (map[i][a.get_y()] != null) {return false;}}

                map[b.get_x()][b.get_y()] = map[a.get_x()][a.get_y()];//column update
                map[a.get_x()][a.get_y()] = null;
                    flagTurns = !flagTurns;//change of turn

                map[b.get_x()][b.get_y()].AddPosition(b);
                System.out.print(map[b.get_x()][b.get_y()].get_ID() + ":");
                System.out.print("[");
                map[b.get_x()][b.get_y()].getAllPositions();
                System.out.println("]");
                eat(b);
                if(!getPieceAtPosition(b).getType().equals("♔")){System.out.println(((Pawn)getPieceAtPosition(b)).get_ID() + ":" + ((Pawn)getPieceAtPosition(b)).get_kills());}

                return true;
            }
        return true;//Moving to a free space without moving over other tools
    }

    @Override
    public Piece getPieceAtPosition(Position position) {return map[position.get_x()][position.get_y()];}
   @Override
   public Player getFirstPlayer() {return defender;}
    @Override
    public Player getSecondPlayer() {return attacker;}//He plays first
    @Override
    public boolean isGameFinished() {
       if(isKingAtEdge()){
           //if(!isSecondPlayerTurn()){attacker.addWins();}//Added a win to the last player who played
           //Arrays.sort(defencePositions,new CompareByKills());
           Arrays.sort(defencePositions,new ComparatorBySteps());
           for (int i = 0; i < defencePositions.length; i++) {
               if(defencePositions[i]._positions.size() == 1){continue;}
               System.out.print(defencePositions[i].get_ID() + ":");
               System.out.print("[");
               defencePositions[i].getAllPositions();
               System.out.println("]");
           }
           Arrays.sort(attackPositions,new ComparatorBySteps());
           for (int i = 0; i < attackPositions.length; i++) {
               if(attackPositions[i]._positions.size() == 1){continue;}
               System.out.print(attackPositions[i].get_ID() + ":");
               System.out.print("[");
               attackPositions[i].getAllPositions();
               System.out.println("]");

           }
           if(isSecondPlayerTurn()){defender.addWins();}
           return true;}

       if(theKingIsSurrunder()){
           Arrays.sort(attackPositions,new ComparatorBySteps());
           for (int i = 0; i < attackPositions.length; i++) {
               if(attackPositions[i]._positions.size() == 1){continue;}
               System.out.print(attackPositions[i].get_ID() + ":");
               System.out.print("[");
               attackPositions[i].getAllPositions();
               System.out.println("]");
           }
           Arrays.sort(defencePositions,new ComparatorBySteps());
           for (int i = 0; i < defencePositions.length; i++) {
               if(defencePositions[i]._positions.size() == 1){continue;}
               System.out.print(defencePositions[i].get_ID() + ":");
               System.out.print("[");
               defencePositions[i].getAllPositions();
               System.out.println("]");
           }
           if(!isSecondPlayerTurn()){attacker.addWins();}//Added a win to the last player who played
           //if(isSecondPlayerTurn()){defender.addWins();}
           return true;}

        return false;
    }

    @Override
    public boolean isSecondPlayerTurn() {return !flagTurns;}//The use of this function is to transfer turns
    @Override
    public void reset() {startGame(); flagTurns = false;}
    @Override
    public void undoLastMove() {}
    @Override
    public int getBoardSize() {return 11;}
    public boolean isKingAtEdge (){
        if (map[0][0] != null && map[0][0].getType().equals("♔")){return true;}
        if (map[10][0] != null && map[10][0].getType().equals("♔")){return true;}
        if (map[0][10] != null && map[0][10].getType().equals("♔")){return true;}
        if (map[10][10] != null && map[10][10].getType().equals("♔")){return true;}
       return false;
    }
    public void eat (Position b){
    if (getPieceAtPosition(b).getType().equals("♔")) {return ;}//the king do not eat any piece

            if(b.get_y() != 1 && b.get_y() !=0){

            if(map[b.get_x()][b.get_y()-1]!=null && !map[b.get_x()][b.get_y()-1].getType().equals("♔") && !map[b.get_x()][b.get_y()-1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                if(map[b.get_x()][b.get_y()-2]!=null && !map[b.get_x()][b.get_y()-2].getType().equals("♔") && map[b.get_x()][b.get_y()-2].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())) {
                    map[b.get_x()][b.get_y() - 1] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }

            if(b.get_y() != 9 && b.get_y() != 10){

            if(map[b.get_x()][b.get_y()+1]!=null && !map[b.get_x()][b.get_y()+1].getType().equals("♔") && !map[b.get_x()][b.get_y()+1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                if(map[b.get_x()][b.get_y()+2]!=null&& !map[b.get_x()][b.get_y()+2].getType().equals("♔") && map[b.get_x()][b.get_y()+2].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                    map[b.get_x()][b.get_y()+1] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }

            if(b.get_x() != 0 && b.get_x() != 1){

            if(map[b.get_x()-1][b.get_y()]!=null && !map[b.get_x()-1][b.get_y()].getType().equals("♔") && !map[b.get_x()-1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())) {
                if (map[b.get_x() - 2][b.get_y()] != null && !map[b.get_x() - 2][b.get_y()].getType().equals("♔") && map[b.get_x() - 2][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())) {
                    map[b.get_x() - 1][b.get_y()] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }

            if(b.get_x() != 9 && b.get_x() != 10){

            if(map[b.get_x()+1][b.get_y()]!=null && !map[b.get_x()+1][b.get_y()].getType().equals("♔") && !map[b.get_x()+1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                if(map[b.get_x()+2][b.get_y()]!=null && !map[b.get_x()+2][b.get_y()].getType().equals("♔") && map[b.get_x()+2][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())) {
                    map[b.get_x() + 1][b.get_y()] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }
            if(b.get_x() == 1){
                if(map[b.get_x()-1][b.get_y()]!=null && !map[b.get_x()-1][b.get_y()].getType().equals("♔") && !map[b.get_x()-1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                    map[b.get_x() - 1][b.get_y()] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                }
            }
            if(b.get_x() == 9){
                if(map[b.get_x()+1][b.get_y()]!=null && !map[b.get_x()+1][b.get_y()].getType().equals("♔") && !map[b.get_x()+1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                    map[b.get_x() + 1][b.get_y()] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                }
            }
            if(b.get_y() == 1){
                if(map[b.get_x()][b.get_y()-1]!=null && !map[b.get_x()][b.get_y()-1].getType().equals("♔") && !map[b.get_x()][b.get_y()-1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                    map[b.get_x()][b.get_y() - 1] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                }
            }
            if(b.get_y() == 9){
                if(map[b.get_x()][b.get_y()+1]!=null && !map[b.get_x()][b.get_y()+1].getType().equals("♔") && !map[b.get_x()][b.get_y()+1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                    map[b.get_x()][b.get_y()+1] = null;
                    ((Pawn) getPieceAtPosition(b)).addKills();
                }
            }
            if(b.get_x() == 0 || b.get_x() == 10){//The king's corner is also considered the edge (and you can eat with it)
                if(b.get_y() == 8){
                    if(map[b.get_x()][b.get_y()+1]!=null && !map[b.get_x()][b.get_y()+1].getType().equals("♔") && !map[b.get_x()][b.get_y()+1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                        map[b.get_x()][b.get_y()+1] = null;
                        ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
                if(b.get_y() == 2){
                    if(map[b.get_x()][b.get_y()-1]!=null && !map[b.get_x()][b.get_y()-1].getType().equals("♔") && !map[b.get_x()][b.get_y()-1].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                        map[b.get_x()][b.get_y() - 1] = null;
                        ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }
            if(b.get_y() == 0 || b.get_y() == 10){//The king's corner is also considered the edge (and you can eat with it)
                if(b.get_x() == 2){
                    if(map[b.get_x()-1][b.get_y()]!=null && !map[b.get_x()-1][b.get_y()].getType().equals("♔") && !map[b.get_x()-1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                        map[b.get_x() - 1][b.get_y()] = null;
                        ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
                if(b.get_x() == 8){
                    if(map[b.get_x()+1][b.get_y()]!=null && !map[b.get_x()+1][b.get_y()].getType().equals("♔") && !map[b.get_x()+1][b.get_y()].getOwner().equals(map[b.get_x()][b.get_y()].getOwner())){
                        map[b.get_x() + 1][b.get_y()] = null;
                        ((Pawn) getPieceAtPosition(b)).addKills();
                    }
                }
            }
    }

   public boolean theKingIsSurrunder (){

      int x =  defencePositions[0]._positions.get(defencePositions[0]._positions.size()-1).get_x();
      int y =  defencePositions[0]._positions.get(defencePositions[0]._positions.size()-1).get_y();

       //int x = defencePositions[0].get_LastPosition().get_x();
       //int y = defencePositions[0].get_LastPosition().get_y();

      if((x > 0 && x < 10) && (y >0 && y <10)) {
        if (map[x + 1][y] != null && map[x + 1][y].getOwner().equals(attacker)) {
            if (map[x - 1][y] != null && map[x - 1][y].getOwner().equals(attacker)) {
                if (map[x][y + 1] != null && map[x][y + 1].getOwner().equals(attacker)) {
                    if (map[x][y - 1] != null && map[x][y - 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
        }
      }
      if(x == 0 && y!=10 && y!=0){
          if (map[x + 1][y] != null && map[x + 1][y].getOwner().equals(attacker)) {
                  if (map[x][y + 1] != null && map[x][y + 1].getOwner().equals(attacker)) {
                      if (map[x][y - 1] != null && map[x][y - 1].getOwner().equals(attacker)) {
                          return true;
                      }
                  }
              }
          }
      if(x == 10 && y!=10 && y!=0){
              if (map[x - 1][y] != null && map[x - 1][y].getOwner().equals(attacker)) {
                  if (map[x][y + 1] != null && map[x][y + 1].getOwner().equals(attacker)) {
                      if (map[x][y - 1] != null && map[x][y - 1].getOwner().equals(attacker)) {
                          return true;
                      }
                  }
              }
          }
      if(y == 0 && x!=0 && x!=10){
          if (map[x + 1][y] != null && map[x + 1][y].getOwner().equals(attacker)) {
              if (map[x - 1][y] != null && map[x - 1][y].getOwner().equals(attacker)) {
                  if (map[x][y + 1] != null && map[x][y + 1].getOwner().equals(attacker)) {
                          return true;
                  }
              }
          }
      }
      if(y == 10 && x!=0 && x!=10){
          if (map[x + 1][y] != null && map[x + 1][y].getOwner().equals(attacker)) {
              if (map[x - 1][y] != null && map[x - 1][y].getOwner().equals(attacker)) {
                      if (map[x][y - 1] != null && map[x][y - 1].getOwner().equals(attacker)) {
                          return true;
                }
              }
          }
        }
       return false;
   }


}
