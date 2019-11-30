import java.awt.*;
public class BoardIndexData {
    public Point    p;
    public int      currentIndex;
    public int      nextIndex;
    public boolean  hasOtherPath;
    public int      shortCut;
    public BoardIndexData(){}
    public BoardIndexData(int x, int y, int current, boolean bl, int index){
        p = new Point(x,y);
        currentIndex = current;
        nextIndex = current+1;
        hasOtherPath = bl;
        shortCut = index;
    }

    public boolean hasOtherPath() { return hasOtherPath; }

}
