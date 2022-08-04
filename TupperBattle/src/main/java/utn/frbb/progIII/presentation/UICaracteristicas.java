package utn.frbb.progIII.presentation;

import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class UICaracteristicas extends JPanel{

    private JLabel labelVelocidad;
    private JLabel labelDestreza;
    private JLabel labelFuerza;
    private JLabel labelArmadura;
    private JLabel labelNivel;

    public void UICaracteristicas(){

    }

    public void crearComponentesUICaracteristicas(){
        labelVelocidad = new JLabel("0",SwingConstants.CENTER);
        labelDestreza = new JLabel("0",SwingConstants.CENTER);
        labelFuerza = new JLabel("0",SwingConstants.CENTER);
        labelArmadura = new JLabel("0",SwingConstants.CENTER);
        labelNivel = new JLabel("0",SwingConstants.CENTER);
        labelVelocidad.setBackground(Color.WHITE);
        labelDestreza.setBackground(Color.WHITE);
        labelFuerza.setBackground(Color.WHITE);
        labelArmadura.setBackground(Color.WHITE);
        labelNivel.setBackground(Color.WHITE);
        labelVelocidad.setOpaque(true);
        labelDestreza.setOpaque(true);
        labelFuerza.setOpaque(true);
        labelArmadura.setOpaque(true);
        labelNivel.setOpaque(true);
        Border line = BorderFactory.createLineBorder(Color.BLUE, 1);
        //Border titled = BorderFactory.createTitledBorder(null, "Velocidad", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE);
        labelVelocidad.setBorder(BorderFactory.createTitledBorder(line, "Velocidad", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        labelDestreza.setBorder(BorderFactory.createTitledBorder(line, "Destreza", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        labelFuerza.setBorder(BorderFactory.createTitledBorder(line, "Fuerza", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        labelArmadura.setBorder(BorderFactory.createTitledBorder(line, "Armadura", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        labelNivel.setBorder(BorderFactory.createTitledBorder(line, "Nivel", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLUE));
        //System.out.println("cargo caracteristicas UI");

        add(labelVelocidad);
        add(labelArmadura);
        add(labelDestreza);
        add(labelFuerza);
        add(labelNivel);
    }

    public void setCaracteristicas(Personaje p){
        labelVelocidad.setText(String.valueOf(p.getCaracteristicas().getVelocidad()));
        labelDestreza.setText(String.valueOf(p.getCaracteristicas().getDestreza()));
        labelFuerza.setText(String.valueOf(p.getCaracteristicas().getFuerza()));
        labelArmadura.setText(String.valueOf(p.getCaracteristicas().getArmadura()));
        labelNivel.setText(String.valueOf(p.getCaracteristicas().getNivel()));
    }

    public void ubicarCaracteristicas(int lado){
        if (lado == GameController.LADOIZQUIERDO){
            labelVelocidad.setBounds(10,290,80,50);
            labelDestreza.setBounds(30,350,80,50);
            labelFuerza.setBounds(100,410,80,50);
            labelArmadura.setBounds(200,410,80,50);
            labelNivel.setBounds(15,230,70,50);
        }else{
            labelVelocidad.setBounds(310,290,80,50);
            labelDestreza.setBounds(290,350,80,50);
            labelFuerza.setBounds(220,410,80,50);
            labelArmadura.setBounds(120,410,80,50);
            labelNivel.setBounds(315,230,70,50);
        }
    }

}
