package com.mycompany.rmi_dw_client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

    String getDescription(String text) throws RemoteException;
    float Add(float x, float y) throws RemoteException;
    float Sub(float x, float y) throws RemoteException;
    float Mult(float x, float y) throws RemoteException;
    float Div(float x, float y) throws RemoteException;
}
