import javax.swing.JFrame;
import java.awt.*;

public class YutGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Yut Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        MenuPanel Primary = new MenuPanel();
        YutGamePanel primary = new YutGamePanel();
        frame.getContentPane().add(Primary);

        frame.pack();
        frame.setVisible(true);
    }
}
