import java.awt.*;
public class BoardIndexData {
    public Point    p;
    public int      nextIndex;
    public boolean  hasOtherPath;
    public int      shortCut;
    public BoardIndexData(){}
    public BoardIndexData(int x, int y, int next, boolean bl, int index2){
        p = new Point(x,y);
        nextIndex = next;
        hasOtherPath = bl;
        shortCut = index2;
    }

}
