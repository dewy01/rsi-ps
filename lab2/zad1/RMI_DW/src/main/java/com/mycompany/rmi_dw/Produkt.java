package com.mycompany.rmi_dw;

import java.io.Serializable;

public class Produkt implements Serializable {
    private String nazwa;
    private double cena;

    public Produkt(String nazwa, double cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public double getCena() {
        return cena;
    }

    @Override
    public String toString() {
        return "Produkt{" + "nazwa='" + nazwa + '\'' + ", cena=" + cena + '}';
    }
}