import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainPanel extends JPanel{

    private MenuPanel Menu;
    private ExplainPanel GameExplain;
    private InGameView GameStart;
    private InGameData GameData;
    public btnMouseEvent btnlistener;

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

        btnlistener= new btnMouseEvent();

        Menu.btnStart.addActionListener(new MenuSelect());
        Menu.btnStart.addMouseListener(btnlistener);
        Menu.btnExplain.addActionListener(new MenuSelect());
        Menu.btnExplain.addMouseListener(btnlistener);
        Menu.btnExit.addActionListener(new MenuSelect());
        Menu.btnExit.addMouseListener(btnlistener);


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



}
