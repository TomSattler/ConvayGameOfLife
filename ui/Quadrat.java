package ui;

import util.Interaktionsbrett;

public class Quadrat {

    private int x;
    private int y;
    private int seitenlaenge;

    public Quadrat(int x, int y, int seitenlaenge) {
        setSeitenlaenge(seitenlaenge);
        setY(y);
        setX(x);
    }

    public void darstellenRahmen(Interaktionsbrett ib){
        ib.neuesRechteck(this.x,this.y, this.seitenlaenge,this.seitenlaenge);
    }

    public void darstellenFuellung(Interaktionsbrett ib){
        for(int i = 0; i < seitenlaenge; i++) {
            ib.neueLinie(this.x, this.y+i, this.x +seitenlaenge, this.y + i);
        }
    }

    public void setX(int x) {
        if(x>0)
            this.x=x;
    }

    public void setY(int y) {
        if(y>0)
            this.y = y;
    }

    public void setSeitenlaenge(int seitenlaenge) {
        if(seitenlaenge>0){
            this.seitenlaenge = seitenlaenge;
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getSeitenlaenge() {
        return seitenlaenge;
    }



}
