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
        imageIndex=0;

        explains = new ImageIcon[3];
        for(int i=0;i<3;i++)
            explains[i] = new ImageIcon("images/rule"+(i+1)+".png");

        //게임 방법 타이틀
        lblTitle = new JLabel();
        lblTitle.setBounds(0,100,1000,562);
        lblTitle.setIcon(explains[imageIndex]);
        lblTitle.setVisible(true);
        add(lblTitle);

        //이전 페이지로 넘어가게 하는 버튼
        btnPrev = new JButton("메뉴로");
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


    }//constructor

    /*public void paintComponent(Graphics page){

        super.paintComponent(page);


    }//paintComponent()*/

}//YutGamePanel()
