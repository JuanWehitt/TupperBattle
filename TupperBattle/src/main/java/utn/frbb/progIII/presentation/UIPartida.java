package utn.frbb.progIII.presentation;

import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class UIPartida extends JPanel{


    private Jugador jugador1;
    private Jugador jugador2;

    private JProgressBar barraJugador1;
    private JProgressBar barraJugador2;
    private JLabel labelJugador1;
    private JLabel labelJugador2;
    private JLabel labelVidaJugador1;
    private JLabel labelVidaJugador2;



    private JPanel panelPartida;

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
        barraJugador1.setBorder(null);
        panelPartida.add(barraJugador1);

        labelVidaJugador1 = new JLabel(Integer.toString(barraJugador1.getValue()));
        labelVidaJugador1.setBounds(40,65,100,20);
        panelPartida.add(labelVidaJugador1);

        labelJugador2 = new JLabel("Jugador 2",SwingConstants.RIGHT);
        labelJugador2.setBounds(560,20,200,20);
        panelPartida.add(labelJugador2);

        barraJugador2 = new JProgressBar(0,100){

                protected void paintComponent(Graphics grafico) {

                Graphics2D graficoNuevo = (Graphics2D) grafico;

                graficoNuevo.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON
                );

                AffineTransform at = graficoNuevo.getTransform();
                Shape figura = graficoNuevo.getClip();

                double X = getWidth() / 2.0;
                double Y = getHeight() / 2.0;

                at.rotate(Math.toRadians(180), X, Y);

                graficoNuevo.setTransform(at);
                graficoNuevo.setClip(figura);

                super.paintComponent(grafico);
            }

            };

        barraJugador2.setBounds(470,40,300,20);
        barraJugador2.setValue(50);
        barraJugador2.setBorder(null);
        panelPartida.add(barraJugador2);

        labelVidaJugador2 = new JLabel(Integer.toString(barraJugador2.getValue()),SwingConstants.RIGHT);
        labelVidaJugador2.setBounds(560,65,200,20);
        panelPartida.add(labelVidaJugador2);

        JButton botonAtacarJugador1 = new JButton("Atacarr!!");
        botonAtacarJugador1.setBounds(100, 400, 100,30);
        panelPartida.add(botonAtacarJugador1);

        JButton botonAtacarJugador2 = new JButton("Atacarr!!");
        botonAtacarJugador2.setBounds(600, 400, 100,30);
        panelPartida.add(botonAtacarJugador2);

        frame.add(panelPartida);


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

    }



}
