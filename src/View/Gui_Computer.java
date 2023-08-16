package View;

import Model.Spieler;

public class Gui_Computer extends Gui{
    public Gui_Computer(Spieler spieler1, Gui gui) {
        super(spieler1);
        setLocation(gui.getX() + gui.getWidth(), gui.getY());

    }
}
