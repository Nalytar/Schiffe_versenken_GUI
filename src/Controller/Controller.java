package Controller;

import Model.Computer;
import Model.Spieler;
import View.Gui;
import View.Gui_Computer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Controller {

    public static Random random = new Random();

    public static void spielStarten(){
        Spieler spieler1 = new Spieler();
        Computer computer = new Computer();

        spieler1.setGegner(computer);
        computer.setGegner(spieler1);

        EventQueue.invokeLater(() -> {
            Gui gui1 = new Gui(spieler1);
            gui1.setVisible(true);
            gui1.setTitle("Schiffe versenken - Spieler: ");

            Gui gui2 = new Gui_Computer(computer, gui1);
            gui2.setTitle("Schiffe versenken - Computer: ");
            gui2.setVisible(true);
        });
    }

    private static void fensterSchließen(){
        for(int i = 0; i < Gui.getWindows().length; i++){
            Gui.getWindows()[i].setVisible(false);
            Gui.getWindows()[i].dispose();
        }
    }

    public static void spielende(String message, String titel){
        int selectedVal = JOptionPane.showConfirmDialog(Gui.getWindows()[0], message,titel,JOptionPane.YES_NO_OPTION);

        if(selectedVal == JOptionPane.YES_OPTION){
            Controller.fensterSchließen();
            Controller.spielStarten();

        } else {
            Controller.fensterSchließen();
        }
    }
}
