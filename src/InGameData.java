import com.sun.source.tree.UsesTree;

import java.awt.*;

public class InGameData {
    public Player  leftPlayer, rightPlayer;
    public Pawn    previewMovedPawn, focusedPawn;
    public int     throwResult;
    public BoardIndexData[] boardIndexer;
    public Point[] leftPawnWaiting, rightPawnWaiting;
    private int x = 770, y = 770;
    public Player activatedPlayer;

    public InGameData(){
        GameManager.getInstance().set_gameData(this);
        leftPlayer = new Player("images/horsePawn.png", 70, 68);
        rightPlayer = new Player("images/pigPawn.png",100,75);

        throwResult = 0;
        activatedPlayer = leftPlayer;
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

        for(int i=0;i<4;i++) leftPlayer.pawns[i].setLocation(leftPawnWaiting[i]);
        for(int i=0;i<4;i++) rightPlayer.pawns[i].setLocation(rightPawnWaiting[i]);

        boardIndexer = new BoardIndexData[30];
        boardIndexer[0] = new BoardIndexData(0,0,0,false,0);
        for(int i=1;i<=5;i++, y-=35) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[5].hasOtherPath = true;
        boardIndexer[5].shortCut = 21;
        for(int i=6;i<=10;i++, x-=35) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[10].hasOtherPath = true;
        boardIndexer[10].shortCut = 26;
        for(int i=11;i<=15;i++, y+=35) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        for(int i=16;i<=20;i++, x+=35) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[20].nextIndex = 0;

        x = 740;
        y = 30;
        for(int i=21;i<=25;i++, x-=30, y+=30) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[23].hasOtherPath = true;
        boardIndexer[23].shortCut = 28;
        for(int i=26;i<=29;i++, x+=30, y+=30) boardIndexer[i] = new BoardIndexData(x,y, i, false, 0);

    }//constructor

    ///////////////////////////
    ///플레이어 턴 변경 관련 메소드///
    ///////////////////////////
    public void passPlayerTurn(){
        activatedPlayer = activatedPlayer == leftPlayer ? rightPlayer : leftPlayer;
    }


    /////////////////////
    ///말 이동 관련 메소드///
    ////////////////////
    public int findNextPoint(){
        switch(focusedPawn.getCurrentIndex()) {
            case 5:
            case 10:
            case 23:
                previewMovedPawn.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].shortCut);
                break;
            default:
                previewMovedPawn.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].nextIndex);
                break;

        }
        return 0;
    }


    public void goWaitingRoom(Pawn pawn, Player owner) {
        pawn.setLocation(owner == leftPlayer ? leftPawnWaiting[pawn.pawnNumber] : rightPawnWaiting[pawn.pawnNumber]);
    }

    public void catchOpponentPawns(BoardIndexData index, Player opponent) {

        for(Pawn pawn:opponent.pawns){
            if(pawn.getCurrentIndex() == index.currentIndex){
                pawn.setIndex(0);
                goWaitingRoom(pawn, opponent);
            }//if
        }//for

    }//catchOpponentPawns()

    public void moveAllPawns(BoardIndexData start, BoardIndexData end, Player owner){
        Player opponent;

        opponent = owner == leftPlayer ? rightPlayer : leftPlayer;

        for(Pawn p: owner.pawns){
            if(p.getCurrentIndex() == start.currentIndex) {
                p.setIndex(end.currentIndex);//칸 인덱스 갱신
                if(end.currentIndex == 0) {
                    goWaitingRoom(p,owner);
                    p.setFinished(true);
                }//완주시 대기실로 이동
                else p.setLocation(boardIndexer[end.currentIndex].p); //좌표 이동
            }//출발지에 있는 말들 이동
        }

        if(end.currentIndex != 0) catchOpponentPawns(end, opponent);  //이동한 자리에 있는 상대말 잡기
    }

}
