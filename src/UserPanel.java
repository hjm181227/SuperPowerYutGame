import javax.swing.*;
import java.awt.*;

public class UserPanel extends JPanel{

    public JButton btnAbility1, btnAbility2;

    public UserPanel(Player user){

        setBackground(Color.white);
        setLayout(null);

        add(user.imgPlayer);

        btnAbility1 = new JButton(user.abilities[0].abilityName);
        btnAbility1.setBounds(0,350,100,50);
        btnAbility1.setLayout(null);
        add(btnAbility1);

        btnAbility2 = new JButton(user.abilities[1].abilityName);
        btnAbility2.setBounds(100,350,100,50);
        btnAbility2.setLayout(null);
        add(btnAbility2);

        add(user.lblTurn);
    }//constructor

}
