import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ExplainPanelController {

    private ExplainPanel _explain;

    public ExplainPanelController(){
        _explain = GameManager.getInstance().get_explain();
        _explain.btnNext.addActionListener(new moveExplainPageListener());
        _explain.btnPrev.addActionListener(new moveExplainPageListener());
    }

    private class moveExplainPageListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton btn = (JButton)e.getSource();
            if(btn == _explain.btnNext){
                if(_explain.imageIndex == 2) {
                    GameManager.getInstance().get_view().showInGame(); //게임 바로시작
                    return;
                }
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

    }
}

