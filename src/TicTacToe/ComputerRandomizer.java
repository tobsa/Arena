package TicTacToe;

import GameSystem.Move;
import GameSystem.Player;
import java.io.IOException;
import java.util.Random;

public class ComputerRandomizer extends Player {

    public ComputerRandomizer(int id, String name) {
        super(id, name);
    }
    
    @Override
    public Move computeMove() throws InterruptedException, IOException {
        Random random = new Random();
        int x = random.nextInt(3);
        int y = random.nextInt(3);
        
        return new Move(x, y, getID());
    }
    
}
