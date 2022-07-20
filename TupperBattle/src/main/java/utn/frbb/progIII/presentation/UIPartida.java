package utn.frbb.progIII.presentation;

import jdk.internal.jimage.ImageStrings;
import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.List;

public class UIPartida extends JPanel{


    private Jugador jugador1;
    private Jugador jugador2;

    private JProgressBar barraJugador1;
    private JProgressBar barraJugador2;
    private JLabel labelJugador1;
    private JLabel labelJugador2;
    private JLabel labelVidaJugador1;
    private JLabel labelVidaJugador2;
    private List<UICarta> listaDeCartas;


    private JPanel panelPartida;
    private List<UICaracteristicas> listaDeCaracteristicas;

    public void setVisible(boolean val){
        panelPartida.setVisible(val);
    }

    public void UIPartida(){
    }

    public void crearPanel(JFrame frame){

        panelPartida = new JPanel();
        panelPartida.setLayout(null);
//
        panelPartida.setBounds(frame.getWidth()/2-800/2,100,800,500);
        panelPartida.setBackground(new Color(183, 227, 183));
        panelPartida.setVisible(false);

        labelJugador1 = new JLabel("Jugador 1");
        labelJugador1.setBounds(40,20,200,20);
        panelPartida.add(labelJugador1);

        barraJugador1 = new JProgressBar(0,100);
        barraJugador1.setBounds(30,40,300,20);
        barraJugador1.setValue(90);
        barraJugador1.setBorder(new LineBorder(Color.BLUE));
        barraJugador1.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelVidaJugador1.setText(String.valueOf(barraJugador1.getValue()));
            }
        });
        panelPartida.add(barraJugador1);

        labelVidaJugador1 = new JLabel(Integer.toString(barraJugador1.getValue()));
        labelVidaJugador1.setBounds(40,65,100,20);
        panelPartida.add(labelVidaJugador1);

        labelJugador2 = new JLabel("Jugador 2",SwingConstants.RIGHT);
        labelJugador2.setBounds(560,20,200,20);
        panelPartida.add(labelJugador2);

        barraJugador2 = new JProgressBar(0,100);
        barraJugador2.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        barraJugador2.setBounds(470,40,300,20);
        barraJugador2.setValue(50);
        barraJugador2.setBorder(new LineBorder(Color.BLUE));
        barraJugador2.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                labelVidaJugador2.setText(String.valueOf(barraJugador2.getValue()));
            }
        });
        panelPartida.add(barraJugador2);

        labelVidaJugador2 = new JLabel(Integer.toString(barraJugador2.getValue()),SwingConstants.RIGHT);
        labelVidaJugador2.setBounds(560,65,200,20);
        panelPartida.add(labelVidaJugador2);

        JButton botonAtacar = new JButton("Atacarr!!");
        botonAtacar.setBounds(100, 400, 100,30);
        botonAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //barraJugador2.setValue(30);
            }
        });
        panelPartida.add(botonAtacar);

        imprimirCartas(panelPartida);

        frame.add(panelPartida);

    }

    public void imprimirCartas(JPanel panel){
        listaDeCartas = new ArrayList<UICarta>();
        UICaracteristicas caracteristicas;
        //TODO: VER Panel con capas (jLayeredPane):  un contenedor que permite a sus componentes especificar su profundidad y superpponerse uno al otro cuando se necesite.
        for (int i=1; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR*2; i++){
            if(i<=3) {
                UICarta carta;
                listaDeCartas.add(new UICarta());
                carta = listaDeCartas.get(listaDeCartas.size()-1);
                carta.setBounds(100+(i*20),125+(i*20),120,170);
                carta.setLado(0);
                //TODO: IMPRIMIR LAS CARACTERISTICAS CORRESPONDIENTES A LA uicARTA CARTA
                panel.add(carta);
            }else{
                UICarta carta;
                listaDeCartas.add(new UICarta());
                carta = listaDeCartas.get(listaDeCartas.size()-1);
                carta.setBounds(580-((i-3)*20),125+((i-3)*20),120,170);
                carta.setLado(1);
                //TODO: IMPRIMIR LAS CARACTERISTICAS CORRESPONDIENTES A LA uicARTA CARTA
                panel.add(carta);
            }
        }
    }

    public void registroJugadores(){
        String nombre1 = JOptionPane.showInputDialog(null, "Ingresa tu nombre!",
                "Jugadores", JOptionPane.QUESTION_MESSAGE);
        if( nombre1==null ){
            UIMenu.windowGeneratingCharacter.setVisible(true);
        }else {
            String nombre2 = JOptionPane.showInputDialog(null, "Ingresa el nombre de tu oponente!",
                    "Jugadores", JOptionPane.QUESTION_MESSAGE);
            if ( nombre2 == null){
                UIMenu.windowGeneratingCharacter.setVisible(true);
            } else {
                GameController.crearLaPartida(nombre1,nombre2);
                JOptionPane.showMessageDialog(null, "Se repartiran las cartas",
                        "Repartija", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

    public void cargarDatosJuego(){
        //trae del game controler los datos como nombres de jugadores, inicia las vidas..
        Jugador j1 = GameController.getJugador(1,GameController.getNroPartida());

        labelJugador1.setText(j1.getNombre() + " con el "+j1.getPersonajeEnRonda().getApodo());
        barraJugador1.setValue(j1.getPersonajeEnRonda().getSalud());
        labelVidaJugador1.setText(Integer.toString(j1.getPersonajeEnRonda().getSalud()));

        Jugador j2 = GameController.getJugador(2,GameController.getNroPartida());
        labelJugador2.setText(j2.getNombre() + " con el "+j2.getPersonajeEnRonda().getApodo());
        barraJugador2.setValue(j2.getPersonajeEnRonda().getSalud());
        labelVidaJugador2.setText(Integer.toString(j2.getPersonajeEnRonda().getSalud()));

        UICarta carta;

        for (int i=1; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR; i++){
            carta = listaDeCartas.get(i-1);
            carta.setJugador(j1);
            carta.setPersonaje(j1.getPersonaje(i-1));
            //TODO: CARGAR LAS CARACTERISTICAS DE CADA PERSONAJE.
        }
        for (int i=4; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR; i++){
            carta = listaDeCartas.get(i-1);
            carta.setJugador(j2);
            carta.setPersonaje(j2.getPersonaje(i-1));
            //TODO: CARGAR LAS CARACTERISTICAS DE CADA PERSONAJE.
        }


    }



}
