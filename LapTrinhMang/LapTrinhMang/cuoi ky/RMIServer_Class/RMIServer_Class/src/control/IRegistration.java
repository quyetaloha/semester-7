/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.rmi.Remote;
import java.rmi.RemoteException;
import model.Answer;
import model.Student;

/**
 *
 * @author ntkhanh
 */
public interface IRegistration extends Remote{
    public Student register(Student s) throws RemoteException;
    public Answer answer(Answer answer) throws RemoteException;
    public int layport1(Student s) throws RemoteException;
    public int layport2(Student s) throws RemoteException;
}
