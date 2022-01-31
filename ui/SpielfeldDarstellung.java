package ui;

import util.Interaktionsbrett;

public class SpielfeldDarstellung {
    private Interaktionsbrett ib;
    private final int seitenLängeX=380;
    private final int seitenLängeY=500;
    int durchlauf =0;

    SpielfeldDarstellung(Interaktionsbrett ib){
        this.ib = ib;
    }

    public void spielfeldDarstellen(boolean[][] spielfeld){
        this.abwischen();
        for(int i = 0; i<spielfeld.length; i++){
            for(int j = 0; j<spielfeld.length; j++){
                Quadrat p = new Quadrat(i*this.seitenLängeX/spielfeld.length, j*this.seitenLängeX/spielfeld.length, this.seitenLängeX/ spielfeld.length);
                p.darstellenRahmen(this.ib);
                if(spielfeld[i][j])
                    p.darstellenFuellung(this.ib);
            }
        }
        durchlauf++;
        this.ib.neuerText(190,450,"Durchlauf Nummer: " + durchlauf);
    }
    public void abwischen(){
        this.ib.abwischen();
    }
}
