package com.mycompany.rmi_dw;
import com.mycompany.rmi_dw_client.MyClientInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
  private static final long serialVersionUID = 1L;
  private MyClientInt[] gracze = new MyClientInt[2];
  private char[][] plansza = new char[3][3];
  private int obecnyGracz = 0;

public MyServerImpl() throws RemoteException {
super();
  for (char[] row : plansza) {
    Arrays.fill(row, '-');
  }
}

  @Override
  public synchronized boolean dolaczDoGry(MyClientInt klient) throws RemoteException {
    if (gracze[0] == null) {
      gracze[0] = klient;
      System.out.println("First player joined: " + klient.getName());
      return true;
    } else if (gracze[1] == null) {
      gracze[1] = klient;
      System.out.println("Second player joined: " + klient.getName());
      return true;
    }
    return false;
  }


  @Override
  public synchronized boolean wykonajRuch(int x, int y, MyClientInt klient) throws RemoteException {
    System.out.println("Current player: " + gracze[obecnyGracz].getName());
    System.out.println("Attempting player: " + klient.getName());
    System.out.println("Board at position (" + x + ", " + y + "): " + plansza[x][y]);

    if (x < 0 || x >= 3 || y < 0 || y >= 3) {
      System.out.println("Invalid coordinates: (" + x + ", " + y + "). Coordinates must be between 0 and 2.");
      return false;
    }

    if (!gracze[obecnyGracz].getName().equals(klient.getName())) {
      System.out.println("It's not " + klient.getName() + "'s turn.");
      return false;
    }

    if (plansza[x][y] != '-') {
      System.out.println("Cell (" + x + ", " + y + ") is already taken: " + plansza[x][y]);
      return false;
    }

    plansza[x][y] = klient.getSymbol();
    System.out.println("Gracz " + klient.getName() + " wykonał ruch: (" + x + ", " + y + ")");

    System.out.println("Updated board:");
    for (char[] row : plansza) {
      System.out.println(Arrays.toString(row));
    }

    obecnyGracz = 1 - obecnyGracz;
    return true;
  }


  @Override
  public synchronized char[][] pobierzPlansze() throws RemoteException {
    return plansza;
  }

  @Override
  public synchronized boolean czyKoniecGry() throws RemoteException {
    return pobierzZwyciezce() != null || Arrays.stream(plansza).flatMapToInt(row -> new String(row).chars()).noneMatch(ch -> ch == '-');
  }

  @Override
  public synchronized MyClientInt pobierzZwyciezce() throws RemoteException {
    for (int i = 0; i < 3; i++) {
      if (plansza[i][0] != '-' && plansza[i][0] == plansza[i][1] && plansza[i][1] == plansza[i][2]) return znajdzGracza(plansza[i][0]);
      if (plansza[0][i] != '-' && plansza[0][i] == plansza[1][i] && plansza[1][i] == plansza[2][i]) return znajdzGracza(plansza[0][i]);
    }
    if (plansza[0][0] != '-' && plansza[0][0] == plansza[1][1] && plansza[1][1] == plansza[2][2]) return znajdzGracza(plansza[0][0]);
    if (plansza[0][2] != '-' && plansza[0][2] == plansza[1][1] && plansza[1][1] == plansza[2][0]) return znajdzGracza(plansza[0][2]);
    return null;
  }

  private MyClientInt znajdzGracza(char symbol) throws RemoteException {
    for (MyClientInt g : gracze) {
      if (g != null && g.getSymbol() == symbol) return g;
    }
    return null;
  }

  @Override
  public synchronized String czyjRuch() throws RemoteException {
    return "Teraz ruch gracza: " + gracze[obecnyGracz].getName();
  }

  @Override
  public synchronized int ileGraczy() throws RemoteException {
    int liczbaGraczy = 0;
    for (MyClientInt klient : gracze) {
      if (klient != null) {
        liczbaGraczy++;
      }
    }
    return liczbaGraczy;
  }

}
