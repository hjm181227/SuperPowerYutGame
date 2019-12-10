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
        btnAbility1.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnAbility1.setBorderPainted(false);  //외곽선
        btnAbility1.setFocusPainted(false);  //선택시 테두리 사용x
        btnAbility1.setBackground(new Color(225,213,191));
        add(btnAbility1);

        btnAbility2 = new JButton(user.abilities[1].abilityName);
        btnAbility2.setBounds(100,350,100,50);
        btnAbility2.setLayout(null);
        btnAbility2.setFont(new Font("OCR A Extended", Font.BOLD, 15));
        btnAbility2.setBorderPainted(false);  //외곽선
        btnAbility2.setFocusPainted(false);  //선택시 테두리 사용x
        btnAbility2.setBackground(new Color(225,213,191));
        add(btnAbility2);

        add(user.lblTurn);
    }//constructor

}
