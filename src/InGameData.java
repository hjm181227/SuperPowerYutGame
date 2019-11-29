import java.awt.*;

public class InGameData {
    public Player  leftPlayer, rightPlayer;
    public Pawn    focused;
    public int     throwResult;
    public BoardIndexData[] boardIndexer;
    public Point[] leftPawnWaiting, rightPawnWaiting;
    private int x = 770, y = 770;

    public InGameData(){
        GameManager.getInstance().set_gameData(this);

        leftPlayer = new Player("images/horsePawn.png", 70, 68);
        rightPlayer = new Player("images/pigPawn.png",100,75);
        focused = null;
        throwResult = 0;
        leftPlayer = new Player("images/horsePawn.png", 70, 68);
        rightPlayer = new Player("images/pigPawn.png", 100, 75);

        leftPawnWaiting = new Point[4];
        leftPawnWaiting[0] = new Point(25,410);
        leftPawnWaiting[1] = new Point(125,410);
        leftPawnWaiting[2] = new Point(25,510);
        leftPawnWaiting[3] = new Point(125,510);

        rightPawnWaiting = new Point[4];
        rightPawnWaiting[0] = new Point(800,410);
        rightPawnWaiting[1] = new Point(900,410);
        rightPawnWaiting[2] = new Point(800,510);
        rightPawnWaiting[3] = new Point(900,510);

        for(int i=0;i<4;i++) movePawn(leftPlayer.pawns[i], leftPawnWaiting[i]);
        for(int i=0;i<4;i++) movePawn(rightPlayer.pawns[i], rightPawnWaiting[i]);

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

    public void movePawn(Pawn pawn, Point pt){
        pawn.setLocation(pt.x, pt.y);
    }
}
