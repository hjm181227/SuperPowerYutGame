import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InGameController {

    private InGameView _view;
    private InGameData _data;
    private PawnClickListener leftPawnListener, rightPawnListener;
    private double YutResult;

    public InGameController() {

        _view = GameManager.getInstance().get_inGame();
        _data = GameManager.getInstance().get_gameData();

        leftPawnListener = new PawnClickListener();
        rightPawnListener = new PawnClickListener();

        _view.leftThrowBtn.addActionListener(new ThrowingYut());
        _view.rightThrowBtn.addActionListener(new ThrowingYut());

        _view.leftUserPanel.btnAbility2.addActionListener(new UseAbility());
        _view.leftUserPanel.btnAbility1.addActionListener(new UseAbility());

        //_data.previewMovedPawn.addMouseListener(new MoveSelectedPawn());

        init_Game();

        change_playerImgnLabel();
        ready(_data.activatedPlayer);
    }

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {        }

        @Override
        public void mouseReleased(MouseEvent e) {
            _data.focusedPawn = (Pawn)e.getSource();
            System.out.println("폰을 클릭했다");
            for(ThrowData data:_data.previewPawns){
                data.preview.setVisible(true);
                data.preview.setIcon(new ImageIcon(_data.focusedPawn.ImgSource()));
            }
            _data.showAllPreviews();
            _view.repaint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {       }
        @Override
        public void mouseEntered(MouseEvent e) {       }
        @Override
        public void mouseExited(MouseEvent e) {       }
    }

    private class MoveSelectedPawn implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) { }

        @Override
        public void mouseReleased(MouseEvent e) {
            Pawn p = (Pawn)e.getSource();
            ThrowData clicked = null;
            boolean catched;


            for(ThrowData data:_data.previewPawns){
                if(data.preview == p) clicked = data;
            }
            //말 이동
            if(_data.focusedPawn.getCurrentIndex()==0) catched = _data.moveOnePawn(_data.activatedPlayer, _data.focusedPawn, p.getCurrentIndex());
            else catched = _data.moveAllPawns(_data.activatedPlayer,_data.focusedPawn.getCurrentIndex(),p.getCurrentIndex());
            for(ThrowData data:_data.previewPawns) data.preview.setVisible(false);
            _data.previewPawns.remove(clicked);
            _data.previewPawns.trimToSize();

            if(catched) {
                ready(_data.activatedPlayer);
                for(Pawn pawn:_data.activatedPlayer.pawns) pawn.removeMouseListener(_data.activatedPlayer == _data.leftPlayer ? leftPawnListener : rightPawnListener);
            }
            else if(_data.previewPawns.size()==0) {
                for(Pawn pawn:_data.activatedPlayer.pawns) pawn.removeMouseListener(_data.activatedPlayer == _data.leftPlayer ? leftPawnListener : rightPawnListener);
                passPlayerTurn();
            }

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

    private class ThrowingYut implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton) e.getSource();
            if ((_data.leftPlayer.isMyTurn && btn == _view.rightThrowBtn) || (_data.rightPlayer.isMyTurn && btn == _view.leftThrowBtn))
                return;
            YutResult = Math.random();
            if (YutResult <= 0.1536)
                _data.throwResult = 1;
            else if (YutResult <= 0.4992)
                _data.throwResult = 2;
            else if (YutResult <= 0.7584)
                _data.throwResult = 3;
            else if (YutResult <= 0.8880)
                _data.throwResult = 5;
            else if (YutResult <= 0.9136)
                _data.throwResult = 5;
            else if (YutResult < 1)
                _data.throwResult = 5;

            _view.lblThrowing.start();
            btn.setEnabled(false);

            _view.lblThrowing.setResult(_data.throwResult); //Yut으로 결과값보내서 결과이미지 띄우기
            //윷 사진이 바뀌기 전에 글자가 먼저 바뀜...
            _view.lblYutResult.setIcon(_data.iconYutText[_data.throwResult - 1]);

            if (_data.throwResult != 4 && _data.throwResult != 5)
                _data.throwableNCnt--;  //던질 수 있는 횟수 -1

            ThrowData data = new ThrowData(_data.throwResult);
            data.preview.addMouseListener(new MoveSelectedPawn());
            _data.previewPawns.add(data);   //던진 결과 저장
            _view.add(data.preview);
            _view.setComponentZOrder(data.preview, 0);


            /*
            if(_data.throwResult == 6) {
                for(Pawn p:_data.activatedPlayer.pawns) {
                    if(p.isFinished() == false && p.getCurrentIndex() != 0){
                        for(Pawn P:_data.activatedPlayer.pawns) if(P.isFinished()==false) P.addMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
                        return;
                    }
                }
                if(_data.throwableNCnt==0) passPlayerTurn();
            }
            */
            System.out.println(_data.throwableNCnt);
            if (_data.throwableNCnt == 0) {
                for (Pawn P : _data.activatedPlayer.pawns) {
                    if (P.isFinished() == false) {
                        P.addMouseListener(_data.activatedPlayer == _data.leftPlayer ? leftPawnListener : rightPawnListener);
                    }
                }
            }
            else {
                System.out.println("!23");
                ready(_data.activatedPlayer);
            }
        }
    }

    
    private class UseAbility implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
           Object obj = e.getSource();

            if(obj ==_view.leftUserPanel.btnAbility2)
            {
                if(_data.leftPlayer.abilities[1].isUsed() == false) {
                    _data.leftPlayer.abilities[1].use();
                    _data.leftPlayer.abilities[1].setUsed(true);
                    _view.repaint();
                }
            }
            else if(obj ==_view.leftUserPanel.btnAbility1)
            {
                if(_data.leftPlayer.abilities[0].isUsed() == false) {
                    _data.leftPlayer.abilities[0].use();
                    _data.leftPlayer.abilities[0].setUsed(true);
                    _view.repaint();
                }
            }
        }
    }

    public void init_Game(){
        for(Pawn p:_data.leftPlayer.pawns)p.removeMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
        for(Pawn p:_data.rightPlayer.pawns)p.removeMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
        _view.leftThrowBtn.setEnabled(false);
        _view.rightThrowBtn.setEnabled(false);
    }


    public void change_playerImgnLabel(){
        //left player turn
        if(_data.activatedPlayer == _data.leftPlayer){
            _data.leftPlayer.imgPlayer.setIcon(_data.leftPlayer.iconPalyer[0]);
            _data.leftPlayer.imgPlayer.setBounds(-25,90,250,230);
            _data.rightPlayer.imgPlayer.setIcon(_data.rightPlayer.iconPalyer[1]);
            _data.rightPlayer.imgPlayer.setBounds(-1,90,250,230);

            _data.leftPlayer.lblTurn.setVisible(true);
            _data.rightPlayer.lblTurn.setVisible(false);
        }
        //right player turn
        else{
            _data.leftPlayer.imgPlayer.setIcon(_data.leftPlayer.iconPalyer[1]);
            _data.leftPlayer.imgPlayer.setBounds(-1,90,250,230);
            _data.rightPlayer.imgPlayer.setIcon(_data.rightPlayer.iconPalyer[0]);
            _data.rightPlayer.imgPlayer.setBounds(-25,90,250,230);

            _data.leftPlayer.lblTurn.setVisible(false);
            _data.rightPlayer.lblTurn.setVisible(true);
        }
    }

    public void ready(Player player){
        if(player == _data.leftPlayer) GameManager.getInstance().get_inGame().leftThrowBtn.setEnabled(true);
        else if(player == _data.rightPlayer) GameManager.getInstance().get_inGame().rightThrowBtn.setEnabled(true);
        _data.throwableNCnt = 1;
    }

    public void passPlayerTurn(){

        //현재 플레이어의 말이 전부 완주하면 game end -> 대화상자
        if(_data.activatedPlayer.score ==4)

        _data.activatedPlayer.isMyTurn = false;
        _data.activatedPlayer = _data.activatedPlayer == _data.leftPlayer ? _data.rightPlayer : _data.leftPlayer;
        _data.activatedPlayer.isMyTurn = true;
        //윷 결과 지우기
        _view.lblYutResult.setIcon(_data.iconYutText[6]);

        change_playerImgnLabel();
        ready(_data.activatedPlayer);
    }

    public void activate(){

    }
}
