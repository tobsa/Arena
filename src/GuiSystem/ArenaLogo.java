package GuiSystem;

import SharedSystem.SharedConstants;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

public class ArenaLogo extends JPanel implements SharedConstants {    
    public ArenaLogo() {
        setLayout(new BorderLayout());                
        
        JLabel label = new JLabel(new ImageIcon(ARENA_LOGO_FILENAME));
        
        add(label, BorderLayout.CENTER);
                
        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 5, 10), BorderFactory.createCompoundBorder(
                new EtchedBorder(), new EmptyBorder(5, 5, 5, 5))));
    }
}
