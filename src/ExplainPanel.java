import javax.swing.*;
import java.awt.*;


//게임 방법을 누르면 나오는 패널
public class ExplainPanel extends JPanel {

    public JLabel lblTitle;

    public JButton btnPrev, btnNext;

    public ImageIcon[] explains;

    public int     imageIndex;

    public ExplainPanel(){
        GameManager.getInstance().set_explain(this);

        setBounds(0,0,1000,800);

        setBackground(Color.white);
        setLayout(null);

        //게임 방법 타이틀
        lblTitle = new JLabel("게임 설명 !");
        lblTitle.setBounds(320,100,600,100);
        lblTitle.setFont(new Font("Vernada",Font.BOLD,80));
        lblTitle.setVisible(true);
        add(lblTitle);

        //이전 페이지로 넘어가게 하는 버튼
        btnPrev = new JButton("이전 페이지");
        btnPrev.setBounds(50,720,220,50);
        btnPrev.setFont(new Font("Vernada",Font.BOLD,30));
        btnPrev.setVisible(true);
        add(btnPrev);

        //다음 페이지로 넘어가게 하는 버튼
        btnNext = new JButton("다음 페이지");
        btnNext.setBounds(730,720,220,50);
        btnNext.setFont(new Font("Vernada",Font.BOLD,30));
        btnNext.setVisible(true);
        add(btnNext);

        explains = new ImageIcon[3];
        for(int i=0;i<3;i++) explains[i] = new ImageIcon();

    }//constructor

    /*public void paintComponent(Graphics page){

        super.paintComponent(page);


    }//paintComponent()*/

}//YutGamePanel()
