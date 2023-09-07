package org.example;

import java.util.ArrayList;
import java.util.List;

public class Dom
{
    private int pojemnosc;
    private List<Smerf> mieszkancy;

    public Dom(int pojemnosc)
    {
        this.pojemnosc = pojemnosc;
        this.mieszkancy = new ArrayList<>();
    }

    // Metoda do dodawania Smerfów do domu
    public boolean dodajMieszkancow(List<Smerf> smerfy)
    {
        if (mieszkancy.size() + smerfy.size() <= pojemnosc)
        {
            mieszkancy.addAll(smerfy);
            return true;
        } else{
            return false; // Dom jest pełny
        }
    }

    // Metoda do usuwania Smerfów z domu
    public void usunMieszkancow(List<Smerf> smerfy)
    {
        mieszkancy.removeAll(smerfy);
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public List<Smerf> getMieszkancy() {
        return mieszkancy;
    }

    public int liczbaMieszkancow()
    {
        return mieszkancy.size();
    }
}

