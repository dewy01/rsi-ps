package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyClientImpl extends UnicastRemoteObject implements MyClientInt{
    private static final long serialVersionUID = 1L;
    private final String name;
    private final char symbol;

    protected MyClientImpl(String name, char symbol) throws RemoteException {
        super();
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }

    @Override
    public char getSymbol() throws RemoteException {
        return symbol;
    }

    @Override
    public void otrzymajWiadomosc(String message) throws RemoteException {
        System.out.println(message);
    }

}
