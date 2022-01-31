package logik;

public class Simulator implements Simulation{

    private boolean [][] spielfeld;
    private int anzahlFelder;
    private BeiAenderung beiAenderung;

    @Override
    public void berechneAnfangsGeneration(int anzahlDerZellen, int wahrscheinlichkeitDerBesiedlung) {
        this.spielfeld = new boolean[anzahlDerZellen][anzahlDerZellen];
        int tempRand = 1 + (int)(Math.random() * 100);

        for (int i = 0; i<anzahlDerZellen; i++){
            for(int j = 0; j<anzahlDerZellen; j++){
                if(tempRand>wahrscheinlichkeitDerBesiedlung){
                    this.spielfeld[i][j] = true;
                }
                tempRand = 1 + (int)(Math.random() * 100);
            }
        }
        beiAenderung.aktualisiere(this.getSpielfeld());

    }
    public boolean[][] getSpielfeld() {
        return this.spielfeld;
    }
    public int getAnzahlFelder(){
        return this.anzahlFelder;
    }
    @Override
    public void berechneFolgeGeneration(int berechnungsschritte) {
        int kantenZelle=-1;
        int anzahlNachbarn;
        int tempi;
        int tempj;

        for(int k = 0; k<berechnungsschritte;k++){
            for(int i=0;i<this.spielfeld.length; i++){
                for (int j= 0; j<this.spielfeld.length; j++){
                    anzahlNachbarn=0;
                        for(tempi=i-1;tempi<i+2;tempi++){
                                for (tempj=j-1;tempj<j+2;tempj++){
                                    if(tempi!=kantenZelle&&tempj!=kantenZelle&&tempi<this.spielfeld.length&&tempj<this.spielfeld.length){
                                        if(this.spielfeld[tempi][tempj]){
                                            anzahlNachbarn++;
                                        }
                                }
                            }
                        }
                        if(anzahlNachbarn==2||anzahlNachbarn==3){
                            if(anzahlNachbarn==3||!this.spielfeld[i][j]) {
                                this.spielfeld[i][j] = true;
                            }
                        }else{
                            this.spielfeld[i][j]=false;
                        }
                }
            }
            try{
                Thread.sleep(300);
                this.beiAenderung.aktualisiere(this.getSpielfeld());
            }
            catch(InterruptedException e){
                System.out.println("Thread hat geschlafen");
            }
        }
        System.out.println("Letzte Generation dargestellt.");
    }

    @Override
    public void anmeldenFuerAktualisierungBeiAenderung(BeiAenderung beiAenderung) {
        this.beiAenderung = beiAenderung;
    }
}
