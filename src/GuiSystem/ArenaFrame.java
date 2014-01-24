package GuiSystem;

import NetworkSystem.NetworkManager;
import Othello.OthelloFrame;
import TicTacToe.TicTacToeFrame;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ArenaFrame extends JFrame {   
    private NetworkManager networkManager = new NetworkManager();
    private Map<String, GameFrame> games = new LinkedHashMap();
    private JPanel gameDescriptions = new JPanel(new CardLayout());
    
    public ArenaFrame() {       
        OthelloFrame othello = new OthelloFrame(this, networkManager);
        TicTacToeFrame tictactoe = new TicTacToeFrame(this, networkManager);
        
        games.put(othello.getGameName(), othello);
        games.put(tictactoe.getGameName(), tictactoe);
        
        ArenaLogo logo = new ArenaLogo();
        GameList gameList = new GameList(getGameNames(), gameDescriptions);
        
        add(logo, BorderLayout.NORTH);
        add(gameList, BorderLayout.CENTER);
        
        for(GameFrame game : games.values())
            gameDescriptions.add(new GameDescription(game.getGameLogoFilename(), game.getGameDescriptionFilename()), game.getGameName());
                     
        add(gameDescriptions, BorderLayout.EAST);

        pack();
    }
    
    private List<String> getGameNames() {
        List<String> gameNames = new ArrayList();
        
        for(String gameName : games.keySet())
            gameNames.add(gameName);
        
        return gameNames;
    }
}
