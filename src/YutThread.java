import javax.swing.JLabel;

public class YutThread extends JLabel implements Runnable{

    Thread  myThread;
    int     nFinish;
    int     nSleepTime;

    public YutThread(){
        super();
        nFinish = 6;
    }
    public YutThread(String arg){
        super(arg);
        initInstanceDatas();
    }

    private void initInstanceDatas(){
        myThread = null;
        nFinish = 0;
        nSleepTime = 50;
    }

    public void setFinish(int arg)      { nFinish = arg; }
    public void setSleepTime(int arg)   { nSleepTime = arg; }
    public int getFinish()              { return nFinish; }
    public int getSleepTime()           { return nSleepTime; }

    public void start(){
        if(myThread == null) myThread = new Thread(this);
        myThread.start();
    }

    public void stop(){
        if(myThread != null) myThread.stop();
    }

    @Override
    public void run(){
        for(int i=1;i<=nFinish;i++) {
            setText(Integer.toString(i));
            try { myThread.sleep(nSleepTime); }
            catch (Exception e) { }
        }
        for(int i=0;i<10;i++){
            setVisible(false);
            try{myThread.sleep(nSleepTime);}
            catch(Exception e){}
            setVisible(true);
            try{ myThread.sleep(nSleepTime);}
            catch(Exception e){}
        }//for
    }//run()
}//LabelThread Class