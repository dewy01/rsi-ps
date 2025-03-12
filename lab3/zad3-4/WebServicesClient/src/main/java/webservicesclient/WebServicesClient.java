package webservicesclient;


import org.example.HelloWorld;
import org.example.HelloWorldImplService;

public class WebServicesClient {
    public static void main(String[] args) {
        HelloWorldImplService helloService = new HelloWorldImplService();
        HelloWorld hello = helloService.getHelloWorldImplPort();

        String zapytanie = "To ja - KLIENT";
        String response = hello.getHelloWorldAsString(zapytanie);
        System.out.println("Klient wysłał: " + zapytanie);
        System.out.println("Klient otrzymał: " + response);
    }
}
