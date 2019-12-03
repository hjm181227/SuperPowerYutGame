import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Player {
    public Pawn[]      pawns;
    public int         score;
    private Ability[]   abilities;
    public boolean     isMyTurn;
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
        abilities[0] = new Ability();
        abilities[1] = new Ability();
        score = 0;
        isMyTurn = false;

        iconPalyer = new ImageIcon[2];
        imgPlayer = new JLabel();

        lblTurn= new JLabel();
        lblTurn.setBounds(20,10,160,80);
        lblTurn.setFont(new Font("Verdana", Font.BOLD, 30));
        lblTurn.setText("My Turn!");
        lblTurn.setVisible(false);

    }

    //  methods
    public void movePawn(){}
}
