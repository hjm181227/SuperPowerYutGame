import javax.swing.*;
import java.awt.*;

public class InGameData {
    public Player  leftPlayer, rightPlayer;
    public Pawn    previewMovedPawn, focusedPawn;
    public int     throwResult;
    public BoardIndexData[] boardIndexer;
    public Point[] leftPawnWaiting, rightPawnWaiting;

    public Player activatedPlayer;

    public InGameData(){

        int x = 720, y = 720;

        GameManager.getInstance().set_gameData(this);
        leftPlayer = new Player("images/horsePawn.png", 70, 68);
        rightPlayer = new Player("images/pigPawn.png",100,75);

        leftPlayer.imgPlayer = new JLabel();
        leftPlayer.iconPalyer = new ImageIcon("images/bubble.gif");
        leftPlayer.imgPlayer.setIcon(leftPlayer.iconPalyer);
        leftPlayer.imgPlayer.setBounds(-25,90,250,230);

        rightPlayer.imgPlayer = new JLabel();
        rightPlayer.iconPalyer = new ImageIcon("images/dance.gif");
        rightPlayer.imgPlayer.setIcon(rightPlayer.iconPalyer);
        rightPlayer.imgPlayer.setBounds(-25,90,250,230);

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
        boardIndexer[5] = new BoardIndexData(697,32,5,true,26);
        boardIndexer[10] = new BoardIndexData(237,35,10,true,21);
        boardIndexer[15] = new BoardIndexData(237,490,15,false,0);
        boardIndexer[20] = new BoardIndexData(699,496,20,false,0);
        x = 697; y = 400;
        for(int i=1;i<=4;i++, y-=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[5].hasOtherPath = true;
        x = 601; y = 32;
        for(int i=6;i<=9;i++, x-=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[10].hasOtherPath = true;
        x = 237; y = 129;
        for(int i=11;i<=14;i++, y+=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        x = 332; y = 493;
        for(int i=16;i<=19;i++, x+=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);


        for(int i=21;i<=25;i++, x-=30, y+=30) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        boardIndexer[23].hasOtherPath = true;
        boardIndexer[23].shortCut = 28;
        for(int i=26;i<=29;i++, x+=30, y+=30) boardIndexer[i] = new BoardIndexData(x,y, i, false, 0);

        //set exceptional index
        boardIndexer[1].prevIndex = 20;
        boardIndexer[20].nextIndex = 0;
        boardIndexer[21].prevIndex = 10;

        boardIndexer[25].nextIndex = 20;
        boardIndexer[26].prevIndex = 5;
        boardIndexer[27].nextIndex = 23;
        boardIndexer[28].prevIndex = 23;
        boardIndexer[29].nextIndex = 15;
    }//constructor

    ///////////////////////////
    ///플레이어 턴 변경 관련 메소드///
    ///////////////////////////


    /////////////////////
    ///말 이동 관련 메소드///
    ////////////////////
    public void findNextPoint(){

        switch(focusedPawn.getCurrentIndex()) {
            case 5:
            case 10:
            case 23:
                if(throwResult == 6) {//빽도가 나오면 뒤로 한칸
                    break;
                }
                previewMovedPawn.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].shortCut);
                for(int i=1;i<throwResult;i++) previewMovedPawn.setIndex(boardIndexer[previewMovedPawn.getCurrentIndex()].nextIndex);
                break;
            default:
                if(throwResult == 6) {//빽도가 나오면 뒤로 한칸
                    break;
                }
                previewMovedPawn.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].nextIndex);
                for(int i=1;i<throwResult;i++) previewMovedPawn.setIndex(boardIndexer[previewMovedPawn.getCurrentIndex()].nextIndex);
                break;
        }
        System.out.println(boardIndexer[previewMovedPawn.getCurrentIndex()].p);
        previewMovedPawn.setLocation(boardIndexer[previewMovedPawn.getCurrentIndex()].p);
        GameManager.getInstance().get_inGame().repaint();
    }

    public void moveOnePawn(Pawn p, int end){

            p.setIndex(boardIndexer[end].currentIndex);//칸 인덱스 갱신
            if (boardIndexer[end].currentIndex == 0) {
                goWaitingRoom(p, activatedPlayer);
                p.setFinished(true);
                activatedPlayer.score++;
            }//완주시 대기실로 이동
            else p.setBounds(boardIndexer[boardIndexer[end].currentIndex].p.x,boardIndexer[boardIndexer[end].currentIndex].p.y,focusedPawn.getWidth(),focusedPawn.getHeight()); //좌표 이동
            System.out.println(boardIndexer[boardIndexer[end].currentIndex].p);
            catchOpponentPawns(boardIndexer[end]);
    }

    public void goWaitingRoom(Pawn pawn, Player owner) {
        pawn.setLocation(owner == leftPlayer ? leftPawnWaiting[pawn.pawnNumber] : rightPawnWaiting[pawn.pawnNumber]);
    }

    public void catchOpponentPawns(BoardIndexData index) {
        Player opponent = activatedPlayer == leftPlayer ? rightPlayer : leftPlayer;
        for(Pawn pawn:opponent.pawns){
            if(pawn.getCurrentIndex() == index.currentIndex){
                pawn.setIndex(0);
                goWaitingRoom(pawn, opponent);
            }//if
        }//for

    }//catchOpponentPawns()

    public void moveAllPawns(){
        Player opponent = activatedPlayer == leftPlayer ? rightPlayer : leftPlayer;
        BoardIndexData start = boardIndexer[focusedPawn.getCurrentIndex()], end = boardIndexer[previewMovedPawn.getCurrentIndex()];

        for(Pawn p: activatedPlayer.pawns){
            if(p.getCurrentIndex() == start.currentIndex) {
                p.setIndex(end.currentIndex);//칸 인덱스 갱신
                if(end.currentIndex == 0) {
                    goWaitingRoom(p,activatedPlayer);
                    p.setFinished(true);
                    activatedPlayer.score++;
                }//완주시 대기실로 이동
                else p.setLocation(boardIndexer[end.currentIndex].p); //좌표 이동
            }//출발지에 있는 말들 이동
        }

        if(end.currentIndex != 0) catchOpponentPawns(end);  //이동한 자리에 있는 상대말 잡기
    }


}
