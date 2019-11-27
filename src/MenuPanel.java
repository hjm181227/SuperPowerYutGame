import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//게임을 시작하면 맨 처음 메뉴가 나오는 패널
public class MenuPanel extends JPanel {

    private JLabel lblTitle;
    private ImagePanel BoardPanel, YutPanelView;
    private JButton btnStart, btnExplain, btnExit;


    public MenuPanel() {
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.white);
        setLayout(null);

        //게임의 타이틀
        lblTitle = new JLabel("초능력 윷놀이 !");
        lblTitle.setBounds(220, 150, 600, 100);
        lblTitle.setFont(new Font("Vernada", Font.BOLD, 80));
        lblTitle.setVisible(true);
        add(lblTitle);

        //게임시작 버튼 세팅
        btnStart = new JButton("게임 시작");
        btnStart.setBounds(300, 300, 400, 100);
        btnStart.setFont(new Font("Vernada", Font.BOLD, 60));
        btnStart.addActionListener(new ButtonClick());
        btnStart.setVisible(true);
        add(btnStart);

        //게임방법 버튼 세팅
        btnExplain = new JButton("게임 방법");
        btnExplain.setBounds(300, 400, 400, 100);
        btnExplain.setFont(new Font("Vernada", Font.BOLD, 60));
        btnExplain.addActionListener(new ButtonClick());
        btnExplain.setVisible(true);
        add(btnExplain);

        //게임종료 버튼 세팅
        btnExit = new JButton("게임 종료");
        btnExit.setBounds(300, 500, 400, 100);
        btnExit.setFont(new Font("Vernada", Font.BOLD, 60));
        btnExit.addActionListener(new ButtonClick());
        btnExit.setVisible(true);
        add(btnExit);


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
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }

    private class ButtonClick implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object Button = e.getSource();

            if (btnStart == Button) {
                setVisible(false);
            } else if (btnExplain == Button) {

            } else if (btnExit == Button) { System.exit(0);}

        }

    }
}
