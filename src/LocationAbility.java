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
            UpSide(_data.leftPlayer);
            UpSide(_data.rightPlayer);

        }

        public void UpSide(Player Player)
        {
            int[] CurrentIdx = new int[8];
            int PawnCount = 0;
            int i = 0, j = 0, flag = 0, RandomIdx;
            for (Pawn p : Player.pawns) {
                if (p.isFinished() == false && p.getCurrentIndex() != 0) {
                    for (j = 0, flag = 0; j < PawnCount; j++) {
                        if (CurrentIdx[j] == p.getCurrentIndex())
                            flag = 1;
                    }
                    if (flag == 0)
                        CurrentIdx[PawnCount++] = p.getCurrentIndex();
                }
            }
            for(i = 0 ; i < PawnCount; i++) {
                while (true) {
                    RandomIdx = (int) (Math.random() * 29) + 1;
                    for (j = 0, flag = 0; j < i; j++) {
                        if (Destination[i] == Destination[j])
                            flag = 1;
                    }
                    if (flag == 0) {
                        Destination[i] = RandomIdx;
                        break;
                    }
                }
            }
            System.out.println(">>>>>>>>>>>>" + i +"<<<<<<<<<<");
            for(i = 0; i < PawnCount; i++)
            {

                System.out.println(CurrentIdx[i]);
                System.out.println(">>"+Destination[i]+"<<");

                _data.moveAllPawns(Player, CurrentIdx[i], Destination[i]);
            }
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
                    else if(opponent.pawns[i].getCurrentIndex() == OpponentIdx) {
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

