package TicTacToe;

import GameSystem.GameGrid;
import GameSystem.Human;
import NetworkSystem.NetworkManager;

public class TicTacToeManager extends GameSystem.GameManager {
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
