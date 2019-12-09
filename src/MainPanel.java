import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel{

    private MenuPanel Menu;
    private ExplainPanel GameExplain;
    private InGameView GameStart;
    private InGameData GameData;

    ExplainPanelController e_control;
    InGameController g_control;

    public MainPanel()
    {
        GameManager.getInstance().set_view(this);

        setPreferredSize(new Dimension(1000,800));
        setLayout(null);
        Menu = new MenuPanel();
        GameExplain = new ExplainPanel();
        e_control = new ExplainPanelController();
        GameData = new InGameData();
        GameStart = new InGameView();
        g_control = new InGameController();
        add(Menu);
        add(GameExplain);
        add(GameStart);

        Menu.btnStart.addActionListener(new MenuSelect());
        Menu.btnStart.addMouseListener(new MenuSelectMouseEvent());
        Menu.btnExplain.addActionListener(new MenuSelect());
        Menu.btnExplain.addMouseListener(new MenuSelectMouseEvent());
        Menu.btnExit.addActionListener(new MenuSelect());
        Menu.btnExit.addMouseListener(new MenuSelectMouseEvent());


        showMenu();
      //  showInGame();
}

    public void showMenu(){
        Menu.setVisible(true);
        GameStart.setVisible(false);
        GameExplain.setVisible(false);
    }
    public void showInGame(){
        Menu.setVisible(false);
        GameStart.setVisible(true);
        GameExplain.setVisible(false);
    }//게임시작
    public void showExplain(){
        Menu.setVisible(false);
        GameStart.setVisible(false);
        GameExplain.setVisible(true);
    }//게임방법

    private class MenuSelect implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object Button = e.getSource();

            if (Menu.btnStart == Button) showInGame();
            else if (Menu.btnExplain == Button) showExplain();
            else if (Menu.btnExit == Button) { System.exit(0);}

        }
    }

    private class MenuSelectMouseEvent implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) { }
        @Override
        public void mousePressed(MouseEvent e) {  }
        @Override
        public void mouseReleased(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) {
            JButton btn = (JButton)e.getSource();
            btn.setForeground(new Color(150,100,50));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            JButton btn = (JButton)e.getSource();
            btn.setForeground(Color.black);

        }
    }

}
