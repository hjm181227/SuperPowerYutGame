import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InGameController {

    private InGameView _view;
    private InGameData _data;
    private PawnClickListener leftPawnListener, rightPawnListener;
    public InGameController() {

        _view = GameManager.getInstance().get_inGame();
        _data = GameManager.getInstance().get_gameData();

        leftPawnListener = new PawnClickListener();
        rightPawnListener = new PawnClickListener();

        _view.leftThrowBtn.addActionListener(new ThrowingYut());
        _view.rightThrowBtn.addActionListener(new ThrowingYut());

        _data.previewMovedPawn.addMouseListener(new MoveSelectedPawn());

        init_Game();
        ready(_data.activatedPlayer);
    }

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            System.out.println(3333);
            _data.focusedPawn = (Pawn)e.getSource();
            _data.previewMovedPawn.setVisible(true);
            _data.previewMovedPawn.setIcon(new ImageIcon(_data.focusedPawn.ImgSource()));
            _data.findNextPoint();
        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class MoveSelectedPawn implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

            if(_data.focusedPawn.getCurrentIndex()==0) _data.moveOnePawn(_data.activatedPlayer, _data.focusedPawn, _data.previewMovedPawn.getCurrentIndex());
            else _data.moveAllPawns(_data.activatedPlayer);
            for(Pawn p:_data.activatedPlayer.pawns) p.removeMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
            _data.previewMovedPawn.setVisible(false);
            //finish turn(pass turn)
            switch(_data.throwResult){
                case 4:
                case 5:
                    ready(_data.activatedPlayer);
                    break;
                default:
                    _data.activatedPlayer.isMyTurn = false;
                    passPlayerTurn();
                    _data.activatedPlayer.isMyTurn = true;
            }

            for(Pawn p:_data.activatedPlayer.pawns) p.removeMouseListener(_data.activatedPlayer == _data.leftPlayer ? leftPawnListener : rightPawnListener);
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
            if((_data.leftPlayer.isMyTurn && btn == _view.rightThrowBtn) || (_data.rightPlayer.isMyTurn && btn == _view.leftThrowBtn)) return;
            _data.throwResult = (int) (Math.random() * 5 + 1);
            _view.lblThrowing.start();
            for(Pawn p:_data.activatedPlayer.pawns) if(p.isFinished()==false) p.addMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
            btn.setEnabled(false);
            System.out.println(_data.throwResult);
        }
    }

    public void init_Game(){
        for(Pawn p:_data.leftPlayer.pawns)p.removeMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
        for(Pawn p:_data.rightPlayer.pawns)p.removeMouseListener(_data.activatedPlayer==_data.leftPlayer ? leftPawnListener : rightPawnListener);
        _view.leftThrowBtn.setEnabled(false);
        _view.rightThrowBtn.setEnabled(false);
    }

    public void ready(Player player){
        if(player == _data.leftPlayer) GameManager.getInstance().get_inGame().leftThrowBtn.setEnabled(true);
        else if(player == _data.rightPlayer) GameManager.getInstance().get_inGame().rightThrowBtn.setEnabled(true);
    }

    public void passPlayerTurn(){

        _data.activatedPlayer.isMyTurn = false;
        _data.activatedPlayer = _data.activatedPlayer == _data.leftPlayer ? _data.rightPlayer : _data.leftPlayer;
        _data.activatedPlayer.isMyTurn = true;
        ready(_data.activatedPlayer);
    }

    public void activate(){

    }
}
