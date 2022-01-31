package ui;

import util.EinUndAusgabe;

public class NutzerEingabe {
    EinUndAusgabe io;

    NutzerEingabe(EinUndAusgabe io){
        this.io = io;
    }
    int anzahlZellenDesSpielfelds() {
        int temp = -1;
        while (temp < 10) {
            System.out.println("Geben sie die Anzahl der Zellen an (ab 10).");
            temp = io.leseInteger();
        }
        return temp;
    }
    int wahrscheinlichkeitDerBesiedlung(){
        int temp = -1;
        while (temp < 1 || temp > 99) {
            System.out.println("Geben sie die Wahrscheinlichkeit der Besiedlung an (1-99).");
            temp = io.leseInteger();
        }
        return temp;
    }
    int anzahlDerSimulationsschritte(){
        int temp = -1;
        while (temp < 1) {
            System.out.println("Geben sie die Anzahl der Simulationsschritte an.");
            temp = io.leseInteger();
        }
        return temp;
    }
}
