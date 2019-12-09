import javax.swing.*;
import java.awt.*;

public class InGameView extends JPanel {

    public UserPanel leftUserPanel, rightUserPanel;
    private JLabel          gameBoard;
    private JButton         btnThrow1, btnThrow2;
    public Yut              lblThrowing;
    private InGameData      _gameData;
    public JLabel          lblYutResult;

    public JButton         leftThrowBtn, rightThrowBtn;

    public InGameView(){

        GameManager.getInstance().set_inGame(this);
        _gameData = GameManager.getInstance().get_gameData();


        setBounds(0,0,1000, 800);
        setBackground(Color.white);
        setLayout(null);

        for(Pawn p:_gameData.leftPlayer.pawns) {
            this.add(p);

        }
        for(Pawn p:_gameData.rightPlayer.pawns) {
            this.add(p);
        }

        leftUserPanel = new UserPanel(_gameData.leftPlayer);
        leftUserPanel.setBounds(0,0,200,600);
        leftUserPanel.setVisible(true);
        add(leftUserPanel);

        rightUserPanel = new UserPanel(_gameData.rightPlayer);
        rightUserPanel.setBounds(800,0,200,600);
        add(rightUserPanel);

        gameBoard = new JLabel();
        gameBoard.setIcon(new ImageIcon("images/boardImage.png"));
        gameBoard.setBounds(200,0,600,600);
        //BoardPanel.setLayout(null);
        add(gameBoard);

        leftThrowBtn = new JButton("윷 던지기");
        leftThrowBtn.setBounds(0,599, 200,200);
        leftThrowBtn.setLayout(null);
        add(leftThrowBtn);

        rightThrowBtn = new JButton("윷 던지기");
        rightThrowBtn.setBounds(800,599,200,200);
        rightThrowBtn.setLayout(null);
        add(rightThrowBtn);

        lblThrowing = new Yut();
        lblThrowing.setBounds(210,600,400,200);
        lblThrowing.setVisible(true);
        add(lblThrowing);

        lblYutResult= new JLabel();
        lblYutResult.setBounds(650,650,100,100);
        add(lblYutResult);


        _gameData.previewMovedPawn = new Pawn();
        _gameData.previewMovedPawn.setEnabled(false);
        _gameData.previewMovedPawn.setVisible(false);

        add(_gameData.previewMovedPawn);
        setComponentZOrder(_gameData.previewMovedPawn, 0);
        repaint();

    }//constructor




}//YutGamePanel()
