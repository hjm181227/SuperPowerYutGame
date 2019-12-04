import sun.plugin2.applet.Applet2Manager;

public class Ability {
    int[]       lPawn = new int[4];
    int[]       rPawn = new int[4];
    int         lCount,rCount;
    int         i,flag = 0;
    public Ability() {
    }//constructor

    public void RandomIndex(InGameData _gameData) {
        lCount = 0;
        for(Pawn p:_gameData.leftPlayer.pawns) {
            for(i = lCount,flag = 0; i >= 0; i--) {
                if (lPawn[i] == p.getCurrentIndex()){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                lPawn[lCount++] = p.getCurrentIndex();
        }
        for(Pawn p:_gameData.rightPlayer.pawns) {
            for(i = rCount,flag = 0; i >= 0; i--) {
                if (rPawn[i] == p.getCurrentIndex()){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0)
                lPawn[rCount++] = p.getCurrentIndex();
        }


    }

    public int MoOrDo() {
        return 3;
    }

    public int GaeOrGirl() {
        return 5;
    }

}

