package org.example;

//Service Implementation
import javax.jws.WebService;

@WebService(endpointInterface = "org.example.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) throws InvalidInputException {
        String outputText = "";
        if(name.equals("Dawid")){
            outputText = "Akceptuje " + name; 
        } else {
            throw new InvalidInputException("Nie właściwe dane wejściowe ",name + " nazwa inna niż Dawid");
        }
        
        
        return outputText;
    }
}
