import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InGameController {

    InGameView _view;
    InGameData _data;

    public InGameController() {

        _view = GameManager.getInstance().get_inGame();
        _data = GameManager.getInstance().get_gameData();

        for (Pawn p : _data.leftPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }
        for (Pawn p : _data.rightPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }
        _view.leftYutThrowBtn.addActionListener(new ThrowingYut());
        _view.rightThrowBtn.addActionListener(new ThrowingYut());

    }

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {
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

    private class FocusedPawnMove implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            int preview;
            if (_data.activatedPlayer == _data.leftPlayer) {

            }
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

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
            _data.throwResult = (int) Math.random() * 6 + 1;
            _view.lblThrowing.start();
            //btn.setEnabled(false);
        }
    }
}
