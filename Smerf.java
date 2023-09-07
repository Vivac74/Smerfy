package org.example;

import java.util.List;
import java.util.Random;

public class Smerf extends Thread
{
    private String imie;
    private int wiek;
    private int zdrowie;
    private int poziomGlodu;
    private Wioska wioska;
    private int wytrzymalosc;
    private int umiejetnosciSpoleczne;
    private int inteligencja;
    private int szczescie;
    private int sila;
    private int zwinnosc;
    private int charyzma;
    private int gotowanie;

    public Smerf(String imie, int wiek, int zdrowie, Wioska wioska)
    {
        this.imie = imie;
        this.wiek = wiek;
        this.zdrowie = zdrowie;
        this.poziomGlodu = 0;
        this.wioska = wioska;
        this.wytrzymalosc = 0;
        this.umiejetnosciSpoleczne = 0;
        this.inteligencja = 0;
        this.szczescie = 0;
        this.sila = 0;
        this.zwinnosc = 0;
        this.charyzma = 0;
        this.gotowanie = 0;
    }
    public void wykonajAktywnosc()
    {
        // Symulacja aktywności Smerfa
        if (zdrowie > 0) {
            if (poziomGlodu > 10) {
                zdrowie -= 5;
            } else {
                zdrowie += 3;
            }
            poziomGlodu += losowaLiczba(1, 5);

            // Smerf może również zużywać zasoby z wioski podczas aktywności
            if (poziomGlodu > 10 && !wioska.getZasoby().isEmpty())
            {
                Zasob zasob = wioska.getZasoby().get(0);
                wioska.usunZasob(zasob);
            }
        }
    }

    public void ewoluuj()
    {
        if (wiek >= 100)
        {
            // Dojrzały Smerf
            wytrzymalosc += 10;
            umiejetnosciSpoleczne += 5;
            inteligencja += 5;
            szczescie -= 5;
            sila -= 6;
            zwinnosc += 7;

        }
        else if (wiek >= 50)
        {
            // Średni wiek Smerfa
            wytrzymalosc += 5;
            umiejetnosciSpoleczne += 2;
            inteligencja += 2;
            szczescie -= 6;
            sila += 10;
            zwinnosc += 9;

        }
        else if (wiek >= 25)
        {
            // Młody Smerf
            wytrzymalosc += 2;
            umiejetnosciSpoleczne += 1;
            inteligencja += 1;
            szczescie += 8;
            sila += 5;
            zwinnosc += 3;
        }

        wiek++;
    }




    public String getImie() {
        return imie;
    }

    public int getWiek() {
        return wiek;
    }

    public int getZdrowie() {
        return zdrowie;
    }

    public int getPoziomGlodu() {
        return poziomGlodu;
    }

    public Wioska getWioska() {
        return wioska;
    }

    public int getWytrzymalosc() {
        return wytrzymalosc;
    }

    public int getUmiejetnosciSpoleczne() {
        return umiejetnosciSpoleczne;
    }

    public int getInteligencja() {
        return inteligencja;
    }

    public int getSzczescie() {
        return szczescie;
    }

    public int getSila() {
        return sila;
    }

    public int getZwinnosc() {
        return zwinnosc;
    }

    public int getCharyzma() {
        return charyzma;
    }

    public int getGotowanie() {
        return gotowanie;
    }

    private int losowaLiczba(int min, int max)
    {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    @Override
    public void run()
    {
        while (zdrowie > 0) {
            // Wykonywanie aktywności przez Smerfa
            wykonajAktywnosc();

            // Ewolucja Smerfa
            ewoluuj();

            // Interakcje między Smerfami
            interakcje();

            // Wypisanie stanu Smerfa
            System.out.println(imie + ": Wiek: " + wiek + " Zdrowie: " + zdrowie + " Poziom Glodu: " + poziomGlodu +
                    " Wytrzymalosc: " + wytrzymalosc + " Umiejetnosci Spoleczne: " + umiejetnosciSpoleczne +
                    " Inteligencja: " + inteligencja + " Szczescie: " + szczescie + " Sila: " + sila +
                    " Zwinnosc: " + zwinnosc + " Charyzma: " + charyzma + " Gotowanie: " + gotowanie);

            try {
                // Odczekanie przed kolejną iteracją wątku (1 sekunda)
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Po zakończeniu pętli wątek Smerfa kończy działanie
        System.out.println(imie + " jest w lepszym świecie...");
    }

    private void interakcje()
    {
        // Losowe wybranie innego Smerfa do interakcji
        List<Smerf> inniSmerfowie = wioska.getSmerfy();
        if (inniSmerfowie.size() > 1)
        {
            Smerf innySmerf = inniSmerfowie.get(new Random().nextInt(inniSmerfowie.size()));
            if (innySmerf != this)
            {
                System.out.println(imie + " interaguje z " + innySmerf.getImie());

                if (poziomGlodu > 10 && innySmerf.getPoziomGlodu() > 10)
                {
                    System.out.println(imie + " i " + innySmerf.getImie() + " jedzą razem.");
                    poziomGlodu -= 5;
                    innySmerf.zmniejszPoziomGlodu(5);
                } else{
                    System.out.println(imie + " i " + innySmerf.getImie() + " rozmawiają.");
                    umiejetnosciSpoleczne += 2;
                    innySmerf.zwiekszUmiejetnosciSpoleczne(2);
                }
            }
        }
    }

    // Metoda umożliwiająca zmniejszenie poziomu głodu innego Smerfa
    public void zmniejszPoziomGlodu(int ilosc) {
        if (ilosc > 0 && poziomGlodu >= ilosc) {
            poziomGlodu -= ilosc;
        }
    }

    // Metoda umożliwiająca zwiększenie umiejętności społecznych innego Smerfa
    public void zwiekszUmiejetnosciSpoleczne(int ilosc) {
        if (ilosc > 0) {
            umiejetnosciSpoleczne += ilosc;
        }
    }
}

