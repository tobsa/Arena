package GameSystem;

import NetworkSystem.NetworkManager;
import NetworkSystem.NetworkReadPlayer;
import NetworkSystem.NetworkSendPlayer;
import SharedSystem.BlockQueue;
import SharedSystem.IGGListener;
import SharedSystem.IGMListener;
import SharedSystem.SharedConstants;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class GameManager implements Runnable, SharedConstants {
    private GameGrid gameGrid;
    private Player player1;
    private Player player2;
    private List<IGMListener> listeners = new ArrayList();
    private NetworkManager networkManager;
    
    public GameManager(GameGrid gameGrid, NetworkManager networkManager) {
        this.gameGrid = gameGrid;
        this.networkManager = networkManager;
    }
    
    public abstract void createPlayer1(int type, String name);
    public abstract void createPlayer2(int type, String name);
    
    public void createPlayer1(Player player) {
        player1 = player;
    }
    
    public void createPlayer2(Player player) {
        player2 = player;
    }
    
    public void createNetworkPlayer1(int type, String name) {
        switch(type) {
            case NETWORK_PLAYER_READ:
                player1 = new NetworkReadPlayer(PLAYER_1, name, networkManager);
                break;
            case NETWORK_PLAYER_SEND:
                player2 = new NetworkSendPlayer(PLAYER_2, name, networkManager);
                break;
        }
    }
    
    public void createNetworkPlayer2(int type, String name) {
        switch(type) {
            case NETWORK_PLAYER_READ:
                player2 = new NetworkReadPlayer(PLAYER_2, name, networkManager);
                break;
            case NETWORK_PLAYER_SEND:
                player2 = new NetworkSendPlayer(PLAYER_2, name, networkManager);
                break;
        }
    }
    
    public void registerIGMListener(IGMListener listener) {
        listeners.add(listener);
    }
    
    public void registerIGGListener(IGGListener listener) {
        gameGrid.registerListener(listener);
    }
    
    public void unregisterIGMListener(IGMListener listener) {
        listeners.remove(listener);
    }
    
    public void unregisterIGGListener(IGGListener listener) {
        gameGrid.unregisterListener(listener);
    }
    
    public void unregisterIGMListeners() {
        listeners.clear();
    }
    
    public void unregisterIGGListeners() {
        gameGrid.unregisterAllListeners();
    }
    
    public void clearGameGrid() {
        gameGrid.clear();
    }
    
    public void closeConnection() {
        networkManager.closeConnection();
    }
    
    private boolean makeMove(Player player) throws InterruptedException, IOException, ClassNotFoundException {                
        while(true) {        
            BlockQueue.getInstance().clear();
            
            int action = gameGrid.makeMove(player.computeMove());

            if(action == Move.PASS)
                return false;
            if(action == Move.INVALID)
                continue;
            
            GameResult result = gameGrid.getResult();
            
            result.setNames(player1.getName(), player2.getName());
            
            for(IGMListener listener : listeners) 
                listener.updateResult(result);
                        
            if(result.getResult() == GameResult.NO_OUTCOME)
                return false;
            
            return true;
        }
    }

    @Override
    public void run() {
        while(true) {
            try {
                if(makeMove(player1))
                    break;
                if(makeMove(player2))
                    break;
            } catch(InterruptedException ex) {
                break;
            } catch (IOException ex) {
                for(IGMListener listener : listeners)
                    listener.updateLostConnection();
                break;
            } catch (ClassNotFoundException ex) {
                System.out.println(ex);
                break;
            }
        }
    }
}
