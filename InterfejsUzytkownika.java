package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfejsUzytkownika
{

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Wioska Smerfów");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            JButton dodajSmerfaButton = new JButton("Dodaj Smerfa");
            JButton generujStatystykiButton = new JButton("Generuj Statystyki");
            JButton symulujAktywnosciButton = new JButton("Symuluj Aktywności");

            panel.add(dodajSmerfaButton);
            panel.add(generujStatystykiButton);
            panel.add(symulujAktywnosciButton);

            dodajSmerfaButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementacja dodawania nowego Smerfa
                }
            });

            generujStatystykiButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementacja generowania statystyk
                }
            });

            symulujAktywnosciButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Implementacja symulowania aktywności Smerfów
                }
            });

            frame.add(panel);
            frame.setSize(400, 200);
            frame.setVisible(true);
        });
    }
}
