package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerImpl;
import com.mycompany.rmi_dw.MyServerInt;

import java.rmi.Naming;
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
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            MyClientImpl client = new MyClientImpl(name, myRemoteObject);

            System.out.println("Connected to chat. Type messages:");
            while (true) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("exit")) break;
                client.sendMessage(message);
            }

            scanner.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
