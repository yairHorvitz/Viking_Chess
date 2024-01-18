import java.util.ArrayList;

public abstract class ConcretePiece implements Piece{
    private Player _owner;
    private String _ID;
    private int _number;
    private ArrayList <Position> _positions = new ArrayList<>();
    public ConcretePiece (Player player , String id, int number, Position position){
        _owner = player;
        _ID = id;
        _number = number;
        _positions.add(position);
    }
    @Override
    public Player getOwner() {return _owner;}
    public void set_owner(Player player) {this._owner = player;}
    @Override
    public String getType() {return null;}
    public int get_number() {return _number;}
    public String get_ID() {return _ID;}
    public Position get_LastPosition() {return _positions.get(_positions.size()-1);}//Getting the last member
    public void AddPosition(Position p){_positions.add(p);}//Adding a member to arraylist
    public void getAllPositions (){for (Position position : _positions) {System.out.print("(" + position.get_x() +","+ position.get_y() + ")");}}
}
