import javax.swing.*;
import java.awt.*;

public class Pawn extends JLabel {
    private int         currentIndex;
    private boolean     isFinished;
    private Image       pawnImg;
    public int pawnNumber;
    public Pawn(String img, int x, int y, int width, int height, int number){
        currentIndex = 0;
        isFinished = false;
        setIcon(new ImageIcon(img));
        setBounds(x,y,width,height);

        pawnNumber = number;
    }// constructor

    //  get, set
    public int getCurrentIndex(){ return currentIndex; }
    public boolean isFinished(){ return isFinished; }

    public void setIndex(int idx){ currentIndex = idx;}
    public void setFinished(boolean a){ isFinished = a; }

    //  methods

}
