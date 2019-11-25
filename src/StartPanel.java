import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//게임시작을 누르면 맨 처음 나오는 패널이다
public class StartPanel extends JPanel {

    private JLabel lblTitle, lblLeft, lblRight;
    private ImagePanel      BoardPanel, YutPanelView;
    private JButton btnStart, btnExit;



    public StartPanel(){
        setPreferredSize(new Dimension(1000, 800));
        setBackground(Color.white);
        setLayout(null);

        //설명 라벨
        lblTitle = new JLabel("카트를 선택하세요!");
        lblTitle.setBounds(220,150,600,150);
        lblTitle.setFont(new Font("Vernada",Font.BOLD,80));
        lblTitle.setVisible(true);
        add(lblTitle);

        //선공 후공을 정하는 라벨 중 하나
        lblLeft = new JLabel("왼쪽 라벨");
        lblLeft.setBounds(150,300,400,100);
        lblLeft.setBackground(Color.BLUE);
        lblLeft.setOpaque(true);//라벨의 배경색색칠을 허용해줌
        lblLeft.setFont(new Font("Vernada",Font.BOLD,60));
        lblLeft.setVisible(true);
        add(lblLeft);

        //선공 후공을 정하는 라벨 중 하나
        lblRight = new JLabel("오른쪽 라벨");
        lblRight.setBounds(550,300,400,100);
        lblRight.setForeground(Color.RED);
        lblRight.setFont(new Font("Vernada",Font.BOLD,60));
        lblRight.setVisible(true);
        add(lblRight);

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
