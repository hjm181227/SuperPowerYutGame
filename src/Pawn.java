import java.awt.*;

public class Pawn {
    private Point       location;
    private boolean     isFinished;

    public Pawn(){
        location = new Point();
        isFinished = false;
    }// constructor

    //  get, set
    public Point getLocation(){ return location; }
    public boolean getIsFinished(){ return isFinished; }

    public void setLocation(int a, int b){ location.x = a; location.y = b;}
    public void setLocation(Point pt){ location = pt; }
    public void setFinished(boolean a){ isFinished = a; }

    //  methods

}
