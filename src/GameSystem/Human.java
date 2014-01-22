package GameSystem;

import SharedSystem.BlockQueue;
import java.io.IOException;

public class Human extends Player {
    
    public Human(int id, String name) {
        super(id, name);
    }
        
    @Override
    public Move computeMove() throws InterruptedException, IOException {
        Move move = BlockQueue.getInstance().take();
        move.setID(getID());
        return move;
    }
}
