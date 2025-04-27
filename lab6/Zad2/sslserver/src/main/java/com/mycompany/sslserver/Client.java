package com.mycompany.sslserver;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.BindingProvider;

public class Client {
    public static void main(String[] args) throws Exception {
        System.setProperty("javax.net.ssl.trustStore", "C:/Users/student/Desktop/ESES/truststore.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
        
        System.setProperty("javax.net.debug", "all");

        URL url = new URL("https://localhost:8080/sslserver/MyServiceService?wsdl");  
        
        QName qname = new QName("https://sslserver.mycompany.com/", "MyServiceService");

        Service service = Service.create(url, qname);

        MyServiceInt port = service.getPort(MyServiceInt.class);
        
        String result = port.sayHello("Test User");
        System.out.println("Wynik z serwisu: " + result);
    }  
}
