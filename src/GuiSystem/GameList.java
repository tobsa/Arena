package GuiSystem;

import SharedSystem.SharedConstants;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class GameList extends JPanel implements SharedConstants {
    private JList<String> gameList = new JList();
    private JPanel gameDescriptions;
    
    public GameList(List<String> names, JPanel gameDescriptions) {
        setLayout(new BorderLayout());
        
        this.gameDescriptions = gameDescriptions;
        
        gameList.addListSelectionListener(new GameListSelectionListener());
        
        DefaultListModel model = new DefaultListModel();
        
        for(String name : names)
            model.addElement(name);
        gameList.setModel(model);
        
        gameList.setSelectedIndex(0);
        
        JScrollPane scroll = new JScrollPane(gameList);      
        
        JLabel gamesLabel = new JLabel(new ImageIcon(GAMES_LOGO_FILENAME));
        JPanel gamesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        gamesPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        gamesPanel.add(gamesLabel);
        
        JPanel scrollPanel = new JPanel(new BorderLayout());
        scrollPanel.setBorder(new EmptyBorder(0, 20, 0, 20));
        scrollPanel.add(scroll);
        
        add(gamesPanel,  BorderLayout.NORTH);
        add(scrollPanel, BorderLayout.CENTER);
        
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 10, 10, 5), new EtchedBorder()));
                
    }
    
    private class GameListSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {            
            String name = gameList.getSelectedValue();
            if(name == null || !e.getValueIsAdjusting())
                return;
            
            CardLayout layout = (CardLayout)gameDescriptions.getLayout();
            layout.show(gameDescriptions, name);
        }
    }
}
