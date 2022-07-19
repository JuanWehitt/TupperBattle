package utn.frbb.progIII.presentation;

import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;

public class UICarta extends JPanel {

    private Jugador jugador;
    private Personaje personaje;

    public void UICarta(Jugador jugador, Personaje personaje, JFrame frame){
        this.jugador = jugador;
        this.personaje = personaje;

        JPanel panelCarta = new JPanel();
        panelCarta.setBounds(0,0,0,0);
    }







}
