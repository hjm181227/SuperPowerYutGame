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
                if(_explain.imageIndex == 2){ btn.setText("Start"); }  //마지막 설명페이지에서 게임시작으로 버튼 이름 변경
                _explain.btnPrev.setText("Prev Page"); //게임설명 첫페이지를 제외하고 prev버튼 이름 변경
            }
            else if(btn == _explain.btnPrev){
                if(_explain.imageIndex == 0){
                    GameManager.getInstance().get_view().showMenu();
                }
                else _explain.imageIndex -= 1;
                if(_explain.imageIndex ==0) btn.setText("Menu");
                _explain.btnNext.setText("Next Page");
            }
            _explain.lblTitle.setIcon(_explain.explains[_explain.imageIndex]);
            _explain.repaint();
        }
    }


}

