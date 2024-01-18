import java.util.Objects;

public class Position {
    private int _x;
    private int _y;

    //constructor that takes initial coordinates (x, y) to create a position object with a specified starting point.
    public Position (int x, int y){
        _x = x;
        _y = y;}

    //functions
    //public Position getPosition(){return _x,_y;}
    public int get_x() {return _x;}
    public int get_y() {return _y;}
    public void set_x(int _x) {this._x = _x;}
    public void set_y(int _y) {this._y = _y;}

    //Designed to prevent a player from "moving" to the same slot, where he is already
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return _x == position._x && _y == position._y;
    }
    @Override
    public int hashCode() {return Objects.hash(_x, _y);}

}