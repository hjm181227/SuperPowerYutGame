import javax.swing.JFrame;
import java.awt.*;

public class YutGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Yut Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,800));
        frame.setResizable(false);

        MainPanel Primary = new MainPanel();
        frame.getContentPane().add(Primary);

        frame.pack();
        frame.setVisible(true);
    }
}
