package org.example;

import javax.swing.*;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlanszaWioski extends JFrame implements KeyListener {

    public PlanszaWioski planszaWioski;
    private int liczbaSmerfow = 0;
    private JTextArea historiaTextArea;
    private JLabel legendaLabel;

    public PlanszaWioski() {
        setTitle("Wioska Smerfów");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(768, 1024);
        addKeyListener(this);
        setFocusable(true);

        ImageIcon wioska = new ImageIcon("C:\\Users\\Vivac\\Desktop\\BAZA\\wioska.jpg");

        JLabel label = new JLabel(wioska);

        getContentPane().add(label);

        historiaTextArea = new JTextArea(5, 20);
        historiaTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(historiaTextArea);
        getContentPane().add(scrollPane, BorderLayout.SOUTH);

        DefaultCaret caret = (DefaultCaret) historiaTextArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        // Legenda na samym dole
        legendaLabel = new JLabel("Legenda: 1 - Dodaj Smerfa, 2 - Usuń Smerfa, 3 - Pokaż Statystyki");
        getContentPane().add(legendaLabel, BorderLayout.PAGE_END);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PlanszaWioski plansza = new PlanszaWioski();
            plansza.setVisible(true);
        });
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Obsługa klawiszy 1, 2, 3
        if (key == KeyEvent.VK_1) {
            DodajSmerfaDialog dialog = new DodajSmerfaDialog(this, planszaWioski);
            dialog.setVisible(true);
        } else if (key == KeyEvent.VK_2) {
            usunSmerfa();
        } else if (key == KeyEvent.VK_3) {
            pokazStatystyki();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    private void usunSmerfa()
    {
        if (liczbaSmerfow > 0) {
            liczbaSmerfow--;
            dodajDoHistorii("Usunięto smerfa. Liczba smerfów: " + liczbaSmerfow);
        } else {
            dodajDoHistorii("Brak smerfów do usunięcia.");
        }
    }

    private void pokazStatystyki()
    {
        //niedokończone
        dodajDoHistorii("Statystyki smerfów:");
        dodajDoHistorii("Liczba smerfów: " + liczbaSmerfow);
    }

    public void dodajDoHistorii(String tekst) {
        historiaTextArea.append(tekst + "\n");
    }
}
