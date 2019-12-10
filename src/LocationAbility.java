import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LocationAbility {


    public static class GoHome extends Ability{

        Player opponent;
        SelectOpponent pawnL;
        @Override
        public void use() {
            //상대 말 하나 집으로 보내기
            opponent = _data.activatedPlayer == _data.leftPlayer ? _data.rightPlayer : _data.leftPlayer;
            pawnL = new SelectOpponent();
            System.out.println(opponent.pawns[0].getCurrentIndex());
            for(Pawn p:opponent.pawns)
            {
                if(p.getCurrentIndex()!=0){
                    p.addMouseListener(pawnL);
                }
            }

        }

        private class SelectOpponent implements MouseListener{

            @Override
            public void mouseReleased(MouseEvent e) {
                Pawn obj = (Pawn)e.getSource();
                for(Pawn p: opponent.pawns) {
                    if (obj.getCurrentIndex() == p.getCurrentIndex())
                        _data.goWaitingRoom(p, opponent);
                }
                for(Pawn p:opponent.pawns) if(p.getCurrentIndex()!=0) p.removeMouseListener(pawnL);

            }
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {}
        }
    }



    public static class UpSideDown extends Ability {
        public int[] Destination = new int [8];
        @Override
        public void use() {
            //밥상뒤집기
            LeftUpSide();
        }

        public void LeftUpSide()
        {
            int[] CurrentIdx = new int[8];
            int LeftCount = 0,CurrentCount = 0;
            int i = 0, j = 0, flag = 0, RandomIdx;

            for (Pawn p : _data.leftPlayer.pawns) {
                if (p.isFinished() == false && p.getCurrentIndex() != 0) {
                    flag = 0;
                    for (j = 0; j < CurrentCount; j++) {
                        if (CurrentIdx[j] == p.getCurrentIndex())
                            flag = 1;
                    }
                    if (flag == 0) {
                        CurrentIdx[CurrentCount++] = (p.getCurrentIndex() * -1);
                        p.setIndex(p.getCurrentIndex() * -1);
                        LeftCount++;
                    }
                }
            }
            for(i = 0 ; i < LeftCount;i++)System.out.println("왼쪽유저의 현재 폰넘버" + CurrentIdx[i]);
            for (Pawn p : _data.rightPlayer.pawns) {
                if (p.isFinished() == false && p.getCurrentIndex() != 0) {
                    for (j = LeftCount, flag = 0; j < CurrentCount; j++) {
                        if (CurrentIdx[j] == p.getCurrentIndex())
                            flag = 1;
                    }
                    if (flag == 0) {
                        CurrentIdx[CurrentCount++] = (p.getCurrentIndex() * -1);
                        p.setIndex(p.getCurrentIndex() * -1);
                    }
                }
            }

            System.out.println(LeftCount);
            for(i = 0 ; i < LeftCount; i++) {
                while (true) {
                    RandomIdx = (int) (Math.random() * 29) + 1;
                    flag = 0;
                    for (j = 0; j < i; j++) {
                        if (RandomIdx == Destination[j])
                            flag = 1;
                    }
                    if (flag == 0) {
                        Destination[i] = RandomIdx;
                        break;
                    }
                }
            }
            for(i = LeftCount ; i < CurrentCount; i++) {
                while (true) {
                    RandomIdx = (int) (Math.random() * 29) + 1;
                    for (j = 0, flag = 0; j < CurrentCount; j++) {
                        if (RandomIdx == Destination[j])
                            flag = 1;
                    }
                    if (flag == 0) {
                        Destination[i] = RandomIdx;
                        break;
                    }
                }
            }
            for(i = 0 ; i < CurrentCount; i++) System.out.println("걸러진" + Destination[i] + "인덱스");
            for(i = 0; i < LeftCount; i++) _data.moveAllPawns(_data.leftPlayer, CurrentIdx[i], Destination[i]);
            for(i = LeftCount; i < CurrentCount; i++) _data.moveAllPawns(_data.rightPlayer, CurrentIdx[i], Destination[i]);


        }

    }




    public static class Exchange extends Ability {
        Player opponent;
        SelectOpponent OpawnL;
        SelectActive ApawnL;
        int ActiveIdx, OpponentIdx;
        @Override
        public void use() {
            //상대 말과 자리바꾸기
            opponent = _data.activatedPlayer == _data.leftPlayer ? _data.rightPlayer : _data.leftPlayer;
            OpawnL = new SelectOpponent();
            ApawnL = new SelectActive();
            for(Pawn p:_data.activatedPlayer.pawns)
            {
                if(p.getCurrentIndex()!=0){
                    p.addMouseListener(ApawnL);
                }
            }
        }

        private class SelectOpponent implements MouseListener{
            int tmp;
            @Override
            public void mouseReleased(MouseEvent e) {
                Pawn obj = (Pawn)e.getSource();
                System.out.println(obj.pawnNumber + "번 상대 말 선택");
                for(Pawn p: opponent.pawns) {
                    if (obj.getCurrentIndex() == p.getCurrentIndex())
                        OpponentIdx = p.getCurrentIndex();
                }
                for(Pawn p:opponent.pawns) if(p.getCurrentIndex()!=0) p.removeMouseListener(OpawnL);
                for(int i = 0; i < 4; i++)
                {
                    if(_data.activatedPlayer.pawns[i].getCurrentIndex() == ActiveIdx) {
                        _data.activatedPlayer.pawns[i].setIndex(OpponentIdx);
                        _data.activatedPlayer.pawns[i].setLocation(_data.boardIndexer[OpponentIdx].p);
                    }
                    if(opponent.pawns[i].getCurrentIndex() == OpponentIdx) {
                        opponent.pawns[i].setIndex(ActiveIdx);
                        opponent.pawns[i].setLocation(_data.boardIndexer[ActiveIdx].p);
                    }
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) {}
        }

        private class SelectActive implements MouseListener{

            @Override
            public void mouseReleased(MouseEvent e) {
                Pawn obj = (Pawn)e.getSource();
                System.out.println(obj.pawnNumber + "번 폰 선택됨");
                for(Pawn p: _data.activatedPlayer.pawns) {
                    if (obj.getCurrentIndex() == p.getCurrentIndex())
                        ActiveIdx = p.getCurrentIndex();
                }
                for(Pawn p:_data.activatedPlayer.pawns) if(p.getCurrentIndex()!=0) p.removeMouseListener(ApawnL);
                for(Pawn p: opponent.pawns){
                    if(p.getCurrentIndex() != 0) p.addMouseListener(OpawnL);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
            @Override
            public void mouseClicked(MouseEvent e) { }
            @Override
            public void mousePressed(MouseEvent e) {}
        }
    }

}

