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
        // + /RMI_DW_CLIENT only if started from parent directory instead of project
        // directory
        String projectPath = System.getProperty("user.dir") + "/RMI_DW_CLIENT";
        String policyPath = "file:" + projectPath + "/security.policy";
        System.setProperty("java.security.policy", policyPath);
        System.out.println("Security Policy Path: " + System.getProperty("java.security.policy"));
        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//" + serverUrl + "/ABC");
            // MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("10.20.16.2/ABC");
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

            System.out.println("You joined the game! Input move in format 'x y'");

            while (!myRemoteObject.czyKoniecGry()) {
                System.out.println(myRemoteObject.czyjRuch());
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                if (parts.length == 2) {
                    try {
                        int x = Integer.parseInt(parts[0]);
                        int y = Integer.parseInt(parts[1]);
                        System.out.println("Attempting move at: (" + x + ", " + y + ")");

                        if (!myRemoteObject.wykonajRuch(y, x, client)) {
                            System.out.println("Invalid move. Try again.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid format. Input move in format 'x y'.");
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
            }

            MyClientInt winner = myRemoteObject.pobierzZwyciezce();
            if (winner != null) {
                System.out.println("Winner: " + winner.getName());
            } else {
                System.out.println("Draw!");
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printBoard(char[][] board) {
        System.out.println("Current board:");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
