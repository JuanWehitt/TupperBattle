package utn.frbb.progIII.presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utn.frbb.progIII.presentation.UIMenu.ANCHOBOTON;

public class UIGeneratingCharacter extends JPanel {

    private JPanel panelGeneratingCharacter;
    public void setVisible(boolean val){
        panelGeneratingCharacter.setVisible(val);
    }

    public void crearPanel(JFrame frame) {
        panelGeneratingCharacter = new JPanel();
        panelGeneratingCharacter.setLayout(null);

        panelGeneratingCharacter.setBounds(frame.getWidth()/2-600/2,180,600,400);
        panelGeneratingCharacter.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.setVisible(false);

        JLabel labelTituloVentana = new JLabel("CONSTRUCTOR DE PERSONAJES");
        labelTituloVentana.setBounds(100,3,600,48);
        labelTituloVentana.setFont(new Font("Arial", Font.BOLD, 25));
        panelGeneratingCharacter.add(labelTituloVentana);

        JPanel panelCarta = new JPanel();
        panelCarta.setBounds(10,60,200,250);
        panelCarta.setBackground(new Color(33, 40, 79));
        panelGeneratingCharacter.add(panelCarta);

        JLabel labelNombre = new JLabel("NOMBRE:");
        labelNombre.setFont(new Font("Arial", Font.BOLD, 12));
        labelNombre.setBounds(220,60,100,20);
        panelGeneratingCharacter.add(labelNombre);

        JTextField textFieldNombre = new JTextField();
        textFieldNombre.setBounds(280,60,100,20);
        panelGeneratingCharacter.add(textFieldNombre);

        JLabel labelApodo = new JLabel("APODO:");
        labelApodo.setFont(new Font("Arial", Font.BOLD, 12));
        labelApodo.setBounds(390,60,100,20);
        panelGeneratingCharacter.add(labelApodo);

        JTextField textFieldApodo = new JTextField();
        textFieldApodo.setBounds(440,60,100,20);
        panelGeneratingCharacter.add(textFieldApodo);

        JLabel labelRaza = new JLabel("RAZA:");
        labelRaza.setBounds(220,85,100,20);
        panelGeneratingCharacter.add(labelRaza);

        JComboBox boxRaza = new JComboBox();
        boxRaza.addItem("Humano");
        boxRaza.addItem("Orco");
        boxRaza.addItem("Elfo");
        boxRaza.setBounds(280,85,100,20);
        boxRaza.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: cambiar la imagen de la carta
                System.out.println("Cambio a "+boxRaza.getSelectedItem().toString());
            }
        });
        panelGeneratingCharacter.add(boxRaza);

        JLabel labelFecha = new JLabel("NACIMIENTO:");
        labelFecha.setFont(new Font("Arial", Font.BOLD, 12));
        labelFecha.setBounds(390,85,100,20);
        panelGeneratingCharacter.add(labelFecha);

        JTextField textFieldFecha = new JTextField();
        textFieldFecha.setBounds(480,85,80,20);
        panelGeneratingCharacter.add(textFieldFecha);

        //caracteristicas
        JLabel labelCaracteristicas = new JLabel("CARACTERISITCAS");
        labelCaracteristicas.setFont(new Font("Arial", Font.BOLD, 14));
        labelCaracteristicas.setBounds(220,110,150,20);
        panelGeneratingCharacter.add(labelCaracteristicas);

        JLabel labelVelocidad = new JLabel("VELOCIDAD:");
        labelVelocidad.setFont(new Font("Arial", Font.BOLD, 12));
        labelVelocidad.setBounds(240,140,100,20);
        panelGeneratingCharacter.add(labelVelocidad);

        JSlider sliderVelocidad = new JSlider(1,10);
        sliderVelocidad.setBounds(340,140,200,40);
        sliderVelocidad.setPaintLabels(true);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setPaintTrack(true);
        sliderVelocidad.setMajorTickSpacing(1);
        sliderVelocidad.setMinorTickSpacing(1);
        sliderVelocidad.setFont(new Font("Arial", Font.PLAIN, 10));
        sliderVelocidad.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.add(sliderVelocidad);


        JButton botonAnterior = new JButton("Anterior");
        botonAnterior.setBounds(panelGeneratingCharacter.getWidth()/2-ANCHOBOTON-5,350,ANCHOBOTON,45);
        panelGeneratingCharacter.add(botonAnterior);

        JButton botonSiguiente = new JButton("Siguiente");
        botonSiguiente.setBounds(panelGeneratingCharacter.getWidth()/2+5,350,ANCHOBOTON,45);
        panelGeneratingCharacter.add(botonSiguiente);

        JButton botonCancelar = new JButton("X");
        botonCancelar.setBounds(553,3,45,45);
        botonCancelar.setBackground(Color.WHITE);
        panelGeneratingCharacter.add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGeneratingCharacter.setVisible(false);
                UIMenu.visible(true);
            }
        });
        frame.add(panelGeneratingCharacter);
    }
}
