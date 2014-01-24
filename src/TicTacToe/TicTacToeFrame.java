package TicTacToe;

import GameSystem.GameResult;
import GuiSystem.GameFrame;
import NetworkSystem.NetworkManager;
import javax.swing.JFrame;

public class TicTacToeFrame extends GameFrame {
    
    public TicTacToeFrame(JFrame parent, NetworkManager networkManager) {
        super(parent, TIC_TAC_TOE_NAME, 
                TIC_TAC_TOE_LOGO_FILENAME, 
                TIC_TAC_TOE_BACKGROUND_FILENAME, 
                new TicTacToeManager(new TicTacToeGameGrid(), networkManager), 
                new TicTacToeGameBoard());
    }

    @Override
    public void updateResult(GameResult result) {
        
    }

    @Override
    public void updateLostConnection() {
        
    }
}
