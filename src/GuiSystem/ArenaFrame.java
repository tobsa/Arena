package GuiSystem;

import NetworkSystem.NetworkManager;
import TicTacToe.TicTacToe;
import javax.swing.JFrame;

public class ArenaFrame extends JFrame {   
    private NetworkManager networkManager = new NetworkManager();
    
    public ArenaFrame() {       
        TicTacToe g = new TicTacToe(networkManager);        
        
        add(g);
        
        pack();
        
        g.initializeGame();
        g.createPlayer1(0, "Human");
        g.createPlayer2(1, "Computer");
        g.executeGame();
    }

}
