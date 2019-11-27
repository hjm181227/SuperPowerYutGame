import javax.swing.*;
import java.awt.*;

public class Pawn extends JLabel {
    private int         currentIndex;
    private boolean     isFinished;
    private Image       pawnImg;
    public Pawn(String img, int x, int y, int width, int height){
        currentIndex = 0;
        isFinished = false;
        setIcon(new ImageIcon(img));
        setBounds(x,y,width,height);
    }// constructor

    //  get, set
    public int getCurrentIndex(){ return currentIndex; }
    public boolean getIsFinished(){ return isFinished; }

    public void setIndex(int idx){ currentIndex = idx;}
    public void setFinished(boolean a){ isFinished = a; }

    //  methods

}
