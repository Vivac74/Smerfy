package org.example;

import javax.swing.*;

public class PlanszaJaskini {
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Jaskinia");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(768, 1024);

            ImageIcon icon = new ImageIcon("C:\\Users\\Vivac\\Desktop\\BAZA\\jaskinia.jpg");

            JLabel label = new JLabel(icon);

            frame.getContentPane().add(label);

            frame.setVisible(true);
        });
    }
}
