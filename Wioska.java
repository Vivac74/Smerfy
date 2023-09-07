package org.example;

import java.util.ArrayList;
import java.util.List;

public class Wioska {
    private List<Smerf> smerfy;
    private List<Zasob> zasoby;
    private Statystyki statystyki;

    public Wioska() {
        this.smerfy = new ArrayList<>();
        this.zasoby = new ArrayList<>();
        this.statystyki = new Statystyki();
    }

    public void dodajSmerfa(Smerf smerf) {
        smerfy.add(smerf);
    }

    public void usunSmerfa(Smerf smerf) {
        smerfy.remove(smerf);
    }

    public void dodajZasob(Zasob zasob) {
        zasoby.add(zasob);
    }

    public void usunZasob(Zasob zasob) {
        zasoby.remove(zasob);
    }

    public void aktualizujZasob(Zasob zasob, int nowaIlosc) {
        for (Zasob z : zasoby) {
            if (z.equals(zasob)) {
                z.setIlosc(nowaIlosc);
                break;
            }
        }
    }

    public void symulujAktywnosci() {
        for (Smerf smerf : smerfy) {
            smerf.wykonajAktywnosc();
        }
    }

    public void zarzadzajEwolucja() {
        for (Smerf smerf : smerfy) {
            smerf.ewoluuj();
        }
    }

    public void zarzadzajInterakcjami() {
        //niedokończone
    }

    public Statystyki generujStatystyki() {
        return statystyki;
    }


    public List<Smerf> getSmerfy() {
        return smerfy;
    }

    public void setSmerfy(List<Smerf> smerfy) {
        this.smerfy = smerfy;
    }


    public List<Zasob> getZasoby() {
        return zasoby;
    }

    public void setZasoby(List<Zasob> zasoby) {
        this.zasoby = zasoby;
    }


    public Statystyki getStatystyki() {
        return statystyki;
    }

    public void setStatystyki(Statystyki statystyki) {
        this.statystyki = statystyki;
    }
}

