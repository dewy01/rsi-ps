package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerInt;
import com.mycompany.rmi_dw.Produkt;

import java.io.File;
import java.rmi.Naming;

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

            System.out.println("Lista produktów:");
            for (Produkt p : myRemoteObject.listaProduktow()) {
                System.out.println(p);
            }

            String nazwaSzukana = "Laptop";
            Produkt znaleziony = myRemoteObject.znajdzProdukt(nazwaSzukana);
            System.out.println("Znaleziony produkt: " + znaleziony);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
