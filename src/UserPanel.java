import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel{
    public JButton btnAbility1, btnAbility2;

    public UserPanel(Player user){

        setBackground(Color.darkGray);

        btnAbility1 = new JButton("btn1");
        btnAbility1.setBounds(0,300,100,50);
        btnAbility1.setLayout(null);
        add(btnAbility1);

        btnAbility2 = new JButton("btn2");
        btnAbility2.setBounds(100,300,100,50);
        btnAbility2.setLayout(null);
        add(btnAbility2);
    }//constructor

}
