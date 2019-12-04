import javax.swing.*;

public class Player {
    public Pawn[]      pawns;
    public int         score;
    private Ability[]   abilities;
    public boolean     isMyTurn;
    public int        pawnImgWidth, pawnImgHeight;
    public JLabel       imgPlayer;
    public ImageIcon    iconPalyer;

    public Player(String img, int width, int height){

        pawnImgWidth = width;
        pawnImgHeight = height;
        pawns = new Pawn[4];
        for(int i=0;i<4;i++){
            pawns[i] = new Pawn(img, 0,0, width, height, i);
        }

        abilities = new Ability[2];
        int random;
        random = (int)(Math.random() * 4);
        switch (random){
            case 0:
                abilities[0] = new MovementAbility.MoOrDo();
                break;
            case 1:
                abilities[0] = new MovementAbility.GaeOrGirl();
                break;
            case 2:
                abilities[0] = new MovementAbility.BackStep();
            case 3:
                abilities[0] = new MovementAbility.OnlyYut();
        }
        random = (int)(Math.random() * 4);
        switch (random){
            case 0:
                abilities[1] = new LocationAbility.Exchange();
                break;
            case 1:
                abilities[1] = new LocationAbility.GoHome();
                break;
            case 2:
                abilities[1] = new LocationAbility.UpSideDown();
        }

        score = 0;
        isMyTurn = false;

    }

    //  methods
    public void movePawn(){}
}
