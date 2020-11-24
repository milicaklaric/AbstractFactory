/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import AbstractFactory.*;
import AbstractProductA.*;
import AbstractProductB.*;
import AbstractProductC.*;

/**
 *
 * @author MK
 */
public class Sef {//Client

    Projektant proj;//Abstract Factory

    class PlesnaSkola // Complex Product
    {

        EkranskaForma ef; // AbstractProductA 
        BrokerBazePodataka bbp; // AbstractProductB 
        Kontroler kon; // AbstractProductC 

        PlesnaSkola(EkranskaForma ef1, BrokerBazePodataka bbp1, Kontroler kon1) {
            ef = ef1;
            bbp = bbp1;
            kon = kon1;
        }

        void prikaziEkranskuFormu() {
            ef.prikaziEkranskuFormu();
        }
    }
    PlesnaSkola ps;

    Sef(Projektant proj1) {
        proj = proj1;
    }

    public static void main(String[] args) {
        Sef sef; // ConcreteFactory3
        Projektant proj = new Projektant4(); // Promenljivo!!! 
        sef = new Sef(proj);
        sef.Kreiraj(); //Klient nadzire proces izrade
    }

    void Kreiraj() { //Server kreira delove slozenog proizvoda
        EkranskaForma ef = proj.kreirajEkranskuFormu();
        BrokerBazePodataka bbp = proj.kreirajBrokerBazePodataka();
        Kontroler kon = proj.kreirajKontroler(ef, bbp);
        ps = new PlesnaSkola(ef, bbp, kon);
        ps.prikaziEkranskuFormu();
    }

}
