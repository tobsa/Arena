package TicTacToe;

import GameSystem.GameResult;
import GuiSystem.GameFrame;
import NetworkSystem.NetworkManager;
import javax.swing.JFrame;

public class TicTacToeFrame extends GameFrame {
    
    public TicTacToeFrame(JFrame parent, NetworkManager networkManager) {
        super(parent, "Tic-Tac-Toe", new TicTacToeManager(new TicTacToeGameGrid(), networkManager), new TicTacToeGameBoard());
    }

    @Override
    public void updateResult(GameResult result) {
        
    }

    @Override
    public void updateLostConnection() {
        
    }
}
