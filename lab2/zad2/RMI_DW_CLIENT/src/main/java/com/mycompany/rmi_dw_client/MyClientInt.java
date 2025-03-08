package com.mycompany.rmi_dw_client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyClientInt extends Remote {

    void receiveMessage(String message) throws RemoteException;
    String getName() throws RemoteException;
}
