package com.mycompany.rmi_dw;
import com.mycompany.rmi_dw_client.MyClientInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
  private static final long serialVersionUID = 1L;
  private final List<MyClientInt> clients;

public MyServerImpl() throws RemoteException {
super();
  clients = new ArrayList<>();
}

  @Override
  public synchronized void registerClient(MyClientInt client) throws RemoteException {
    clients.add(client);
    System.out.println(client.getName() + " joined the chat.");
  }

  @Override
  public synchronized void sendMessage(String message, MyClientInt sender) throws RemoteException {
    String formattedMessage = "[" + sender.getName() + "]: " + message;
    System.out.println(formattedMessage);
    for (MyClientInt client : clients) {
      if (!client.equals(sender)) {
        client.receiveMessage(formattedMessage);
      }
    }
  }


}
