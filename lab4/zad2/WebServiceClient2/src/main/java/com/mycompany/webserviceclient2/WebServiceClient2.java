/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.webserviceclient2;

//import geoipclient.GeoIP;
import geoipclient.GeoIPService;
import geoipclient.GeoIPServiceSoap;

public class WebServiceClient2 {

    public static void main(String[] args) {


        // Utworzenie instancji klienta
        GeoIPService service = new GeoIPService();
        GeoIPServiceSoap soap = service.getGeoIPServiceSoap();

       
        System.out.println("Location: " +  soap.getLocation());
        soap.getLocation();
//        // Wywołanie metody
//        GeoIP geoIP = soap.getGeoIP(ipAddress); // 'geoIP' to obiekt, który powinien zawierać dane
//
//        // Przykład, sprawdź dostępne metody w obiekcie 'geoIP' (np. getCountryName, getCountryCode, etc.)
//        System.out.println("IP Address: " + geoIP.getIP());
//        System.out.println("Country Name: " + geoIP.getCountryName());
//        System.out.println("Country Code: " + geoIP.getCountryCode());  // Może to być np. 'getCountryCodeS'!
//    }
    }
}
        