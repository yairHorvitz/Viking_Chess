/*
public class EatKing {
    public boolean eatKing4 (Position b) {
        if (getPieceAtPosition(b).getType().equals("♔")) {
            return false;
        }
        if (getPieceAtPosition(b).getOwner().equals(defender)) {
            return false;
        }//Those in the king's group do not eat it

        if (b.get_x() >= 1 && b.get_x() <= 9 && b.get_y() >= 1 && b.get_y() <= 9) {

            if (map[b.get_x() + 1][b.get_y()] != null && map[b.get_x() + 1][b.get_y()].getType().equals("♔")) {//The king is on my right
                if (b.get_x() != 9) {
                    if (map[b.get_x() + 2][b.get_y()] != null && map[b.get_x() + 2][b.get_y()].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() + 1][b.get_y() - 1].getOwner().equals(attacker)) {
                            if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                                return true;
                            }
                        }
                    }
                }
                if (b.get_x() == 9) {//The king in column 10
                    if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() + 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
            if (map[b.get_x() - 1][b.get_y()] != null && map[b.get_x() - 1][b.get_y()].getType().equals("♔")) {//The king is on my left
                if (b.get_x() != 1) {
                    if (map[b.get_x() - 2][b.get_y()] != null && map[b.get_x() - 2][b.get_y()].getOwner().equals(attacker)) {
                        if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                            if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                                return true;
                            }
                        }
                    }
                }
                if (b.get_x() == 1) {//The king in column 0
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
            if (map[b.get_x()][b.get_y() + 1] != null && map[b.get_x()][b.get_y() + 1].getType().equals("♔")) {//The king is below me
                if (b.get_y() != 9) {
                    if (map[b.get_x()][b.get_y() + 2] != null && map[b.get_x()][b.get_y() + 2].getOwner().equals(attacker)) {
                        if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                                return true;
                            }
                        }
                    }
                }
                if (b.get_y() == 9) {//The king in row 10
                    if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
            if (map[b.get_x()][b.get_y() - 1] != null && map[b.get_x()][b.get_y() - 1].getType().equals("♔")) {//The king is above me
                if (b.get_y() != 1) {
                    if (map[b.get_x()][b.get_y() - 2] != null && map[b.get_x()][b.get_y() - 2].getOwner().equals(attacker)) {
                        if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                            if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() + 1][b.get_y() - 1].getOwner().equals(attacker)) {
                                return true;
                            }
                        }
                    }
                }
                if (b.get_y() == 1) {//The king in row 0
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() + 1][b.get_y() - 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
    public boolean eatKing3 (Position b){
        if (getPieceAtPosition(b).getType().equals("♔")) {return false;}
        if (getPieceAtPosition(b).getOwner().equals(defender)) {return false;}//Those in the king's group do not eat it

        if(b.get_x() == 0){
            if(map[b.get_x()][b.get_y()-1]!=null && map[b.get_x()][b.get_y()-1].getType().equals("♔")) {//The king is above me
                if (map[b.get_x()][b.get_y() - 2] != null && map[b.get_x()][b.get_y() - 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()][b.get_y()+1]!=null && map[b.get_x()][b.get_y()+1].getType().equals("♔")) {//The king is below me
                if (map[b.get_x()][b.get_y() + 2] != null && map[b.get_x()][b.get_y() + 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()+1][b.get_y()]!=null && map[b.get_x()+1][b.get_y()].getType().equals("♔")){//The king is on my right
                if(map[b.get_x()+2][b.get_y()]!=null && map[b.get_x()+2][b.get_y()].getOwner().equals(attacker)){
                    if(map[b.get_x()+1][b.get_y()-1]!=null && map[b.get_x()+1][b.get_y()-1].getOwner().equals(attacker)){
                        if(map[b.get_x()+1][b.get_y()+1]!=null && map[b.get_x()+1][b.get_y()+1].getOwner().equals(attacker)){
                            return true;
                        }
                    }
                }
            }

        }
        if(b.get_x() == 10){
            if(map[b.get_x()][b.get_y()-1]!=null && map[b.get_x()][b.get_y()-1].getType().equals("♔")) {//The king is above me
                if (map[b.get_x()][b.get_y() - 2] != null && map[b.get_x()][b.get_y() - 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()][b.get_y()+1]!=null && map[b.get_x()][b.get_y()+1].getType().equals("♔")) {//The king is below me
                if (map[b.get_x()][b.get_y() + 2] != null && map[b.get_x()][b.get_y() + 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()-1][b.get_y()]!=null && map[b.get_x()-1][b.get_y()].getType().equals("♔")){//The king is on my left
                if (map[b.get_x() - 2][b.get_y()] != null && map[b.get_x() - 2][b.get_y()].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
        }
        if(b.get_y() == 0){
            if(map[b.get_x()+1][b.get_y()]!=null && map[b.get_x()+1][b.get_y()].getType().equals("♔")) {//The king is on my right
                if(map[b.get_x()+2][b.get_y()]!=null && map[b.get_x()+2][b.get_y()].getOwner().equals(attacker)){
                    if(map[b.get_x()+1][b.get_y()+1]!=null && map[b.get_x()+1][b.get_y()+1].getOwner().equals(attacker)){
                        return true;
                    }
                }
            }
            if(map[b.get_x()-1][b.get_y()]!=null && map[b.get_x()-1][b.get_y()].getType().equals("♔")) {//The king is on my left
                if (map[b.get_x() - 2][b.get_y()] != null && map[b.get_x() - 2][b.get_y()].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()][b.get_y()+1]!=null && map[b.get_x()][b.get_y()+1].getType().equals("♔")) {//The king is below me
                if (map[b.get_x()][b.get_y() + 2] != null && map[b.get_x()][b.get_y() + 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() + 1] != null && map[b.get_x() - 1][b.get_y() + 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() + 1] != null && map[b.get_x() + 1][b.get_y() + 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
        }
        if(b.get_y() == 10){
            if(map[b.get_x()+1][b.get_y()]!=null && map[b.get_x()+1][b.get_y()].getType().equals("♔")) {//The king is on my right
                if(map[b.get_x()+2][b.get_y()]!=null && map[b.get_x()+2][b.get_y()].getOwner().equals(attacker)){
                    if(map[b.get_x()+1][b.get_y()-1]!=null && map[b.get_x()+1][b.get_y()-1].getOwner().equals(attacker)){
                        return true;
                    }
                }
            }
            if(map[b.get_x()-1][b.get_y()]!=null && map[b.get_x()-1][b.get_y()].getType().equals("♔")) {//The king is on my left
                if (map[b.get_x() - 2][b.get_y()] != null && map[b.get_x() - 2][b.get_y()].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        return true;
                    }
                }
            }
            if(map[b.get_x()][b.get_y()-1]!=null && map[b.get_x()][b.get_y()-1].getType().equals("♔")) {//The king is above me
                if (map[b.get_x()][b.get_y() - 2] != null && map[b.get_x()][b.get_y() - 2].getOwner().equals(attacker)) {
                    if (map[b.get_x() - 1][b.get_y() - 1] != null && map[b.get_x() - 1][b.get_y() - 1].getOwner().equals(attacker)) {
                        if (map[b.get_x() + 1][b.get_y() - 1] != null && map[b.get_x() + 1][b.get_y() - 1].getOwner().equals(attacker)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
*/
//System.out.println(((Pawn)getPieceAtPosition(b)).get_ID() + ":" + ((Pawn)getPieceAtPosition(b)).get_kills());
                /*if(getPieceAtPosition(b).getOwner().equals(attacker)){attackPosition.get(map[b.get_x()][b.get_y()].get_number()).add(b);}
                if(getPieceAtPosition(b).getOwner().equals(defender)){defencePosition.get(map[b.get_x()][b.get_y()].get_number()).add(b);}
                System.out.print(map[b.get_x()][b.get_y()].get_ID() + ":" + "[");
                for (int i = 0; i < attackPosition.get(map[b.get_x()][b.get_y()].get_number()).size(); i++) {
                    Position position = attackPosition.get(map[b.get_x()][b.get_y()].get_number()).get(i);
                    System.out.print("(" + position.get_x() + "," + position.get_y() + ")" + ",");
                }
                for (int i = 0; i < defencePosition.get(map[b.get_x()][b.get_y()].get_number()).size(); i++) {
                    Position position = defencePosition.get(map[b.get_x()][b.get_y()].get_number()).get(i);
                    System.out.print("(" + position.get_x() + "," + position.get_y() + ")" + ",");
                }*/
