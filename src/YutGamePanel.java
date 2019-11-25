import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class YutGamePanel extends JPanel {

    private GameManager     gameManager;
    private UserPanel       user1Panel, user2Panel;
    private ImagePanel      BoardPanel, YutPanelView;
    private JButton         btnThrow_1,btnThrow_2;



    public YutGamePanel(){
        gameManager = new GameManager();
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.white);
        setLayout(null);

        user1Panel = new UserPanel(gameManager.player1);
        user1Panel.setBounds(0,0,200,600);
        user1Panel.setVisible(true);
        add(user1Panel);

        user2Panel = new UserPanel(gameManager.player2);
        user2Panel.setBounds(800,0,200,600);
        add(user2Panel);

        BoardPanel = new ImagePanel(new ImageIcon("images/boardImage.png").getImage(), 600, 600, 200, 0);
        add(BoardPanel);

        YutPanelView = new ImagePanel(new ImageIcon("").getImage(), 600,200,200,600);
        YutPanelView.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(YutPanelView);

        //Player 1의 윷 던지기 버튼
        btnThrow_1 = new JButton("윷 던지기");
        btnThrow_1.setBounds(0,600,200,200);
        btnThrow_1.setLayout(null);
        btnThrow_1.setVisible(true);
        add(btnThrow_1);

        //Player 2의 윷 던지기 버튼
        btnThrow_2 = new JButton("윷 던지기");
        btnThrow_2.setBounds(800,600,200,200);
        btnThrow_2.setLayout(null);
        btnThrow_2.setVisible(true);
        add(btnThrow_2);


    }//constructor

    /*public void paintComponent(Graphics page){

        super.paintComponent(page);


    }//paintComponent()*/

    private class PawnClickListener implements MouseListener {

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) { }

        @Override
        public void mouseEntered(MouseEvent e) { }

        @Override
        public void mouseExited(MouseEvent e) { }
    }
}//YutGamePanel()
