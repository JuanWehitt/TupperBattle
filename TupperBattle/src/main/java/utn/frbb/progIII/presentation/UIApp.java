package utn.frbb.progIII.presentation;

import utn.frbb.progIII.Logger.Logger;
import utn.frbb.progIII.controller.GameController;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UIApp extends javax.swing.JFrame{

    public static final int ANCHOBOTON = 200;
    static JFrame frame;
    public static UIGeneratingCharacter uiGeneratingCharacter;
    public static UIPartida uiPartida;
    public static JPanel panelMenu;
    public static UILog uiLog;

    public UIApp(){
        frame = new JFrame("TupperBattle");
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(1200, 700);
        frame.setLocationRelativeTo(null);
        uiGeneratingCharacter = new UIGeneratingCharacter();
        uiGeneratingCharacter.crearPanel(frame);
        uiPartida = new UIPartida();
        uiPartida.crearPanel(frame);
        uiLog = new UILog();
        uiLog.crearPanel(frame);
    }

    public JFrame crearVentana() throws IOException {

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
        panelMenu = new JPanel();
        panelMenu.setLayout(null);

        panelMenu.setBounds(frame.getWidth()/2-490/2,230,490,300);
        panelMenu.setBackground(new Color(110, 133, 201));

        JButton buttonNuevoJuego = new JButton("Nuevo Juego");
        buttonNuevoJuego.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,20,ANCHOBOTON,30);
        buttonNuevoJuego.setBackground(Color.WHITE);
        panelMenu.add(buttonNuevoJuego);
        buttonNuevoJuego.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                Logger.logearRegistro("Inicio del Juego rapido "+ dtf.format(LocalDateTime.now()));
                panelMenu.setVisible(false);
                UIApp.uiPartida.registroJugadores();
                JOptionPane.showMessageDialog(null, "Se repartiran las cartas y se sorteará quien comienza",
                        "Repartija", JOptionPane.INFORMATION_MESSAGE);
                GameController.crearPersonajesAleatorio();
                GameController.iniciarJuego();
                UIApp.uiPartida.crearMazoDeCartas();
                UIApp.uiPartida.cargarDatosJuego();
                UIApp.uiPartida.setVisible(true);
            }
        });

        JButton buttonCrearPersonajes = new JButton("Crear Personajes");
        buttonCrearPersonajes.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,60,ANCHOBOTON,30);
        buttonCrearPersonajes.setBackground(Color.WHITE);
        panelMenu.add(buttonCrearPersonajes);
        buttonCrearPersonajes.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                Logger.logearRegistro("Inicio del Juego creando los personajes "+ dtf.format(LocalDateTime.now()));
                panelMenu.setVisible(false);
                uiGeneratingCharacter.setVisible(true);
                uiGeneratingCharacter.mostrarPersonaje(GameController.obtenerPersonaje(1));
                //UIGeneratingCharacter.showPaneGeneratingCharacter(frame);
            }

        });

        JButton buttonVerLog = new JButton("Ver Log");
        buttonVerLog.setBounds(panelMenu.getWidth()/2-ANCHOBOTON/2,100,ANCHOBOTON,30);
        buttonVerLog.setBackground(Color.WHITE);
        buttonVerLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelMenu.setVisible(false);
                uiLog.setVisible(true);
                uiLog.cargarArchivoLog();
            }
        });
        panelMenu.add(buttonVerLog);
        //
        frame.getContentPane().add(panelMenu);
        //frame.add(buttonNuevoJuego);
        frame.add(panelLogo);
        return frame;
    }

    public static  void repintar(){
        frame.repaint();
    }

    public static void visible(boolean val){
        panelMenu.setVisible(true);
    }
}
