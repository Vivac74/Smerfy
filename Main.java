package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanszaWioski plansza = new PlanszaWioski();
            plansza.planszaWioski = plansza;
            plansza.setVisible(true);
        });
    }

}