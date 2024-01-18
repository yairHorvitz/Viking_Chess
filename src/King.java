import java.util.ArrayList;

public class King extends ConcretePiece{
    private Player _player;
    private String _ID;
    private int _number;
    private ArrayList <Position> _positions = new ArrayList<>();
    public King (Player attackerOrDefender, String id,int number,Position position){
        super(attackerOrDefender,id,number,position);
        _player = attackerOrDefender;
        _ID = id;
        _number = number;
        _positions.add(position);
    };
    @Override
    public String getType() {
        return "♔";
    }// white king
    @Override
    public Player getOwner() {return super.getOwner();}
    public Position get_LastPosition() {return _positions.get(_positions.size()-1);}//Getting the last member
    //public void AddPosition(Position p){_positions.add(p);}//Adding a member to arraylist
    //public void getAllPositions (){for (Position position : _positions){System.out.print("(" + position.get_x() +","+ position.get_y() + ")");}}
}
