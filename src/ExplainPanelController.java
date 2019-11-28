import javax.swing.JButton;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExplainPanelController {

    private ExplainPanel _explain;

    public ExplainPanelController(){
        _explain = GameManager.getInstance().get_explain();
        _explain.btnNext.addMouseListener(new moveExplainPageListener());
        _explain.btnPrev.addMouseListener(new moveExplainPageListener());
    }

    private class moveExplainPageListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            JButton btn = (JButton)e.getSource();
            if(btn == _explain.btnNext){
                _explain.imageIndex += 1;
            }
            else if(btn == _explain.btnPrev){
                if(_explain.imageIndex == 0){
                    GameManager.getInstance().get_view().showMenu();
                }
                else _explain.imageIndex -= 1;
            }
            _explain.lblTitle.setIcon(_explain.explains[_explain.imageIndex]);
            _explain.repaint();
        }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }
}
