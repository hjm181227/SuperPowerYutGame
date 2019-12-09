import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class InGameData {
    public Player  leftPlayer, rightPlayer;
    public Pawn    previewMovedPawn, focusedPawn;
    public int     throwResult;
    public BoardIndexData[] boardIndexer;
    public Point[] leftPawnWaiting, rightPawnWaiting;

    public ImageIcon[]    iconYutText;
    public String[]  iconYutTextName = new String[7];


    public Player activatedPlayer;

    public ArrayList<ThrowData> previewPawns;
    public int throwableNCnt;




    public InGameData(){

        int x, y;

        GameManager.getInstance().set_gameData(this);
        leftPlayer = new Player("images/horsePawn.png", 70, 68);
        rightPlayer = new Player("images/pigPawn.png",100,75);

        throwResult = 0;
        activatedPlayer = leftPlayer;

        previewPawns = new ArrayList<ThrowData>();

        //플레이어 움직이는 사진지정
        leftPlayer.iconPalyer[0]= new ImageIcon("images/Left_move.gif");
        leftPlayer.iconPalyer[1]= new ImageIcon("images/Left_stop.png");

        rightPlayer.iconPalyer[0] = new ImageIcon("images/Right_move.gif");
        rightPlayer.iconPalyer[1] = new ImageIcon("images/Right_stop.png");

        leftPawnWaiting = new Point[4];
        leftPawnWaiting[0] = new Point(25,410);
        leftPawnWaiting[1] = new Point(125,410);
        leftPawnWaiting[2] = new Point(25,510);
        leftPawnWaiting[3] = new Point(125,510);

        rightPawnWaiting = new Point[4];
        rightPawnWaiting[0] = new Point(811,410);
        rightPawnWaiting[1] = new Point(911,410);
        rightPawnWaiting[2] = new Point(811,510);
        rightPawnWaiting[3] = new Point(911,510);

        for(int i=0;i<4;i++) leftPlayer.pawns[i].setLocation(leftPawnWaiting[i]);
        for(int i=0;i<4;i++) rightPlayer.pawns[i].setLocation(rightPawnWaiting[i]);

        //기본적인 길 인덱스
        boardIndexer = new BoardIndexData[30];
        boardIndexer[0] = new BoardIndexData(0,0,0,false,0);
        boardIndexer[5] = new BoardIndexData(697,32,5,true,26);
        boardIndexer[10] = new BoardIndexData(237,35,10,true,21);
        boardIndexer[15] = new BoardIndexData(237,490,15,false,0);
        boardIndexer[20] = new BoardIndexData(699,496,20,false,0);
        x = 697; y = 400;
        for(int i=1;i<=4;i++, y-=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        x = 601; y = 32;
        for(int i=6;i<=9;i++, x-=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        x = 237; y = 129;
        for(int i=11;i<=14;i++, y+=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);
        x = 332; y = 493;
        for(int i=16;i<=19;i++, x+=90) boardIndexer[i] = new BoardIndexData(x, y, i,false, 0);

        //지름길 인덱스 (왼쪽위 -> 오른쪽 아래, 중간 지점 인덱스 포함)
        boardIndexer[21] = new BoardIndexData(323, 123,21,false,0);
        boardIndexer[22] = new BoardIndexData(388, 188,22,false,0);
        boardIndexer[23] = new BoardIndexData(468, 263,23,true,24);
        boardIndexer[24] = new BoardIndexData(542, 343,24,false,0);
        boardIndexer[25] = new BoardIndexData(607, 408,25,false,0);
        //지름길 인덱스 (오른쪽위 -> 왼쪽아래, 중간 지점 인덱스 제외)
        boardIndexer[26] = new BoardIndexData(607, 123,26,false,0);
        boardIndexer[27] = new BoardIndexData(542, 188,27,false,0);
        boardIndexer[28] = new BoardIndexData(388, 343,28,false,0);
        boardIndexer[29] = new BoardIndexData(323, 408,29,false,0);

        //set exceptional index
        boardIndexer[0].nextIndex = 0;
        boardIndexer[1].prevIndex = 20;
        boardIndexer[21].prevIndex = 10;
        boardIndexer[23].nextIndex = 28;
        boardIndexer[26].prevIndex = 5;
        boardIndexer[25].nextIndex = 20;
        boardIndexer[27].nextIndex = 23;
        boardIndexer[28].prevIndex = 23;
        boardIndexer[29].nextIndex = 15;
        boardIndexer[20].nextIndex = 0;




        //윷던지고 결과 텍스트 이미지 변경
        iconYutTextName[0]="images/imgDO.png";
        iconYutTextName[1]="images/imgGAE.png";
        iconYutTextName[2]="images/imgGIRL.png";
        iconYutTextName[3]="images/imgYUT.png";
        iconYutTextName[4]="images/imgMO.png";
        iconYutTextName[5]="images/imgBDO.png";
        iconYutTextName[6]="images/none.png";

        iconYutText = new ImageIcon[7];
        for(int i=0; i<7; i++)
            iconYutText[i]= new ImageIcon(iconYutTextName[i]);





    }//constructor


    ///////////////////////////
    ///플레이어 턴 변경 관련 메소드///
    ///////////////////////////


    ////////////////////
    ///말 이동 관련 메소드///
    ////////////////////
    public void findNextPoint(ThrowData data){

        switch(focusedPawn.getCurrentIndex()) {
            case 0:
                if(data.result == 6) {
                    previewMovedPawn.setVisible(false);
                    return;
                }
                data.preview.setIndex(data.result);
                break;
            case 5:
                if(data.result == 6) {
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].prevIndex);
                }
                else {
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].shortCut);
                    for (int i = 1; i < data.result; i++)
                        data.preview.setIndex(boardIndexer[data.preview.getCurrentIndex()].nextIndex);
                    break;
                }
            case 10:
                if(data.result == 6)
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].prevIndex);
                else
                    data.preview.setIndex(21 + data.result - 1);
                    break;
            case 21:
                if(data.result == 6)
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].prevIndex);
                else if(data.result == 5)
                    data.preview.setIndex(20);
                else
                    data.preview.setIndex(22 + data.result - 1);
                break;
            case 22:
                if(data.result == 6)
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].prevIndex);
                else if(data.result == 5)
                    data.preview.setIndex(0);
                else
                    data.preview.setIndex(23 + data.result - 1);
                break;
            case 23:
                if(data.result == 6) {//빽도가 나오면 뒤로 한칸
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].prevIndex);
                    break;
                }
                data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].shortCut);
                for(int i=1;i<data.result;i++) data.preview.setIndex(boardIndexer[data.preview.getCurrentIndex()].nextIndex);
                break;
            default:
                if(data.result == 6) {//빽도가 나오면 뒤로 한칸
                    data.preview.setIndex((boardIndexer[focusedPawn.getCurrentIndex()].prevIndex));
                    break;
                }
                else {
                    data.preview.setIndex(boardIndexer[focusedPawn.getCurrentIndex()].nextIndex);
                    for (int i = 1; i < data.result; i++)
                        data.preview.setIndex(boardIndexer[data.preview.getCurrentIndex()].nextIndex);
                    break;
                }
        }

        data.preview.setLocation(boardIndexer[data.preview.getCurrentIndex()].p);
    }

    public void showAllPreviews(){
        for(ThrowData data:previewPawns) {
            if(data.result == 6 && focusedPawn.getCurrentIndex() == 0) continue;
            findNextPoint(data);
        }
        GameManager.getInstance().get_inGame().repaint();
    }

    public boolean moveOnePawn(Player owner, Pawn p, int end){
            p.setIndex(boardIndexer[end].currentIndex);//칸 인덱스 갱신
            if (boardIndexer[end].currentIndex == 0) {
                goWaitingRoom(p, owner);
                p.setFinished(true);
                activatedPlayer.score++;
            }//완주시 대기실로 이동
            else p.setBounds(boardIndexer[boardIndexer[end].currentIndex].p.x,boardIndexer[boardIndexer[end].currentIndex].p.y,focusedPawn.getWidth(),focusedPawn.getHeight()); //좌표 이동
            System.out.println(boardIndexer[boardIndexer[end].currentIndex].p);
            return catchOpponentPawns(owner == leftPlayer ? rightPlayer : leftPlayer, boardIndexer[end]);
    }

    public void goWaitingRoom(Pawn pawn, Player owner) {
        pawn.setLocation(owner == leftPlayer ? leftPawnWaiting[pawn.pawnNumber] : rightPawnWaiting[pawn.pawnNumber]);
    }

    public boolean catchOpponentPawns(Player opponent, BoardIndexData index) {
        boolean result = false;
        for(Pawn pawn:opponent.pawns){
            if(pawn.getCurrentIndex() == index.currentIndex){
                result = true;
                pawn.setIndex(0);
                goWaitingRoom(pawn, opponent);
            }//if
        }//for
        return result;
    }//catchOpponentPawns()

    public boolean moveAllPawns(Player owner,int start , int end){
        Player opponent = owner == leftPlayer ? rightPlayer : leftPlayer;

        for(Pawn p: owner.pawns){
            if(p.getCurrentIndex() == boardIndexer[start].currentIndex) {
                p.setIndex(boardIndexer[end].currentIndex);//칸 인덱스 갱신
                if(boardIndexer[end].currentIndex == 0) {
                    goWaitingRoom(p,owner);
                    p.setFinished(true);
                    owner.score++;
                }//완주시 대기실로 이동
                else p.setLocation(boardIndexer[boardIndexer[end].currentIndex].p); //좌표 이동
            }//출발지에 있는 말들 이동
        }

        if(boardIndexer[end].currentIndex != 0) return catchOpponentPawns(opponent, boardIndexer[end]);  //이동한 자리에 있는 상대말 잡기
        return false;
    }



    public void InGameData_init(){

        //left, rigght goroom(pawn[i], this)
        leftPlayer.Player_init();
        rightPlayer.Player_init();
        for(Pawn p:leftPlayer.pawns)
            goWaitingRoom(p, leftPlayer);
        for(Pawn p:rightPlayer.pawns)
            goWaitingRoom(p, rightPlayer);

        activatedPlayer= leftPlayer;
        throwResult=0;


    }

}
