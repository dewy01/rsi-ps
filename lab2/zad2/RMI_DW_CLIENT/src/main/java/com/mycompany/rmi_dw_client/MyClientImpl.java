package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyClientImpl extends UnicastRemoteObject implements MyClientInt{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final MyServerInt server;

    protected MyClientImpl(String name, MyServerInt server) throws RemoteException {
        super();
        this.name = name;
        this.server = server;
        server.registerClient(this);
    }

    @Override
    public void receiveMessage(String message) throws RemoteException {
        System.out.println(message);
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    public void sendMessage(String message) throws RemoteException {
        server.sendMessage(message, this);
    }
}
