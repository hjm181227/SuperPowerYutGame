//import jdk.tools.jlink.internal.Jlink;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;

public class Yut extends JLabel implements Runnable{

    Thread  myThread;
    int nSleepTime, nResult;
//    String[] strYut = new String[6];
    public String[] iconImageName = new String[6];
    public ImageIcon[]    iconYut;

    private InGameView _view;
    private InGameData _data;

    public Yut(){
        super();

        _view = GameManager.getInstance().get_inGame();
        _data = GameManager.getInstance().get_gameData();

        iconImageName[0] = "images/Do.png";
        iconImageName[1] = "images/Gae.png";
        iconImageName[2] = "images/Girl.png";
        iconImageName[3] = "images/Yut.png";
        iconImageName[4] = "images/Mo.png";
        iconImageName[5] = "images/Bdo.png";

        iconYut= new ImageIcon[6];
        for( int i=0; i<6; i++)
            iconYut[i] = new ImageIcon(iconImageName[i]);

        nSleepTime = 100;
        setIcon(iconYut[0]);
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

    public void setResult(int arg)  { nResult= arg;}
    public int getResult()          {return nResult;}

    public void setResultYutImg(int result){
        setIcon(iconYut[result-1]);
    }

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
            setIcon(new ImageIcon(iconImageName[i]));
            try { myThread.sleep(nSleepTime); }
            catch (Exception e) { }
        }

        setIcon(new ImageIcon(iconImageName[nResult-1]));
        _view.lblYutResult.setIcon(_data.iconYutText[_data.throwResult-1]);


    }//run()


    public void Yut_init(){


    }

}//LabelThread Class