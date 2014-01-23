package GuiSystem;

import GameSystem.GameManager;
import SharedSystem.IGMListener;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public abstract class GameFrame extends JFrame implements IGMListener {
    private GameManager gameManager;
    private GameBoard gameBoard;
    private Thread gameThread;
    private GameMenu gameMenu;
    private String name;
    private JFrame parent;
    
    public GameFrame(JFrame parent, String name, GameManager gameManager, GameBoard gameBoard) {
        setLayout(new BorderLayout());
        this.parent = parent;
        this.name = name;
        this.gameManager = gameManager;
        this.gameBoard = gameBoard;
        gameThread = new Thread(gameManager);
        gameMenu = new GameMenu(parent, this);
        
        JPanel gameMenuPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        gameMenuPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 5, 10), new EtchedBorder()));
        gameMenuPanel.add(gameMenu);
        
        JPanel gameBoardPanel = new JPanel();
        gameBoardPanel.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(5, 10, 10, 10), new EtchedBorder()));
        gameBoardPanel.add(gameBoard);
        
        add(gameMenuPanel,  BorderLayout.NORTH);
        add(gameBoardPanel, BorderLayout.CENTER);
        
        pack();
        
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
        
        addWindowListener(new GameFrameListener());
    }
    
    public String getGameName() {
        return name;
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
    
    private class GameFrameListener extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            parent.setVisible(true);
        }
    }
}
