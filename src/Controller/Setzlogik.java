package Controller;

import Model.Schiffe;
import Model.Spieler;

public class Setzlogik {

    public Setzlogik(Spieler spieler) {
        setSchiffeRandom(spieler);
    }

    private void setSchiffeRandom(Spieler spieler){

        for(Schiffe s : Schiffe.values()){
            boolean richtung = Controller.random.nextBoolean();
            if(richtung){
                setHorizontal(s, spieler);
            }
            else {
                setVertikal(s, spieler);
            }
        }
    }

    /*
   Horizontal, erhöhen der Zahl für x-Achse, Randomizer abzüglich Schifflänge um "im Spielfeld" zu bleiben
    */
    private void setHorizontal(Schiffe schiff, Spieler spieler) {
        boolean testen;
        int buchstabe;
        int zahl;
        int start;

        do{
            testen = false;
            buchstabe = Controller.random.nextInt(97, 107);
            zahl = Controller.random.nextInt(0, 10 - schiff.getLaenge());
            start = zahl;

            for (int i = 0; i < schiff.getLaenge(); i++) {
                String key = String.valueOf((char)buchstabe) + zahl;
                if (spieler.getSpielfeld().get(key).isBesetzt()) {
                    testen = true;
                    break;
                }
                zahl++;
            }
        } while(testen);

        for(int i = 0; i < schiff.getLaenge(); i++){
            String key = String.valueOf((char)buchstabe) + start;
            spieler.getSpielfeld().get(key).setBesetzt();
            start++;
        }
    }

    /*
    Vertikal, erhöhen des Buchstaben für y-Achse, Randomizer buchstabe abzüglich schifflänge für entsprechenden ASCII-Wert
     */
    private void setVertikal(Schiffe schiff, Spieler spieler){
        boolean testen;
        int buchstabe;
        int zahl;
        int start;

        do{
            testen = false;
            buchstabe = Controller.random.nextInt(97, 107 - schiff.getLaenge());
            zahl = Controller.random.nextInt(0, 10);
            start = buchstabe;

            for(int i = 0; i < schiff.getLaenge(); i++){
                String key = String.valueOf((char)buchstabe) + zahl;
                if(spieler.getSpielfeld().get(key).isBesetzt()){
                    testen = true;
                    break;
                }
                buchstabe++;
            }
        } while(testen);

        for(int i = 0; i <schiff.getLaenge(); i++){
            String key = String.valueOf((char)start) + zahl;
            spieler.getSpielfeld().get(key).setBesetzt();
            start++;
        }
    }
}
