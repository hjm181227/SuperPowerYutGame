import javax.swing.*;
import java.awt.*;

public class Pawn extends JLabel {
    private int         currentIndex;
    private boolean     isFinished;
    private String       pawnImg;
    public int pawnNumber;

    public Pawn(){setBounds(0,0,79,68);}
    public Pawn(String img, int x, int y, int width, int height, int number){
        currentIndex = 0;
        isFinished = false;
        pawnImg = img;
        setIcon(new ImageIcon(img));
        setBounds(x,y,width,height);

        pawnNumber = number;
    }// constructor

    //  get, set

    public int getCurrentIndex(){ return currentIndex; } //
    public boolean isFinished(){ return isFinished; }
    public String ImgSource(){ return pawnImg; }
    public void setIndex(int idx){ currentIndex = idx;}
    public void setFinished(boolean a){ isFinished = a; }

    //  methods
    public void setPawnImg(String img){
        pawnImg= img;
        setIcon(new ImageIcon(img));
    }

    public void Pawn_init(){
        this.currentIndex=0;
        this.isFinished=false;
    }

}
