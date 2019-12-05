//import jdk.tools.jlink.internal.Jlink;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;

public class Yut extends JLabel implements Runnable{

    Thread  myThread;
    int nSleepTime;
    public JLabel[] lblYut = new JLabel[2];
    public String[] ImageName = new String[6];
    public JLabel A;

    public ImageIcon[]    iconYut;

    public Yut(){
        super();
        ImageName[0] = "images/Do.png";
        ImageName[1] = "images/Gae.png";
        ImageName[2] = "images/Girl.png";
        ImageName[3] = "images/Yut.png";
        ImageName[4] = "images/Mo.png";
        ImageName[5] = "images/Bdo.png";

        iconYut= new ImageIcon[6];
        for( int i=0; i<6; i++)
            iconYut[i] = new ImageIcon(ImageName[i]);

        nSleepTime = 100;
//        setIcon(new ImageIcon(ImageName[0]));
        setIcon(iconYut[5]);


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
            setIcon(new ImageIcon(ImageName[i]));
            try { myThread.sleep(nSleepTime); }
            catch (Exception e) { }
        }
      //  setIcon(new ImageIcon(ImageName[2]));

    }//run()

    public void setResultYutImg(int result){
        setIcon(iconYut[result]);
        System.out.println(result-1);
    }


}//LabelThread Class