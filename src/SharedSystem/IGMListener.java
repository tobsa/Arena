package SharedSystem;

import GameSystem.GameResult;

public interface IGMListener {
    public void updateResult(GameResult result);
    public void updateLostConnection();
}
