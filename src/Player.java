import java.awt.*;
import java.util.ArrayList;

public class Player {
    public Pawn[]      pawns;
    public int         score;
    private Ability[]   abilities;
    public boolean     isMyTurn;
    public int        pawnImgWidth, pawnImgHeight;
    public Player(String img, int width, int height){

        pawnImgWidth = width;
        pawnImgHeight = height;
        pawns = new Pawn[4];
        for(int i=0;i<4;i++){
            pawns[i] = new Pawn(img, 0,0, width, height);
        }

        abilities = new Ability[2];
        abilities[0] = new Ability();
        abilities[1] = new Ability();
        score = 0;
        isMyTurn = false;
    }

    //  methods
    public void movePawn(){}
}
