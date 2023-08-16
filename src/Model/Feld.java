package Model;

import Controller.ComputerZug;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Feld {

    /*
    Relevanz der Attribute bei Ausgabe und der Zeichen sowie beim setzen der Schiffe!
     */
    private boolean besetzt = false;
    private boolean beschossen = false;
    private boolean getroffen = false;
    private final JButton button;
    private final Spieler spieler;

    Feld(Spieler spieler){
        /*
        Zuweisung eines Spielers
         */
        this.spieler = spieler;

        /*
        Erzeugt Buttons für GUI
         */
        button = new JButton("~");
        button.setBackground(new Color(17, 112, 158));
        button.setFont(new Font("Arial", Font.PLAIN, 35));

        ActionListener performer = e -> {
            if (!isBesetzt()) {
                setBeschossen();
            } else if (!isGetroffen()) {
                setGetroffen();
            }
        };

        button.addActionListener(performer);

        if(spieler instanceof Computer){
            button.setEnabled(false);
        }
        // wenn getroffen - Buttonfarbe: Rot
        // wenn beschossen und daneben - O
    }

    /*
    Setter und Getter
     */
    public void setBesetzt(){
        this.besetzt = !this.besetzt;
    }
    public boolean isBesetzt() {
        return besetzt;
    }
    public void setBeschossen() {
        this.beschossen = true;
        button.setText("0");

        if(!(spieler instanceof ComputerZug)){
            for(Feld f : spieler.getSpielfeld().values()){
                f.getButton().setEnabled(false);
            }
            Spieler computer = spieler.getGegner();
            ((ComputerZug) computer).ändereFeld();

        } else {
            Timer timer = new Timer(400, e -> {
                for(Feld f : spieler.getGegner().getSpielfeld().values()) {
                    f.getButton().setEnabled(true);
                }
            });
            timer.setRepeats(false);
            timer.start();
        }
    }
    public boolean isBeschossen() {
        return beschossen;
    }

    public void setGetroffen() {
        this.getroffen = true;
        button.setBackground(new Color(178, 21, 21));
        button.setText("X");
        spieler.getGegner().setLeben();

        if(spieler instanceof ComputerZug){
            ((ComputerZug) spieler).ändereFeld();
        }
    }

    public boolean isGetroffen() {
        return getroffen;
    }

    public JButton getButton() {
        return button;
    }
}

