package com.mycompany.rmi_dw;
import com.mycompany.rmi_dw_client.MyClientInt;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface MyServerInt extends Remote{

    void registerClient(MyClientInt client) throws RemoteException;
    void sendMessage(String message, MyClientInt sender) throws RemoteException;

}