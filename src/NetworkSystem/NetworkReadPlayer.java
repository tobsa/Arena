package NetworkSystem;

import GameSystem.Move;
import java.io.IOException;

public class NetworkReadPlayer extends NetworkPlayer {
    
    public NetworkReadPlayer(int id, String name, NetworkManager manager) {
        super(id, name, manager);
    }

    @Override
    public Move computeMove() throws InterruptedException, IOException, ClassNotFoundException {
        return manager.readMove();
    }
}
