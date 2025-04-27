/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sslclient;

/**
 *
 * @author student
 */
public class Sslclient {

    public static void main(String[] args) {
        System.setProperty("javax.net.ssl.trustStore", "C:/Users/student/Desktop/ESES/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword","changeit");
        
        System.setProperty("javax.net.debug","all");
       
    }
}
