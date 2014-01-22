package GameSystem;

import java.util.LinkedHashMap;
import java.util.Map;

public class PlayerRegister {
    private Map<Integer, Player> players = new LinkedHashMap();
    
    public void registerPlayer(Player player) {
        players.put(player.getID(), player);
    }
}
