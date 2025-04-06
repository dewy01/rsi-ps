/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.webservicesglass;

//Service Implementation
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;

@WebService(endpointInterface = "com.mycompany.webservicesglass.HelloWorld")
public class HelloWorldImpl implements HelloWorld {
    @Override
    public String getHelloWorldAsString(String name) {
        return "Witaj świecie JAX-WS: " + name;
    }
    
     @Override
    public List<Produkt> getProducts() {
        List<Produkt> produkty = new ArrayList<>();

        produkty.add(new Produkt("Laptop", "Nowoczesny laptop z procesorem Intel i 16GB RAM", 4000));
        produkty.add(new Produkt("Smartphone", "Smartfon z 5G, ekran 6.5", 2500));
        produkty.add(new Produkt("Tablet", "Tablet z ekranem 10 cali i 64GB pamięci", 1500));
        
        return produkty;
    }
}