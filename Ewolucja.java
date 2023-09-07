package org.example;

import java.util.List;

public class Ewolucja {
    public static void zarzadzajEwolucja(List<Smerf> smerfy) {
        for (Smerf smerf : smerfy) {
            smerf.ewoluuj();
        }
    }
}

