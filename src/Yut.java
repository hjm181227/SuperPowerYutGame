import javax.imageio.stream.ImageInputStream;
import javax.swing.*;

public class Yut extends JLabel implements Runnable{

    Thread  myThread;
    int nSleepTime;
    public JLabel[] lblYut = new JLabel[2];
    public String[] ImagName = new String[6];
    public JLabel A;

    public Yut(){
        super();
        ImagName[0] = "images/Do.png"; ImagName[1] = "images/Gae.png";
        ImagName[2] = "images/Girl.png"; ImagName[3] = "images/Yut.png";
        ImagName[4] = "images/Mo.png"; ImagName[5] = "images/Bdo.png";
        nSleepTime = 100;
    }
    public Yut(String arg){
        super(arg);
    }

    private void initInstanceDatas(){



        myThread = null;
        nSleepTime = 1000;
    }

    public void setSleepTime(int arg)   { nSleepTime = arg; }
    public int getSleepTime()           { return nSleepTime; }

    public void start(){
        myThread = new Thread(this);
        myThread.start();
    }

    public void stop(){
        if(myThread != null) myThread.stop();
    }

    @Override
    public void run(){
        for(int i=0;i<6;i++) {
            //setText(Integer.toString(i));
            setIcon(new ImageIcon(ImagName[i]));
            try { myThread.sleep(nSleepTime); }
            catch (Exception e) { }
        }
    }//run()
}//LabelThread Class