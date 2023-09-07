package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DodajSmerfaDialog extends JDialog {
    private JTextField imieTextField;
    private JTextField wiekTextField;
    private PlanszaWioski planszaWioski;

    public DodajSmerfaDialog(JFrame parent, PlanszaWioski planszaWioski)
    {
        super(parent, "Dodaj Smerfa", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(3, 2));

        this.planszaWioski = planszaWioski;

        JLabel imieLabel = new JLabel("Imię:");
        imieTextField = new JTextField();

        JLabel wiekLabel = new JLabel("Wiek:");
        wiekTextField = new JTextField();

        JButton dodajButton = new JButton("Dodaj");

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String imie = imieTextField.getText();
                int wiek = Integer.parseInt(wiekTextField.getText());


                dodajSmerfaDoBazyDanych(imie, wiek);

                setVisible(false);
            }
        });

        add(imieLabel);
        add(imieTextField);
        add(wiekLabel);
        add(wiekTextField);
        add(new JLabel());
        add(dodajButton);

        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    private void dodajSmerfaDoBazyDanych(String imie, int wiek) {
        try
        {

            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SmerfyDB", "postgres", "qwerty");

            String sql = "INSERT INTO smurf_statistics (imie, wiek, zdrowie, poziom_glodu, wioska, wytrzymalosc, umiejetnosci_spoleczne, " +
                    "inteligencja, szczescie, sila, zwinnosc, charyzma, gotowanie) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, imie);
            preparedStatement.setInt(2, wiek);

            //  losowe dane dla smerfa
            int zdrowie = (int) (Math.random() * 100);
            int poziomGlodu = (int) (Math.random() * 100);

            preparedStatement.setInt(3, zdrowie);
            preparedStatement.setInt(4, poziomGlodu);

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();

            planszaWioski.dodajDoHistorii("Dodano smerfa do wioski: " + imie);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
