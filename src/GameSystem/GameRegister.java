package GameSystem;

import GuiSystem.Game;
import java.util.ArrayList;
import java.util.List;

public class GameRegister {
    private List<Game> games = new ArrayList();
    
    public void registerGame(Game game) {
        games.add(game);
    }
    
    public void unregisterGame(Game game) {
        games.remove(game);
    }
}
