package com.mycompany.rmi_dw;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
  private final List<Produkt> produkty;

protected MyServerImpl() throws RemoteException {
super();
  produkty = new ArrayList<>();
  produkty.add(new Produkt("Laptop", 3500.99));
  produkty.add(new Produkt("Telefon", 2000.49));
  produkty.add(new Produkt("Tablet", 1200.00));
}

  @Override
  public List<Produkt> listaProduktow() throws RemoteException {
    return produkty;
  }

  @Override
  public Produkt znajdzProdukt(String nazwa) throws RemoteException {
    return produkty.stream().filter(p -> p.getNazwa().equalsIgnoreCase(nazwa)).findFirst().orElse(null);
  }


}
