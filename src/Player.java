import javax.swing.*;
import java.awt.*;


public class Player {
    public Pawn[]      pawns;
    public int         score;
    public Ability[]   abilities;
    public boolean     isMyTurn, isNowAbility1Use, isNowAbility2Use;
    public int        pawnImgWidth, pawnImgHeight;

    public JLabel       imgPlayer, lblTurn;
    public ImageIcon[]    iconPalyer;


    public Player(String img, int width, int height){

        pawnImgWidth = width;
        pawnImgHeight = height;
        pawns = new Pawn[4];
        for(int i=0;i<4;i++){
            pawns[i] = new Pawn(img, 0,0, width, height, i);
        }

        abilities = new Ability[2];
        int random;


        /*
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
        */


        /*
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

         */
        abilities[0]= new MovementAbility.OnlyYut();
//        abilities[1] = new LocationAbility.UpSideDown();
        abilities[1] = new LocationAbility.Exchange();
        score = 0;
        isMyTurn = false;
        isNowAbility1Use= false;
        isNowAbility2Use= false;

        iconPalyer = new ImageIcon[2];
        imgPlayer = new JLabel();

        lblTurn= new JLabel();
        lblTurn.setBounds(21 ,10,160,80);
        lblTurn.setFont(new Font("OCR A Extended", Font.BOLD, 30));
        lblTurn.setText("My Turn!");
        lblTurn.setVisible(false);

    }

    //  methods
    public void movePawn(){}



    public void Player_init(){
        this.score=0;
        this.isMyTurn=false;
        this.isNowAbility1Use=false;
        this.isNowAbility2Use=false;
        for(Pawn p:this.pawns){
            p.Pawn_init();
        }


    }

}
