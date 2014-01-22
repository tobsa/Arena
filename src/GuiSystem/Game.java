package GuiSystem;

import GameSystem.GameManager;
import SharedSystem.IGMListener;
import javax.swing.JPanel;

public abstract class Game extends JPanel implements IGMListener {
    private GameManager gameManager;
    private GameBoard gameBoard;
    private Thread gameThread;
    
    public Game(GameManager gameManager, GameBoard gameBoard) {
        this.gameManager = gameManager;
        this.gameBoard = gameBoard;
        gameThread = new Thread(gameManager);
        
        add(gameBoard);
    }
    
    public void createPlayer1(int type, String name) {
        gameManager.createPlayer1(type, name);
    }
    
    public void createPlayer2(int type, String name) {
        gameManager.createPlayer2(type, name);
    }
    
    public void createNetworkPlayer1(int type, String name) {
        gameManager.createNetworkPlayer1(type, name);
    }
    
    public void createNetworkPlayer2(int type, String name) {
        gameManager.createNetworkPlayer2(type, name);
    }
    
    public void initializeGame() {
        gameThread.interrupt();
        gameManager.unregisterIGGListeners();
        gameManager.unregisterIGMListeners();
        gameManager.registerIGGListener(gameBoard);
        gameManager.registerIGMListener(this);
        gameManager.clearGameGrid();
        gameManager.closeConnection();
    }
    
    public void executeGame() {
        gameThread = new Thread(gameManager);
        gameThread.start();
    }
}
