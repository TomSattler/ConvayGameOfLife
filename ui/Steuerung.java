package ui;

import logik.BeiAenderung;
import logik.Simulator;
import util.EinUndAusgabe;
import util.Interaktionsbrett;

public class Steuerung implements BeiAenderung {
    Simulator simulator;
    NutzerEingabe nutzerEingabe;
    SpielfeldDarstellung spielfeldDarstellung;



    public Steuerung(){}
    public void startDesSpiels(){
        initialisierung();
    }
    private void initialisierung(){
        EinUndAusgabe einUndAusgabe = new EinUndAusgabe();
        Interaktionsbrett interaktionsbrett = new Interaktionsbrett();
        this.spielfeldDarstellung = new SpielfeldDarstellung(interaktionsbrett);
        this.simulator = new Simulator();
        this.simulator.anmeldenFuerAktualisierungBeiAenderung(this);
        this.nutzerEingabe = new NutzerEingabe(einUndAusgabe);
        this.simulator.berechneAnfangsGeneration(this.nutzerEingabe.anzahlZellenDesSpielfelds(), this.nutzerEingabe.wahrscheinlichkeitDerBesiedlung());
        this.simulator.berechneFolgeGeneration(this.nutzerEingabe.anzahlDerSimulationsschritte());
    }
    public static void main(String [] args){
        Steuerung s = new Steuerung();
        s.initialisierung();
    }

    @Override
    public void aktualisiere(boolean[][] neueGeneration) {
        this.spielfeldDarstellung.spielfeldDarstellen(neueGeneration);
    }
}
