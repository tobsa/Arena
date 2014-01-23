package Othello;

import GameSystem.GameResult;
import GuiSystem.GameFrame;
import NetworkSystem.NetworkManager;
import javax.swing.JFrame;

public class OthelloFrame extends GameFrame {
    
    public OthelloFrame(JFrame parent, NetworkManager networkManager) {
        super(parent, "Othello", new OthelloManager(new OthelloGameGrid(), networkManager), new OthelloGameBoard());
    }

    @Override
    public void updateResult(GameResult result) {
        
    }

    @Override
    public void updateLostConnection() {
        
    }
}
