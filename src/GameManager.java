
public class GameManager {

    private static GameManager s_instance;
    private MainPanel _view;
    private InGameView _inGame;
    private ExplainPanel _explain;
    private MenuPanel _menu;
    private InGameData _gameData;
    private GameManager(){

    }//constructor

    public MainPanel get_view(){return _view;}
    public InGameView get_inGame(){return _inGame;}
    public ExplainPanel get_explain(){return _explain;}
    public MenuPanel get_menu(){return _menu;}
    public InGameData get_gameData(){return _gameData;}

    public void set_view(MainPanel view){this._view = view;}
    public void set_inGame(InGameView inGame){this._inGame = inGame;}
    public void set_explain(ExplainPanel explain){this._explain = explain;}
    public void set_menu(MenuPanel menu){this._menu = menu;}
    public void set_gameData(InGameData data){this._gameData = data;}

    public static GameManager getInstance(){
        if(s_instance == null) s_instance = new GameManager();
        return s_instance;
    }
}
