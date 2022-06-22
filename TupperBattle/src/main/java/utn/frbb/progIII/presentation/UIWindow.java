package utn.frbb.progIII.presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UIWindow extends javax.swing.JFrame{

    public UIWindow(){

    }

    public void crearVentana() throws IOException {
        JFrame frame = new JFrame("TupperBattle");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(0, 0, 0));
        panel.setSize(new Dimension(1200, 700));
        panel.setLayout(null);
        LoadingScreen.cargarLoadingEn(panel);
        //System.out.println(System.getProperty("user.dir"));
        frame.add(panel);
    }
}
