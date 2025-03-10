package com.mycompany.rmi_dw_client;

import com.mycompany.rmi_dw.MyServerInt;

import java.io.File;
import java.rmi.Naming;

public class RMI_DW_CLIENT {

    public static void main(String[] args) {
        // String serverUrl = "localhost";
         String serverUrl = "172.21.64.1";
        // + /RMI_DW_CLIENT only if started from parent directory instead of project directory
        String projectPath = System.getProperty("user.dir")+"/RMI_DW";
        String policyPath = "file:" + projectPath + "/security.policy";
        System.setProperty("java.security.policy", policyPath);
        System.out.println("Security Policy Path: " + System.getProperty("java.security.policy"));
        System.setSecurityManager(new SecurityManager());
        try {
            MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("//"+serverUrl+"/ABC");
            //MyServerInt myRemoteObject = (MyServerInt) Naming.lookup("10.20.16.2/ABC");
            String text = "Hallo :-)";
            String result = myRemoteObject.getDescription(text);
            System.out.println("Wysłano do servera: " + text);
            System.out.println("Otrzymana z serwera odpowiedź: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
