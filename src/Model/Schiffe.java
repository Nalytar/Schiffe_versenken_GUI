package Model;

public enum Schiffe {

    SCHIFFE_5er(5),
    SCHIFFE_4er1(4),
    SCHIFFE_4er2(4),
    SCHIFFE_3er1(3),
    SCHIFFE_3er2(3),
    SCHIFFE_3er3(3),
    SCHIFFE_2er1(2),
    SCHIFFE_2er2(2),
    SCHIFFE_2er3(2),
    SCHIFFE_2er4(2);

    Schiffe(int laenge){
        this.laenge = laenge;
    }
    private final int laenge;

    public int getLaenge() {
        return laenge;
    }
}
