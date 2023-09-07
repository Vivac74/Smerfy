package org.example;

public class Zasob {
    private String nazwa;
    private int ilosc;

    public Zasob(String nazwa, int ilosc) {
        this.nazwa = nazwa;
        this.ilosc = ilosc;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIlosc() {
        return ilosc;
    }

    public void setIlosc(int ilosc) {
        this.ilosc = ilosc;
    }

    // Dodane rodzaje zasobów
    public static final Zasob POZYWIENIE = new Zasob("Pożywienie", 0);
    public static final Zasob DREWNO = new Zasob("Drewno", 0);
    public static final Zasob KAMIEŃ = new Zasob("Kamień", 0);
    public static final Zasob LISCE = new Zasob("Liście", 0);
    public static final Zasob KORA_DRZEW = new Zasob("Kora Drzewa", 0);
    public static final Zasob WEGIEL_DRZEWNY = new Zasob("Węgiel Drzewny", 0);
    public static final Zasob NASIONA = new Zasob("Nasiona", 0);
}


