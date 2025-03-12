package webservicesclient;


import org.example.HelloWorld;
import org.example.HelloWorldImplService;

import javax.xml.namespace.QName;
import java.net.URL;
import javax.xml.ws.Service;


public class WebServicesClient2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("http://localhost:9999/ws/hello?wsdl");
        QName qname = new QName("http://example.org/","HelloWorldImplService");

        Service service  = Service.create(url,qname);
        HelloWorld hello = service.getPort(HelloWorld.class);

        String zapytanie = "To ja - KLIENT2";
        String response = hello.getHelloWorldAsString(zapytanie);
        System.out.println("Klient wysłał: " + zapytanie);
        System.out.println("Klient otrzymał: " + response);
    }
}
