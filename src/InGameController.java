import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InGameController {

    InGameView _view;

    public InGameController(){
        _view = GameManager.getInstance().get_inGame();
        for(Pawn p:GameManager.getInstance().get_gameData().leftPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }
        for(Pawn p:GameManager.getInstance().get_gameData().rightPlayer.pawns) {
            //_view.add(p);
            p.addMouseListener(new PawnClickListener());
        }

    }

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }

    private class FocusedPawnMove implements MouseListener {


        @Override
        public void mouseClicked(MouseEvent e) {

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
}
