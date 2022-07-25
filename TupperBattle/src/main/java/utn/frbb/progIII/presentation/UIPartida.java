package utn.frbb.progIII.presentation;


import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    private UICaracteristicas caracteristicasIzq, caracteristicasDer;
    private JButton botonAtacar;
    private JPanel panelPartida;
    private JLabel labelLog;
    private JLabel labelRonda;
    private JLabel labelNroDeAtaqueJugador1, labelNroDeAtaqueJugador2;


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

        botonAtacar = new JButton("Atacarr!! >>>");
        botonAtacar.setBounds(260, 230, 100,30);
        botonAtacar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clickEnAtacar();
            }
        });
        panelPartida.add(botonAtacar);
        labelLog = new JLabel("",SwingConstants.CENTER);
        labelLog.setBackground(new Color(0,0,0,0));
        labelLog.setBounds(0,470,800,30);

        labelLog.setText("HOLA");
        panelPartida.add(labelLog);

        Border line = BorderFactory.createLineBorder(Color.BLUE, 0);

        labelRonda = new JLabel("1",SwingConstants.CENTER);
        labelRonda.setBackground(new Color(0,0,0,0));
        labelRonda.setBounds(0,30,800,45);
        labelRonda.setFont(new Font("SansSerif",Font.BOLD,35));
        labelRonda.setBorder(BorderFactory.createTitledBorder(line, "RONDA", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        panelPartida.add(labelRonda);

        labelNroDeAtaqueJugador1 = new JLabel("1 de 7",SwingConstants.CENTER);
        labelNroDeAtaqueJugador1.setBackground(new Color(0,0,0,0));
        labelNroDeAtaqueJugador1.setBounds(180,350,80,30);
        labelNroDeAtaqueJugador1.setBorder(BorderFactory.createTitledBorder(line, "ATAQUE", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        panelPartida.add(labelNroDeAtaqueJugador1);

        labelNroDeAtaqueJugador2 = new JLabel("1 de 7",SwingConstants.CENTER);
        labelNroDeAtaqueJugador2.setBackground(new Color(0,0,0,0));
        labelNroDeAtaqueJugador2.setBounds(570,350,80,30);
        labelNroDeAtaqueJugador2.setBorder(BorderFactory.createTitledBorder(line, "ATAQUE", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        panelPartida.add(labelNroDeAtaqueJugador2);


        imprimirCartas(panelPartida);

        frame.add(panelPartida);

    }

    private void clickEnAtacar(){
        Jugador atacante = GameController.getJugadorDeTurno();
        Jugador oponente = GameController.getJugadorEnEspera();
        int leSaco = GameController.atacarAlOponente();
        labelLog.setText("El "+atacante.getPersonajeEnRonda().getApodo() + " le sacó "+ leSaco + " de vida a el "+ oponente.getPersonajeEnRonda().getApodo());

        barraJugador1.setValue(jugador1.getPersonajeEnRonda().getSalud());
        barraJugador2.setValue(jugador2.getPersonajeEnRonda().getSalud());
        //cartel con thread restando en rojo la vida que le saco.
        if (GameController.esFinDeRonda()){
            GameController.finalizarRonda();
            //cartel del ganador de la ronda, por muerte o por completar los 7 ataques.
            JOptionPane.showMessageDialog(null,
                    "Ganó "+GameController.getJugadorGanador().getNombre()+ " con "+GameController.getJugadorGanador().getPersonajeEnRonda().getNombre(),
                    "Fin de la ronda", JOptionPane.INFORMATION_MESSAGE);
            labelLog.setText(GameController.getJugadorGanador().getNombre()+" gano con el personaje "+GameController.getJugadorGanador().getPersonajeEnRonda().getNombre()+" y gano +20 de vida");

            //cartel de se sortearan los opnentes.
            JOptionPane.showMessageDialog(null,
                    "Se sortearan los oponentes para la siguiente ronda",
                    "Siguiente ronda", JOptionPane.INFORMATION_MESSAGE);
            //sortear los oponentes.
            // TODO: VERIFICAR SI TIENE PERSONAJES VIVOS..sortearPersonajeDeJugador RETORNA NULL SI NO HAY VIVOS..
            GameController.sortearPersonajeDeJugador(jugador1);
            GameController.sortearPersonajeDeJugador(jugador2);
            // TODO: CORREGIR LAS 2 LINEAS DE ARRIBA
            GameController.setRonda(GameController.getRonda()+1);
            labelRonda.setText(Integer.toString(GameController.getRonda()));
        }else{
            GameController.actualizarNumeroDeAtaques();
            labelNroDeAtaqueJugador1.setText(jugador1.getPersonajeEnRonda().getAtaqueNro()+" de "+GameController.CANTIDADDEATAQUESPORJUGADOR);
            labelNroDeAtaqueJugador2.setText(jugador2.getPersonajeEnRonda().getAtaqueNro()+" de "+GameController.CANTIDADDEATAQUESPORJUGADOR);
        }
        if(GameController.esFinDeLaPartida()){
            GameController.setRonda(1);
            labelRonda.setText("1");
            //preguntar si se quiere comenzar de nuevo otra partida. con las vidas en 100 y los mismos personajes creados.
        }

        if(GameController.getJugadorDeTurno()==jugador1){
            GameController.setJugadorDeTurno(jugador2);
            GameController.setJugadorEnEspera(jugador1);
            botonAtacar.setBounds(435, 230, 120,30);
            botonAtacar.setText("<<< Atacarr!!");
        }else{
            GameController.setJugadorDeTurno(jugador1);
            GameController.setJugadorEnEspera(jugador2);
            botonAtacar.setBounds(250, 230, 120,30);
            botonAtacar.setText("Atacarr!! >>>");
        }
    }

    public void imprimirCartas(JPanel panel){
        listaDeCartas = new ArrayList<UICarta>();
        //TODO: VER Panel con capas (jLayeredPane):  un contenedor que permite a sus componentes especificar su profundidad y superpponerse uno al otro cuando se necesite.
        for (int i=1; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR*2; i++){
            if(i<=3) {
                UICarta carta;
                listaDeCartas.add(0,new UICarta());
                carta = listaDeCartas.get(0);
                carta.setBounds(160-(i*20),185-(i*20),120,170);
                carta.setLado(GameController.LADODIZQUIERDO);
                carta.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
                panel.add(carta);
            }else{
                UICarta carta;
                listaDeCartas.add(0,new UICarta());
                carta = listaDeCartas.get(0);
                carta.setBounds(520+((i-3)*20),185-((i-3)*20),120,170);
                carta.setLado(GameController.LADODERECHO);
                carta.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));
                panel.add(carta);
            }
            caracteristicasDer = new UICaracteristicas();
            caracteristicasIzq = new UICaracteristicas();
            caracteristicasDer.setLayout(null);
            caracteristicasIzq.setLayout(null);
            caracteristicasIzq.setBounds(0,0,400,500);
            caracteristicasDer.setBounds(400,0,400,500);
            caracteristicasIzq.crearComponentesUICaracteristicas();
            caracteristicasDer.crearComponentesUICaracteristicas();

            caracteristicasDer.setBackground(new Color(0,0,0,0));
            caracteristicasIzq.setBackground(new Color(0,0,0,0));
            //caracteristicasDer.setBorder(new LineBorder(Color.BLUE,3));
            //caracteristicasIzq.setBorder(new LineBorder(Color.BLUE,3));
            panel.add(caracteristicasDer);
            panel.add(caracteristicasIzq);
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
        jugador1 = GameController.getJugador(1,GameController.getNroPartida());

        labelJugador1.setText(jugador1.getNombre() + " con el "+jugador1.getPersonajeEnRonda().getApodo());
        barraJugador1.setValue(jugador1.getPersonajeEnRonda().getSalud());
        labelVidaJugador1.setText(Integer.toString(jugador1.getPersonajeEnRonda().getSalud()));

        jugador2 = GameController.getJugador(2,GameController.getNroPartida());
        labelJugador2.setText(jugador2.getNombre() + " con el "+jugador2.getPersonajeEnRonda().getApodo());
        barraJugador2.setValue(jugador2.getPersonajeEnRonda().getSalud());
        labelVidaJugador2.setText(Integer.toString(jugador2.getPersonajeEnRonda().getSalud()));

        UICarta carta;

        for (int i=1; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR; i++){
            carta = listaDeCartas.get(i-1);
            carta.setJugador(jugador1);
            carta.setPersonaje(jugador1.getPersonaje(i-1));
        }
        for (int i=4; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR; i++){
            carta = listaDeCartas.get(i-1);
            carta.setJugador(jugador2);
            carta.setPersonaje(jugador2.getPersonaje(i-1));
        }

        caracteristicasIzq.setCaracteristicas(jugador1.getPersonajeEnRonda());
        caracteristicasDer.setCaracteristicas(jugador2.getPersonajeEnRonda());
        caracteristicasDer.ubicarCaracteristicas(GameController.LADODERECHO);
        caracteristicasIzq.ubicarCaracteristicas(GameController.LADODIZQUIERDO);
        if(GameController.getJugadorDeTurno()==jugador1){
            botonAtacar.setBounds(250, 230, 120,30);
            botonAtacar.setText("Atacarr!! >>>");
        }else{
            botonAtacar.setBounds(440, 230, 120,30);
            botonAtacar.setText("<<< Atacarr!!");
        }
        labelRonda.setText("1");
    }



}
