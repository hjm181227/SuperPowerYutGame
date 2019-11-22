import java.util.ArrayList;

public class Player {
    public Pawn[]      pawns;
    public int         score;
    public Ability[]   abilities;
    public boolean     isMyTurn;

    public Player(){

        pawns = new Pawn[4];
        for(int i=0;i<4;i++){
            pawns[i] = new Pawn();
        }

        abilities = new Ability[2];
        abilities[0] = new Ability();
        abilities[1] = new Ability();
        score = 0;
        isMyTurn = false;
    }

    //  methods
    public void movePawn(){}

    public void throwYut(){

    }
}
