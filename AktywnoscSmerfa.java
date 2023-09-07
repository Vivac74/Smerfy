package org.example;

public class AktywnoscSmerfa
{
    private String nazwa;
    private int poziomZmeczenia;
    private int czasTrwania; // w minutach

    public AktywnoscSmerfa(String nazwa, int poziomZmeczenia, int czasTrwania)
    {
        this.nazwa = nazwa;
        this.poziomZmeczenia = poziomZmeczenia;
        this.czasTrwania = czasTrwania;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public int getPoziomZmeczenia() {
        return poziomZmeczenia;
    }

    public void setPoziomZmeczenia(int poziomZmeczenia) {
        this.poziomZmeczenia = poziomZmeczenia;
    }

    public int getCzasTrwania() {
        return czasTrwania;
    }

    public void setCzasTrwania(int czasTrwania) {
        this.czasTrwania = czasTrwania;
    }
}

