package utn.frbb.progIII.presentation;

import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;

public class UICaracteristicas extends JPanel{

    private JLabel labelVelocidad;
    private JLabel labelDestreza;
    private JLabel labelFuerza;
    private JLabel labelArmadura;
    private JLabel labelNivel;

    public void UICaracteristicas(){
        labelVelocidad = new JLabel();
        labelDestreza = new JLabel();
        labelFuerza = new JLabel();
        labelArmadura = new JLabel();
        labelNivel = new JLabel();

    }
    public void setCaracteristicas(Personaje p){
        labelVelocidad.setText(String.valueOf(p.getCaracteristicas().getVelocidad()));
        labelDestreza.setText(String.valueOf(p.getCaracteristicas().getDestreza()));
        labelFuerza.setText(String.valueOf(p.getCaracteristicas().getFuerza()));
        labelArmadura.setText(String.valueOf(p.getCaracteristicas().getArmadura()));
        labelNivel.setText(String.valueOf(p.getCaracteristicas().getNivel()));
    }


}
