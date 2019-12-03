public class Ability {

    private InGameData _gameData;

    public Ability() {
        _gameData = GameManager.getInstance().get_gameData();
    }//constructor

    public void RandomIndex() {

    }

    public int MoOrDo() {
        return 3;
    }

    public int GaeOrGirl() {
        return 5;
    }

}

