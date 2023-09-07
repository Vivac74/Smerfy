package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BD {
    private static final String URL = "jdbc:postgresql://localhost:5432/SmerfyDB";
    private static final String UZYTKOWNIK = "postgres";
    private static final String HASLO = "qwerty";

    public static void dodajSmerfa(String imie, int wiek) {
        String zapytanieSQL = "INSERT INTO smurf_statistics (imie, wiek, zdrowie, poziom_glodu, wioska, wytrzymalosc, umiejetnosci_spoleczne, " +
                "inteligencja, szczescie, sila, zwinnosc, charyzma, gotowanie) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, UZYTKOWNIK, HASLO);
             PreparedStatement stmt = conn.prepareStatement(zapytanieSQL)) {


            int zdrowie = (int) (Math.random() * 100);
            int poziomGlodu = (int) (Math.random() * 100);
            int wioska = (int) (Math.random() * 10);
            int wytrzymalosc = (int) (Math.random() * 100);
            int umiejetnosciSpoleczne = (int) (Math.random() * 100);
            int inteligencja = (int) (Math.random() * 100);
            int szczescie = (int) (Math.random() * 100);
            int sila = (int) (Math.random() * 100);
            int zwinnosc = (int) (Math.random() * 100);
            int charyzma = (int) (Math.random() * 100);
            int gotowanie = (int) (Math.random() * 100);

            stmt.setString(1, imie);
            stmt.setInt(2, wiek);
            stmt.setInt(3, zdrowie);
            stmt.setInt(4, poziomGlodu);
            stmt.setInt(5, wioska);
            stmt.setInt(6, wytrzymalosc);
            stmt.setInt(7, umiejetnosciSpoleczne);
            stmt.setInt(8, inteligencja);
            stmt.setInt(9, szczescie);
            stmt.setInt(10, sila);
            stmt.setInt(11, zwinnosc);
            stmt.setInt(12, charyzma);
            stmt.setInt(13, gotowanie);

            stmt.executeUpdate();
            System.out.println("Dodano nowego smerfa do bazy danych.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Błąd podczas dodawania smerfa do bazy danych.");
        }
    }
}
