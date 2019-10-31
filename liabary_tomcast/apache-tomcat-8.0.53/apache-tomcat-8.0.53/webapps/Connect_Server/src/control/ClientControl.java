package control;
import java.io.ObjectInputStream;
import model.Student;

import java.io.ObjectOutputStream;
import java.net.Socket;
public class ClientControl {
    private String serverHost = "192.168.0.100";
    private int serverPort = 9999;
    public void listen(){
        try{
            Socket mySocket = new Socket(serverHost, serverPort);
            ObjectOutputStream oos = new
            ObjectOutputStream(mySocket.getOutputStream());
            
            Student st=new Student("B15DCCN446", "Hoang Xuan Quyet", "192.168.0.108", "ahihi");
            oos.writeObject(st);
            
            ObjectInputStream ois = new
            ObjectInputStream(mySocket.getInputStream());
            
            try{
                while(true){
                Object o = ois.readObject();
            }
            }
            catch(Exception ex){
                mySocket.close();
            }
        } catch (Exception ex) {
            System.out.println(ex.getStackTrace().toString());
        }

}
    }
   
    
