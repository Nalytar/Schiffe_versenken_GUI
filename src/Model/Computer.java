package Model;

import Controller.ComputerZug;
import Controller.Controller;

import javax.swing.*;


public class Computer extends Spieler implements ComputerZug {

    private String zufallFeld(){
        String zufall;
        int buchstabe;
        int zahl;

        do{
            buchstabe = Controller.random.nextInt(97, 107);
            zahl = Controller.random.nextInt(0, 10);
            zufall = String.valueOf((char)buchstabe) + zahl;

        } while (this.spielfeld.get(zufall).isBeschossen() ||
                 this.spielfeld.get(zufall).isGetroffen());

        return zufall.toLowerCase();
    }


    // "Schießen"
    @Override
    public void ändereFeld() {
        Feld feld = this.getSpielfeld().get(zufallFeld());
        Timer timer = new Timer(500, e -> {
            if (feld.isBesetzt()) {
                feld.setGetroffen();
            } else {
                feld.setBeschossen();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }
}
