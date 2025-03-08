package com.mycompany.rmi_dw;
import com.mycompany.rmi_dw_client.MyClientInt;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyServerInt extends Remote{

    boolean dolaczDoGry(MyClientInt klient) throws RemoteException;
    boolean wykonajRuch(int x, int y, MyClientInt klient) throws RemoteException;
    char[][] pobierzPlansze() throws RemoteException;
    boolean czyKoniecGry() throws RemoteException;
    MyClientInt pobierzZwyciezce() throws RemoteException;
    String czyjRuch() throws RemoteException;
    int ileGraczy() throws RemoteException;

}