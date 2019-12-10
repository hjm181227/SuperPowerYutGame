public abstract class Ability {
    private boolean isUsed;
    public InGameData _data = GameManager.getInstance().get_gameData();
    public InGameView _view = GameManager.getInstance().get_inGame();

    public void run()
    {
        if(!isUsed) {
            use();
            isUsed = true;
        }
        return;
    }
    public Ability(){
        isUsed = false;
    }//constructor


    public abstract void use();
    public boolean isUsed(){ return isUsed; }
    public void setUsed(boolean b){isUsed = b;}


}

