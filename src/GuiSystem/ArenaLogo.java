package GuiSystem;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ArenaLogo extends JPanel {
    private JLabel label = new JLabel("Arena Board Games");
    
    public ArenaLogo() {
        
        label.setFont(new Font("Arial", Font.PLAIN, 48));
        label.setForeground(Color.DARK_GRAY);
                
        add(label);
        
        Border border1 = new EmptyBorder(10, 10, 10 ,10);
        Border border2 = new EtchedBorder();
        Border border3 = new EmptyBorder(10, 250, 10, 250);
        
        setBorder(BorderFactory.createCompoundBorder(border1, BorderFactory.createCompoundBorder(border2, border3)));
    }
}
