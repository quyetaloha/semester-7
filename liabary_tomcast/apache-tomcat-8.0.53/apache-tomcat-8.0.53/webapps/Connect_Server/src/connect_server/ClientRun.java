package connect_server;
import control.ClientControl;
import connect_server.model.ClientView;

public class ClientRun {
public static void main(String[] args) {
    
    ClientControl control = new ClientControl();
    control.listen();
}
    
}
