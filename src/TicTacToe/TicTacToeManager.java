package TicTacToe;

import GameSystem.GameGrid;
import GameSystem.GameManager;
import GameSystem.Human;
import NetworkSystem.NetworkManager;
import SharedSystem.SharedConstants;

public class TicTacToeManager extends GameManager implements SharedConstants {
    public static final int TYPE_HUMAN = 0;
    public static final int TYPE_COMPUTER_RANDOMIZER = 1;
    
    public TicTacToeManager(GameGrid gameGrid, NetworkManager networkManager) {
        super(gameGrid, networkManager);
    }
    
    @Override
    public void createPlayer1(int type, String name) {
        switch(type) {
            case TYPE_HUMAN:
                createPlayer1(new Human(PLAYER_1, name));
                break;
            case TYPE_COMPUTER_RANDOMIZER:
                createPlayer1(new ComputerRandomizer(PLAYER_1, name));
                break;
        }
    }

    @Override
    public void createPlayer2(int type, String name) {
        switch(type) {
            case TYPE_HUMAN:
                createPlayer2(new Human(PLAYER_2, name));
                break;
            case TYPE_COMPUTER_RANDOMIZER:
                createPlayer2(new ComputerRandomizer(PLAYER_2, name));
                break;
        }
    }
}
