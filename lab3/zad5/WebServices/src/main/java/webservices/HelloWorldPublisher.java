package webservices;

import javax.xml.ws.Endpoint;
import org.example.HelloWorldImpl;

public class HelloWorldPublisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9999/ws/hello", new HelloWorldImpl());
        System.out.println("Web services czeka na klienta....");
    }
}
