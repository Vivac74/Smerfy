package org.example;

import java.util.List;

public class Statystyki {
    private int liczbaSmerfow;
    private int sredniWiek;
    private int sumaWytrzymalosci;
    private int sumaUmiejetnosciSpolecznych;
    private int sumaInteligencji;
    private int sumaSily;
    private int sumaZwinosci;
    private int sumaCharyzmy;
    private int sumaSzczescie;
    private int sumaGotowanie;
    public Statystyki()
    {
        this.liczbaSmerfow = 0;
        this.sredniWiek = 0;
        this.sumaWytrzymalosci = 0;
        this.sumaUmiejetnosciSpolecznych = 0;
        this.sumaInteligencji = 0;
        this.sumaSily = 0;
        this.sumaZwinosci = 0;
        this.sumaCharyzmy = 0;
        this.sumaSzczescie = 0;
        this.sumaGotowanie = 0;
    }

    public void aktualizujStatystyki(List<Smerf> smerfy)
    {
        liczbaSmerfow = smerfy.size();

        if (liczbaSmerfow > 0)
        {
            int sumaWiekow = 0;
            sumaWytrzymalosci = 0;
            sumaUmiejetnosciSpolecznych = 0;
            sumaInteligencji = 0;
            sumaSily = 0;
            sumaZwinosci = 0;
            sumaCharyzmy = 0;
            sumaSzczescie = 0;
            sumaGotowanie = 0;

            for (Smerf smerf : smerfy)
            {
                sumaWiekow += smerf.getWiek();
                sumaWytrzymalosci += smerf.getWytrzymalosc();
                sumaUmiejetnosciSpolecznych += smerf.getUmiejetnosciSpoleczne();
                sumaInteligencji += smerf.getInteligencja();
                sumaSily += smerf.getSila();
                sumaZwinosci += smerf.getZwinnosc();
                sumaCharyzmy += smerf.getCharyzma();
                sumaSzczescie += smerf.getSzczescie();
                sumaGotowanie += smerf.getGotowanie();
            }

            sredniWiek = sumaWiekow / liczbaSmerfow;
        } else {
            sredniWiek = 0;
            sumaWytrzymalosci = 0;
            sumaUmiejetnosciSpolecznych = 0;
            sumaInteligencji = 0;
            sumaSily = 0;
            sumaZwinosci = 0;
            sumaCharyzmy = 0;
            sumaSzczescie = 0;
            sumaGotowanie = 0;
        }
    }

    public int getLiczbaSmerfow() {
        return liczbaSmerfow;
    }

    public int getSredniWiek() {
        return sredniWiek;
    }

    public int getSumaWytrzymalosci() {
        return sumaWytrzymalosci;
    }

    public int getSumaUmiejetnosciSpolecznych() {
        return sumaUmiejetnosciSpolecznych;
    }

    public int getSumaInteligencji() {
        return sumaInteligencji;
    }

    public int getSumaSily() {
        return sumaSily;
    }

    public int getSumaZwinosci() {
        return sumaZwinosci;
    }

    public int getSumaCharyzmy() {
        return sumaCharyzmy;
    }

    public int getSumaSzczescie() {
        return sumaSzczescie;
    }

    public int getSumaGotowanie() {
        return sumaGotowanie;
    }
}

