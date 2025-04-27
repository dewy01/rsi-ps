package com.mycompany.sslserver;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class MyService {
    @WebMethod
    public String sayHello(String name) {
        return "Hello, " + name;
    }
}
