package logik;

public interface Simulation {
    void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung);
    void berechneFolgeGeneration(int berechnungsschritte);
    void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung);
}
