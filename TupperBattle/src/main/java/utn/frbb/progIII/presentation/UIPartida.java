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
import java.util.Collections;
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
    private List<UICarta> listaDeCartasMazo;
    private List<UICarta> listaDeCartasJ1;
    private List<UICarta> listaDeCartasJ2;
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
        panelPartida.add(caracteristicasDer);
        panelPartida.add(caracteristicasIzq);
        //imprimirCartas(panelPartida);

        frame.add(panelPartida);

    }

    private void clickEnAtacar(){
        Jugador atacante = GameController.getJugadorDeTurno();
        Jugador oponente = GameController.getJugadorEnEspera();
        int leSaco = GameController.atacarAlOponente();
        labelLog.setText("El "+atacante.getPersonajeEnRonda().getApodo() + " le sacó "+ leSaco + " de vida a el "+ oponente.getPersonajeEnRonda().getApodo());

        barraJugador1.setValue(jugador1.getPersonajeEnRonda().getSalud());
        barraJugador2.setValue(jugador2.getPersonajeEnRonda().getSalud());
        GameController.actualizarNumeroDeAtaques();

        if (GameController.esFinDeRonda()){
            GameController.finalizarRonda();
            Personaje pGanador,pPerdedor;
            Jugador jGanador,jPerdedor;
            jGanador = GameController.getGanadorDeRonda();
            jPerdedor = GameController.getPerdedorDeRonda();
            pGanador = jGanador.getPersonajeEnRonda();
            pPerdedor = jPerdedor.getPersonajeEnRonda();
            System.out.println("Finalizo la ronda, gano "+jGanador.getNombre()+ " con "+pGanador.getNombre());
            System.out.println("");

            JOptionPane.showMessageDialog(null,
                    "Ganó "+jGanador.getNombre()+ " con "+pGanador.getNombre(),
                    "Fin de la ronda", JOptionPane.INFORMATION_MESSAGE);
            if (oponente.getPersonajeEnRonda().isMuerto()){
                JOptionPane.showMessageDialog(null,
                        oponente.getNombre()+ "... tu personaje el "+oponente.getPersonajeEnRonda().getApodo()+" murio.",
                        "Se murio", JOptionPane.INFORMATION_MESSAGE);
            }
            labelLog.setText(jGanador.getNombre()+" gano con el personaje "+pGanador.getNombre()+" y gano "+GameController.VIDAEXTRAALGANAR +" de vida");
            if (GameController.esFinDeLaPartida()) {
                GameController.finalizarPartida();
                //preguntar si se quiere comenzar de nuevo otra partida. con las vidas en 100 y los mismos personajes creados.
                JOptionPane.showMessageDialog(null,
                        "GANASTE "+jGanador.getNombre().toUpperCase()+"!!!!",
                        "Fin de la Partida", JOptionPane.INFORMATION_MESSAGE);
                labelLog.setText("GANO "+GameController.getGanadorDePartida().getNombre().toUpperCase()+ " !!!");
                int respuest = JOptionPane.showConfirmDialog(panelPartida,
                        "Jugamos otra? Se repartiran los personajes de nuevo.",
                        "Juguemos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (respuest==JOptionPane.YES_OPTION){
                    registroJugadores();
                    GameController.iniciarJuego();
                    cargarDatosJuego();
                }else{
                    panelPartida.setVisible(false);
                    UIMenu.visible(true);
                }
            }else {
                GameController.nuevaRonda();
                //cartel de se sortearan los opnentes.
                JOptionPane.showMessageDialog(null,
                        "Se sortearan los oponentes para la siguiente ronda",
                        "Siguiente ronda", JOptionPane.INFORMATION_MESSAGE);
                //sortear los oponentes.
                GameController.iniciarJuego();
                cargarDatosJuego();
                labelLog.setText("Juegan "+jGanador.getPersonajeEnRonda().getApodo()+
                        " contra "+jPerdedor.getPersonajeEnRonda().getApodo()+
                        ". Comienza "+jPerdedor.getNombre());
            }
        }else {

            if(jugador1.getPersonajeEnRonda().getAtaqueNro()<=GameController.CANTIDADDEATAQUESPORJUGADOR) {
                labelNroDeAtaqueJugador1.setText(jugador1.getPersonajeEnRonda().getAtaqueNro() + " de " + GameController.CANTIDADDEATAQUESPORJUGADOR);
            }
            if(jugador2.getPersonajeEnRonda().getAtaqueNro()<=GameController.CANTIDADDEATAQUESPORJUGADOR) {
                labelNroDeAtaqueJugador2.setText(jugador2.getPersonajeEnRonda().getAtaqueNro() + " de " + GameController.CANTIDADDEATAQUESPORJUGADOR);
            }

            if (GameController.getJugadorDeTurno() == jugador1) {
                GameController.setJugadorDeTurno(jugador2);
                GameController.setJugadorEnEspera(jugador1);
                botonAtacar.setBounds(435, 230, 120, 30);
                botonAtacar.setText("<<< Atacarr!!");
            } else {
                GameController.setJugadorDeTurno(jugador1);
                GameController.setJugadorEnEspera(jugador2);
                botonAtacar.setBounds(250, 230, 120, 30);
                botonAtacar.setText("Atacarr!! >>>");
            }
        }
        UIMenu.repintar();
    }

    private void repartirLasCartas() {
        listaDeCartasJ1 = new ArrayList<>(GameController.CANTIDADDEPERSONAJESPORJUGADOR);
        listaDeCartasJ2 = new ArrayList<>(GameController.CANTIDADDEPERSONAJESPORJUGADOR);
        for (UICarta carta : listaDeCartasMazo) {
            if (jugador1.tieneAlPersonaje(carta.getPersonaje())) {
                listaDeCartasJ1.add(carta);
                carta.setLado(GameController.LADOIZQUIERDO);
                carta.setJugador(jugador1);
            }else{
                listaDeCartasJ2.add(carta);
                carta.setLado(GameController.LADODERECHO);
                carta.setJugador(jugador2);
            }
        }
    }

    public void crearMazoDeCartas(){
        listaDeCartasMazo = new ArrayList<>(GameController.CANTIDADDEPERSONAJESPORJUGADOR*2);
        UICarta carta;
        for (int i=1; i<=GameController.CANTIDADDEPERSONAJESPORJUGADOR*2; i++){
            listaDeCartasMazo.add(new UICarta());
            carta = listaDeCartasMazo.get(listaDeCartasMazo.size()-1);
            carta.setNumero(i);
            carta.setPersonaje(GameController.obtenerPersonaje(i));
            carta.setLayout(null);
            carta.setBounds(0,0,120,170);
            carta.crearImagenCarta();
            panelPartida.add(carta);
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
                GameController.crearPartida(nombre1,nombre2);
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

        repartirLasCartas();
        posicionarCartasDeJugador();

        caracteristicasIzq.setCaracteristicas(jugador1.getPersonajeEnRonda());
        caracteristicasDer.setCaracteristicas(jugador2.getPersonajeEnRonda());
        caracteristicasDer.ubicarCaracteristicas(GameController.LADODERECHO);
        caracteristicasIzq.ubicarCaracteristicas(GameController.LADOIZQUIERDO);
        if(GameController.getJugadorDeTurno()==jugador1){
            botonAtacar.setBounds(250, 230, 120,30);
            botonAtacar.setText("Atacarr!! >>>");
        }else{
            botonAtacar.setBounds(440, 230, 120,30);
            botonAtacar.setText("<<< Atacarr!!");
        }
        labelRonda.setText(Integer.toString(GameController.getRonda()));
        labelNroDeAtaqueJugador1.setText("1 de "+GameController.CANTIDADDEATAQUESPORJUGADOR);
        labelNroDeAtaqueJugador2.setText("1 de "+GameController.CANTIDADDEATAQUESPORJUGADOR);
        labelLog.setText("Juegan "+GameController.getJugadorDeTurno().getPersonajeEnRonda().getApodo()+
                " contra "+GameController.getJugadorEnEspera().getPersonajeEnRonda().getApodo()+
                ". Comienza "+GameController.getJugadorDeTurno().getNombre());

    }



    private void ordenarLista(List<UICarta> listaAordenar, List<UICarta> lista) {
        for (UICarta cartaa : listaAordenar) {
            if (cartaa.getPersonaje() == cartaa.getJugador().getPersonajeEnRonda()) {
                lista.add(cartaa);
            }
        }
        for (UICarta cartaa : listaAordenar) {
            if (!cartaa.getPersonaje().isMuerto() && cartaa.getPersonaje() != cartaa.getJugador().getPersonajeEnRonda()) {
                lista.add(cartaa);
            }
        }
        for (UICarta cartaa : listaAordenar) {
            if (cartaa.getPersonaje().isMuerto()) {
                lista.add(cartaa);
            }
        }
    }

    private void posicionarCartasDeJugador() {
        List<UICarta> listaOrdenadaj1 = new ArrayList<>();
        List<UICarta> listaOrdenadaj2 = new ArrayList<>();
        ordenarLista(listaDeCartasJ1,listaOrdenadaj1);
        ordenarLista(listaDeCartasJ2,listaOrdenadaj2);
        listaDeCartasJ1 = listaOrdenadaj1;
        listaDeCartasJ2 = listaOrdenadaj2;

        int i = 1;
        for (UICarta carta1 : listaDeCartasJ1){
            carta1.setBounds(160 - (i*20), 185 - (i*20), 120, 170);
            Container parent = carta1.getParent();
            parent.setComponentZOrder(carta1,i);
            i++;
        }
        i = 1;
        for (UICarta carta2 : listaDeCartasJ2){
            carta2.setBounds(520+(i*20),185-(i*20),120,170);
            Container parent = carta2.getParent();
            parent.setComponentZOrder(carta2,i);
            i++;
        }

    }


}
