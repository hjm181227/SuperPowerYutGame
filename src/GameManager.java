import javax.swing.*;
import java.awt.*;

public class GameManager {
    public Player player1, player2;
    public int    whoseTurn;
    public BoardIndexData[] boardIndexer;
    private int x = 770, y = 770;
    public GameManager(){
        player1 = new Player("images/horsePawn.png", 70, 68);
        player2 = new Player("images/pigPawn.png", 100, 75);


        boardIndexer = new BoardIndexData[30];
        for(int i=1;i<=5;i++, y-=35) boardIndexer[i] = new BoardIndexData(x, y, i+1,false, 0);
        boardIndexer[5].hasOtherPath = true;
        boardIndexer[5].shortCut = 21;
        for(int i=6;i<=10;i++, x-=35) boardIndexer[i] = new BoardIndexData(x, y, i+1,false, 0);
        boardIndexer[10].hasOtherPath = true;
        boardIndexer[10].shortCut = 26;
        for(int i=11;i<=15;i++, y+=35) boardIndexer[i] = new BoardIndexData(x, y, i+1,false, 0);
        for(int i=16;i<=20;i++, x+=35) boardIndexer[i] = new BoardIndexData(x, y, i+1,false, 0);
        x = 740;
        y = 30;
        for(int i=21;i<=25;i++, x-=30, y+=30) boardIndexer[i] = new BoardIndexData(x, y, i+1,false, 0);
        boardIndexer[23].hasOtherPath = true;
        boardIndexer[23].shortCut = 28;
        for(int i=26;i<=29;i++, x+=30, y+=30) boardIndexer[i] = new BoardIndexData(x,y, i+1, false, 0);

    }//constructor


}
