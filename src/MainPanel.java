import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPanel extends JPanel{
    private MenuPanel Menu = new MenuPanel();
    private ExplainPanel GameExplain = new ExplainPanel();
    private YutGamePanel GameStart = new YutGamePanel();


    public MainPanel()
    {
        add(Menu);
        add(GameExplain);
        add(GameStart);
        Menu.btnStart.addActionListener(new MenuSelect());
        Menu.btnExplain.addActionListener(new MenuSelect());
        Menu.btnExit.addActionListener(new MenuSelect());
    }

    private class MenuSelect implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object Button = e.getSource();

            if (Menu.btnStart == Button) {
                Menu.setVisible(false);
                GameStart.setVisible(true);
            }
            else if (Menu.btnExplain == Button) {
                Menu.setVisible(false);
                GameExplain.setVisible(true);
            }
            else if (Menu.btnExit == Button) { System.exit(0);}

        }

    }

}
