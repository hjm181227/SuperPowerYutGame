import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image img;
    public ImagePanel(String img, int width, int height, int x, int y) {
        this(new ImageIcon(img).getImage(), width, height, x, y);
    }

    public ImagePanel(Image img, int width, int height, int x, int y) {
        this.img = img;
        setBounds(x,y,width,height);
    }//constructor

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
    public void setImg(Image img){this.img = img;}

}
