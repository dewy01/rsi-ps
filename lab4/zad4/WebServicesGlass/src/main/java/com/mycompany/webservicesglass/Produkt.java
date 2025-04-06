
package com.mycompany.webservicesglass;

public class Produkt {
private String nazwa;
private String opis;
private int cena;

    public Produkt(String nazwa, String opis, int cena){
        this.nazwa = nazwa;
        this.opis=opis;
        this.cena=cena;
    }
    
    public void setNazwa(String nazwa) {
        this.nazwa=nazwa;
    }
    
    public String getNazwa(){
        return this.nazwa;
    }
    
    public void setOpis(String opis) {
        this.opis=opis;
    }
    
    public String getOpis(){
        return this.opis;
    }
    
    public void setCena(int cena) {
        this.cena=cena;
    }
    
    public int getCena(){
        return this.cena;
    }
}

