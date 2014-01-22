package NetworkSystem;

import GameSystem.Move;
import SharedSystem.BlockQueue;
import java.io.IOException;

public class NetworkSendPlayer extends NetworkPlayer {
    
    public NetworkSendPlayer(int id, String name, NetworkManager manager) {
        super(id, name, manager);
    }

    @Override
    public Move computeMove() throws InterruptedException, IOException {
        Move move = BlockQueue.getInstance().take();
        manager.sendMove(move);
        return move;
    }
}
