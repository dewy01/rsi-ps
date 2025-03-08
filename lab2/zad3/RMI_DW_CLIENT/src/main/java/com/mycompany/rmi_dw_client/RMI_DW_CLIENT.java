package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerImpl;
import com.mycompany.rmi_dw.MyServerInt;

import java.rmi.Naming;
import java.util.Arrays;
import java.util.Scanner;

public class RMI_DW_CLIENT {

    public static void main(String[] args) {
        // String serverUrl = "localhost";
         String serverUrl = "localhost";
        // + /RMI_DW_CLIENT only if started from parent directory instead of project directory
        String projectPath = System.getProperty("user.dir")+"/RMI_DW_CLIENT";
        String policyPath = "file:" + projectPath + "/security.policy";
        System.setProperty("java.security.policy", policyPath);
        System.out.println("Security Policy Path: " + System.getProperty("java.security.policy"));
        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//"+serverUrl+"/ABC");
            //MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("10.20.16.2/ABC");
            Scanner scanner = new Scanner(System.in);
            System.out.print("Podaj swoje imię: ");
            String name = scanner.nextLine();

            int il = myRemoteObject.ileGraczy();
            char symbol = (il == 0) ? 'X' : 'O';
            MyClientImpl client = new MyClientImpl(name, symbol);

            if (!myRemoteObject.dolaczDoGry(client)) {
                System.out.println("Gra jest już pełna!");
                return;
            }


            System.out.println("Dołączyłeś do gry! Wpisz ruch w formacie 'x y'");

            while (!myRemoteObject.czyKoniecGry()) {
                System.out.println(myRemoteObject.czyjRuch());
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    try {
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        System.out.println("Attempting move at: (" + x + ", " + y + ")");

                        if (!myRemoteObject.wykonajRuch(x, y, client)) {
                            System.out.println("Nieprawidłowy ruch. Spróbuj ponownie.");
                        }
                        char[][] board = myRemoteObject.pobierzPlansze();
                        printBoard(board);
                    } catch (NumberFormatException e) {
                        System.out.println("Nieprawidłowy format. Wpisz liczby w formacie 'x y'.");
                    }
                } else {
                    System.out.println("Nieprawidłowy ruch. Spróbuj ponownie.");
                }
            }


            MyClientInt winner = myRemoteObject.pobierzZwyciezce();
            if (winner != null) {
                System.out.println("Zwycięzca: " + winner.getName());
            } else {
                System.out.println("Remis!");
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void printBoard(char[][] board) {
        System.out.println("Aktualna plansza:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
