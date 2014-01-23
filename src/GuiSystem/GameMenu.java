package GuiSystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameMenu extends JPanel {
    private JFrame parent;
    private GameFrame game;
    private JButton newGameButton = new JButton("New Game");
    private JButton exitGameButton = new JButton("Exit Game");
    
    public GameMenu(JFrame parent, GameFrame game) {
        this.parent = parent;
        this.game = game;
                                
        newGameButton.addActionListener(new ButtonNewGameListener());
        exitGameButton.addActionListener(new ButtonExitGameListener());
                       
        add(newGameButton);
        add(exitGameButton);
    }
    
    private class ButtonNewGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            game.initializeGame();
            game.createPlayer1(0, "Human");
            game.createPlayer2(1, "Computer");
            game.executeGame();
        }
    }
    
    private class ButtonExitGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            parent.setVisible(true);
            game.dispose();
        }
    }
}
