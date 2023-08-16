package Model;

import Controller.Controller;
import Controller.Setzlogik;
import View.Gui;

import javax.swing.*;
import java.util.TreeMap;

public class Spieler {


    protected TreeMap<String, Feld> spielfeld;
    protected Spieler gegner;
    protected int leben = 0;


    public Spieler() {
        this.spielfeld = new TreeMap<>();
        erzeugeFelder();

        // Setze Schiffe
        new Setzlogik(this);

        for(Schiffe s : Schiffe.values()){
            this.leben += s.getLaenge();
        }
    }

    public TreeMap<String, Feld> getSpielfeld() {
        return spielfeld;
    }

    /*
    Erzeugt Spielfelder
     */
    private void erzeugeFelder(){
        int koordinate1 = 97;
        String koordinate2;

        for(int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){
                koordinate2 = String.valueOf((char)koordinate1) + j;
                this.spielfeld.put(koordinate2, new Feld(this));
            }
            koordinate1++;
        }
    }

    public void setGegner(Spieler gegner) {
        this.gegner = gegner;
    }
    public Spieler getGegner() {
        return gegner;
    }

    public void setLeben() {
        this.leben -= 1;
        if(this.leben == 0){
            if(this instanceof Computer){
                Controller.spielende("Sie haben Gewonnen!\nMöchten sie nochmal spielen?","Gewonnen :)");
            } else {
                Controller.spielende("Sie haben Verloren!\nMöchten sie nochmal spielen?","Verloren :(");
            }
        }
    }
}
