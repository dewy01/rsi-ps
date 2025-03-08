package com.mycompany.rmi_dw_client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyClientInt extends Remote {

    String getName() throws RemoteException;
    char getSymbol() throws RemoteException;
    void otrzymajWiadomosc(String message) throws RemoteException;
}
