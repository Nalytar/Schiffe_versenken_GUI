package View;
import Model.Feld;
import Model.Spieler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Monokai Pro (Filter Spectrum)
public class Gui extends JFrame {

    private Spieler spieler1;
//    private Spieler spieler2;

    private final int width = 770;
    private final int height = 770;

    public Gui(Spieler spieler1){

        this.spieler1 = spieler1;

        setTitle("Schiffe versenken");
        setSize(width,height);

        //setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        Container outside = getContentPane();
        outside.setLayout(new BorderLayout());

        JPanel inside = new JPanel();
        inside.setLayout(new GridLayout(10,10));

        JPanel zahlen = new JPanel();
        zahlen.setLayout(new GridLayout(1,11));
        zahlen.setSize(width, height/11);

        JPanel buchstaben = new JPanel();
        buchstaben.setLayout(new GridLayout(10,1));
        buchstaben.setSize(width/11, height);

        outside.add(zahlen, BorderLayout.NORTH);
        outside.add(inside, BorderLayout.CENTER);
        outside.add(buchstaben, BorderLayout.WEST);

        //Buttons hinzufügen
        for(Feld field : spieler1.getSpielfeld().values()){
            inside.add(field.getButton());
        }

        //Zahlenlegende
        zahlen.add(new JLabel()).setFont(new Font("Arial", Font.PLAIN, 35));
        for(int i = 0; i < 10; i++){
            JLabel label = new JLabel(String.valueOf(i), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 35));
            zahlen.add(label).setPreferredSize(new Dimension(width/11,height/11));
        }

        //Buchstabenlegende
        for(int i = 97; i < 107; i++){
            JLabel label = new JLabel(String.valueOf((char)i).toUpperCase(), SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.PLAIN, 35));
            buchstaben.add(label).setPreferredSize(new Dimension(width/11,height/11));
        }

    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
}
