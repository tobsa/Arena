package TicTacToe;

import GameSystem.GameResult;
import GuiSystem.Game;
import NetworkSystem.NetworkManager;

public class TicTacToe extends Game {
    
    public TicTacToe(NetworkManager networkManager) {
        super(new TicTacToeManager(new GameGrid(), networkManager), new GameBoard());
    }

    @Override
    public void updateResult(GameResult result) {
        
    }

    @Override
    public void updateLostConnection() {
        
    }
}
