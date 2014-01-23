package GuiSystem;

import NetworkSystem.NetworkManager;
import javax.swing.JFrame;

public class ArenaFrame extends JFrame {   
    private NetworkManager networkManager = new NetworkManager();
    
    public ArenaFrame() {       
        
        ArenaLogo logo = new ArenaLogo();
        
        add(logo);
                
        pack();
    }

}
