/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;
import view.*;

/**
 *
 * @author ntkhanh
 */
public class ClientThread extends Thread {

    Socket clientSocket;
    Server serverControl;
    ObjectInputStream is;
    ObjectOutputStream os;

    public ClientThread(Socket s, Server serverControl) {
        this.clientSocket = s;
        this.serverControl = serverControl;
    }

    @Override
    public void run() {
       
        try {
            System.out.println("a");
            super.run(); 
            
            is = new ObjectInputStream(clientSocket.getInputStream());
            os = new ObjectOutputStream(clientSocket.getOutputStream());
            System.out.println("b");
            // doc du lieu vao
            Object o = is.readObject();
            System.out.println("c");
            if (o instanceof model.Student) {
                System.out.println("a");
                Student input = (Student) o;
                if (clientSocket.getInetAddress().getHostAddress() == null
                        || clientSocket.getInetAddress() == null
                        || clientSocket == null) {
                    input.setIP("NaN");
                } else {
                    input.setIP(clientSocket.getInetAddress().getHostAddress());
                }

                this.serverControl.addStudent(input);

                is.close();
                os.close();
                this.clientSocket.close();
                
            } else {
                System.out.println("O is not a instance of Student" + o.getClass());
                is.close();
                os.close();
                this.clientSocket.close();
            }
        } catch (SocketException so) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            so.printStackTrace();
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException e) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            e.printStackTrace();
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ClassNotFoundException e1) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            e1.printStackTrace();
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (Exception e2) {
            System.out.println(" ------- Loi client ------- ");
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            e2.printStackTrace();
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        } finally {
            System.out.println("Client IP : " + clientSocket.getInetAddress().getHostAddress());
            if (is != null && os != null) {
                try {
                    is.close();
                    os.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
