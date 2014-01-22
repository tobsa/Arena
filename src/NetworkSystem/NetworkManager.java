package NetworkSystem;

import GameSystem.Move;
import SharedSystem.SharedConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkManager implements SharedConstants {
    public static final int NETWORK_CREATE_SERVER = 0;
    public static final int NETWORK_ABORT_SERVER = 1;
    
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private String serverName;
    private String clientName;
    
    public int createServer(String name, int port) {        
        try {
            closeConnection();
                        
            serverSocket = new ServerSocket(port);
            socket = serverSocket.accept();
                
            input = new ObjectInputStream(socket.getInputStream());
            output = new ObjectOutputStream(socket.getOutputStream());
            
            output.writeUTF(name);
            
            serverName = name;
            clientName = input.readUTF();
            return NETWORK_CREATE_SERVER;
        } catch (IOException ex) {
            System.out.println("NetworkManager::IOException: " + ex);
            return NETWORK_ABORT_SERVER;
        }
    }
    
    public boolean createClient(String name, String ip, int port) {
        try {
            closeConnection();
            
            socket = new Socket(ip, port);
            
            output = new ObjectOutputStream(socket.getOutputStream());
            input = new ObjectInputStream(socket.getInputStream());
            
            serverName = input.readUTF();
            clientName = name;
            output.writeUTF(name);
            return true;
        } catch (UnknownHostException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }
    }
    
    public void sendMove(Move move) throws IOException {
        output.writeObject(move);
    }
    
    public Move readMove() throws IOException, ClassNotFoundException {
        return (Move)input.readObject();
    }
    
    public String getServerName() {
        return serverName;
    }
    
    public String getClientName() {
        return clientName;
    }
    
    public void closeConnection() {
        try {
            if(socket != null)
                socket.close();
            if(serverSocket != null)
                serverSocket.close();    
            
            serverSocket = null;
            socket = null;
        } catch (IOException ex) {}
    }
    
    public boolean isPortAvailable(int port) {
        ServerSocket s = null;
        try {
            s = new ServerSocket(port);
            return true;
        } catch(IOException ex) {
            return false;
        }
        finally {
            try {
                if(s != null)
                    s.close();
            } catch (IOException ex) {
            }
        }
    }
}
