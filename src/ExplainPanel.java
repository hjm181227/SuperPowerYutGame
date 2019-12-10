import javax.swing.*;
import java.awt.*;


//게임 방법을 누르면 나오는 패널
public class ExplainPanel extends JPanel {

    public JLabel lblTitle;
    public JButton btnPrev, btnNext;
    public ImageIcon[] explains;
    public int     imageIndex;

    public btnMouseEvent btnlistener;


    public ExplainPanel(){
        GameManager.getInstance().set_explain(this);
        btnlistener = new btnMouseEvent();

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
        btnPrev = new JButton("Menu");
        btnPrev.setBounds(50,720,220,50);
        btnPrev.setFont(new Font("OCR A Extended",Font.BOLD,30));
        btnPrev.addMouseListener(btnlistener);
        GameManager.getInstance().setBtnInit(btnPrev);
        add(btnPrev);

        //다음 페이지로 넘어가게 하는 버튼
        btnNext = new JButton("Next Page");
        btnNext.setBounds(730,720,220,50);
        btnNext.setFont(new Font("OCR A Extended",Font.BOLD,30));
        btnNext.addMouseListener(btnlistener);
        GameManager.getInstance().setBtnInit(btnNext);
        add(btnNext);


    }//constructor

    /*public void paintComponent(Graphics page){

        super.paintComponent(page);


    }//paintComponent()*/

}//YutGamePanel()
