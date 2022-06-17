package utn.frbb.progIII.presentation;

import javax.swing.*;
import java.awt.*;

public class UIWindow extends javax.swing.JFrame{

    public UIWindow(){

    }

    public void crearVentana(){
        JFrame frame = new JFrame("TupperBattle");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        ImageIcon icono = new ImageIcon("resources/parentesisIcono.png");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setSize(new Dimension(1200, 700));
        panel.setLayout(null);

        frame.add(panel);
    }
}
