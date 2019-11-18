import javax.swing.JFrame;

public class YutGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Yut Game");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        YutGamePanel primary = new YutGamePanel();
        frame.getContentPane().add(primary);

        frame.pack();
        frame.setVisible(true);
    }
}
