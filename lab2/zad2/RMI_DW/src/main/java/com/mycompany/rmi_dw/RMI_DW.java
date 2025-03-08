package com.mycompany.rmi_dw;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.io.File;

public class RMI_DW {

    public static void main(String[] args) {
        //System.out.println("Hello World!");

        try {
            // String serverUrl = "localhost";
            String serverUrl = "localhost";

            // + /RMI_DW only if started from parent directory instead of project directory
            String projectPath = System.getProperty("user.dir")+"/RMI_DW";
            String policyPath = "file:" + projectPath + "/security.policy";

            // Set security policy dynamically
            System.setProperty("java.security.policy", policyPath);
            System.out.println("Security Policy Path: " + System.getProperty("java.security.policy"));

            // Ensure the policy file exists
            File policyFile = new File(projectPath + "/security.policy");
            if (!policyFile.exists()) {
                System.err.println("Error: Security policy file not found!");
                return;
            }
            //System.setProperty("java.rmi.server.codebase","file:/C:/Users/Jacek/workspace/ RMIServer / bin / ");
            System.setProperty("java.rmi.server.codebase", new File(projectPath, "target/classes/").toURI().toString());
            //System.setProperty("java.rmi.server.codebase", "http://192.168.1.102/jaco/");
            System.out.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));
            LocateRegistry.createRegistry(1099);
            MyServerImpl obj1 = new MyServerImpl();
            Naming.rebind("//"+serverUrl+"/ABC", obj1);
            System.out.println("Serwer oczekuje ...");
            System.out.println("Serwer czatu uruchomiony.");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
