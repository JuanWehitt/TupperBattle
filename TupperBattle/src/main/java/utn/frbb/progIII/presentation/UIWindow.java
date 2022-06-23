package utn.frbb.progIII.presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UIWindow extends javax.swing.JFrame{

    private static final int ANCHOBOTON = 200;

    public UIWindow(){

    }

    public void crearVentana() throws IOException {
        JFrame frame = new JFrame("TupperBattle");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        //frame.setBackground(Color.black);

        JPanel panelLogo = new JPanel();
        panelLogo.setBackground(new Color(0, 0, 0));
        panelLogo.setSize(new Dimension(1200, 700));
        panelLogo.setLayout(null);
        //LoadingScreen.cargarLoadingEn(panelLogo);
        //System.out.println(System.getProperty("user.dir"));
        //imagen del logo del juego
        File file = new File("TupperBattle/images/logoTupperBattle.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        JLabel logoLabel = new JLabel(imageIcon);//240 x
        logoLabel.setBounds(frame.getWidth()/2-350,30,700,200);
        logoLabel.setBackground(new Color(255, 0, 0));
        panelLogo.add(logoLabel);
        //
        //menu de inicio
        JPanel panelMenu = new JPanel();
        panelMenu.setLayout(null);

        panelMenu.setBounds(frame.getWidth()/2-490/2,230,490,300);
        panelMenu.setBackground(new Color(110, 133, 201));

        JButton buttonNuevoJuego = new JButton("Nuevo Juego");
        buttonNuevoJuego.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,20,ANCHOBOTON,30);
        buttonNuevoJuego.setBackground(Color.WHITE);
        panelMenu.add(buttonNuevoJuego);

        JButton buttonCrearPersonajes = new JButton("Crear Personajes");
        buttonCrearPersonajes.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,60,ANCHOBOTON,30);
        buttonCrearPersonajes.setBackground(Color.WHITE);
        panelMenu.add(buttonCrearPersonajes);

        JButton buttonVerLog = new JButton("Ver Log");
        buttonVerLog.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,100,ANCHOBOTON,30);
        buttonVerLog.setBackground(Color.WHITE);
        panelMenu.add(buttonVerLog);
        //
        frame.getContentPane().add( panelMenu);
        //frame.add(buttonNuevoJuego);
        frame.add(panelLogo);

    }
}
