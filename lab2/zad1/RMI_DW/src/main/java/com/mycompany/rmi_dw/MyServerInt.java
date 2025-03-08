package com.mycompany.rmi_dw;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface MyServerInt extends Remote{

    List<Produkt> listaProduktow() throws RemoteException;
    Produkt znajdzProdukt(String nazwa) throws RemoteException;

}