import java.util.ArrayList;

public class Pawn extends ConcretePiece {
    private int _kills;
    private String _ID;
    private Player _player;
    private int _number;
    private ArrayList <Position> _positions = new ArrayList<>();

    //constructor
    public Pawn (Player attackerOrDefender, String id,int number,Position position){
        super(attackerOrDefender,id,number,position);
        _kills = 0;
         _player = attackerOrDefender;
         _ID = id;
         _number = number;
       _positions.add(position);
    }

    //function
    public int get_kills() {return _kills;}
    public void set_kills(int _kills) {this._kills = _kills;}
    @Override
    public String getType() {
        if (!getOwner().isPlayerOne()){return "♟";}// Black pawn
        return "♙";// White pawn
    }
    @Override
    public Player getOwner() {return super.getOwner();}
    public void addKills(){
        _kills++;
    }
    //public void AddPosition(Position p){_positions.add(p);}//Adding a member to arraylist
    //public Position get_LastPosition() {return _positions.get(_positions.size()-1);}//Getting the last member
    //public void getAllPositions (){for (Position position : _positions) {System.out.print("(" + position.get_x() +","+ position.get_y() + ")");}}

}
