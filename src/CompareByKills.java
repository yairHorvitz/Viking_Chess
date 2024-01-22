import java.util.Comparator;
public class CompareByKills implements Comparator <Pawn>{
    public int compare (Pawn a,Pawn b){
        int ans = a.get_kills() - b.get_kills();
        if(ans > 0){return 1;}
        else if (ans < 0){return -1;}
        return 0;
    }
}
