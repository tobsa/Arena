package GuiSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class GameDescription extends JPanel {    
    
    public GameDescription(String logoFilename, String backgroundFilename) {      
        setLayout(new BorderLayout());
  
        JLabel logo       = new JLabel(new ImageIcon(logoFilename));
        JLabel background = new JLabel(new ImageIcon(backgroundFilename));

        JPanel logoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        logoPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        logoPanel.add(logo);
        
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        buttonPanel.add(new JButton("Launch"));
        buttonPanel.add(new JButton("Options"));
        
        JPanel backgroundPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        backgroundPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        backgroundPanel.add(background);
        
        JPanel logoButtonPanel = new JPanel(new BorderLayout());
        logoButtonPanel.add(logoPanel, BorderLayout.NORTH);
        logoButtonPanel.add(buttonPanel, BorderLayout.CENTER);
                        
        add(logoButtonPanel, BorderLayout.NORTH);
        add(backgroundPanel, BorderLayout.CENTER);
        
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(0, 5, 10, 10), new EtchedBorder()));
    }
}
