package utn.frbb.progIII.presentation;

import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.model.Elfo;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Orco;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static utn.frbb.progIII.presentation.UIMenu.ANCHOBOTON;

public class UIGeneratingCharacter extends JPanel {

    private JTextField textFieldNombre;
    private JTextField textFieldApodo;
    private JTextField textFieldEdad;
    private JComboBox boxRaza;
    private JSlider sliderVelocidad;
    private JSlider sliderFuerza;
    private JSlider sliderArmadura;
    private JSlider sliderDestreza;

    private int nroPersonaje = 1;
    private static final int HUMANO = 0;
    private static final int ORCO = 1;
    private static final int ELFO = 2;

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

        textFieldNombre = new JTextField();
        textFieldNombre.setBounds(280,60,100,20);
        panelGeneratingCharacter.add(textFieldNombre);

        JLabel labelApodo = new JLabel("APODO:");
        labelApodo.setFont(new Font("Arial", Font.BOLD, 12));
        labelApodo.setBounds(390,60,100,20);
        panelGeneratingCharacter.add(labelApodo);

        textFieldApodo = new JTextField();
        textFieldApodo.setBounds(440,60,100,20);
        panelGeneratingCharacter.add(textFieldApodo);

        JLabel labelRaza = new JLabel("RAZA:");
        labelRaza.setBounds(220,85,100,20);
        panelGeneratingCharacter.add(labelRaza);

        boxRaza = new JComboBox();
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

        JLabel labelEdad = new JLabel("EDAD:");
        labelEdad.setFont(new Font("Arial", Font.BOLD, 12));
        labelEdad.setBounds(390,85,100,20);
        panelGeneratingCharacter.add(labelEdad);

        textFieldEdad = new JTextField();
        textFieldEdad.setBounds(435,85,80,20);
        panelGeneratingCharacter.add(textFieldEdad);

        //caracteristicas
        JLabel labelCaracteristicas = new JLabel("CARACTERISITCAS");
        labelCaracteristicas.setFont(new Font("Arial", Font.BOLD, 14));
        labelCaracteristicas.setBounds(220,110,150,20);
        panelGeneratingCharacter.add(labelCaracteristicas);

        JLabel labelVelocidad = new JLabel("VELOCIDAD:");
        labelVelocidad.setFont(new Font("Arial", Font.BOLD, 12));
        labelVelocidad.setBounds(235,145,100,20);
        panelGeneratingCharacter.add(labelVelocidad);

        sliderVelocidad = new JSlider(1,10);
        sliderVelocidad.setBounds(325,145,200,40);
        sliderVelocidad.setPaintLabels(true);
        sliderVelocidad.setPaintTicks(true);
        sliderVelocidad.setPaintTrack(true);
        sliderVelocidad.setMajorTickSpacing(1);
        sliderVelocidad.setMinorTickSpacing(1);
        sliderVelocidad.setFont(new Font("Arial", Font.PLAIN, 10));
        sliderVelocidad.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.add(sliderVelocidad);

        JLabel labelDestreza = new JLabel("DESTREZA:");
        labelDestreza.setFont(new Font("Arial", Font.BOLD, 12));
        labelDestreza.setBounds(235,190,100,20);
        panelGeneratingCharacter.add(labelDestreza);

        sliderDestreza = new JSlider(1,5);
        sliderDestreza.setBounds(325,190,200,40);
        sliderDestreza.setPaintLabels(true);
        sliderDestreza.setPaintTicks(true);
        sliderDestreza.setPaintTrack(true);
        sliderDestreza.setMajorTickSpacing(1);
        sliderDestreza.setMinorTickSpacing(1);
        sliderDestreza.setFont(new Font("Arial", Font.PLAIN, 10));
        sliderDestreza.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.add(sliderDestreza);

        JLabel labelFuerza = new JLabel("FUERZA:");
        labelFuerza.setFont(new Font("Arial", Font.BOLD, 12));
        labelFuerza.setBounds(235,235,100,20);
        panelGeneratingCharacter.add(labelFuerza);

        sliderFuerza = new JSlider(1,10);
        sliderFuerza.setBounds(325,235,200,40);
        sliderFuerza.setPaintLabels(true);
        sliderFuerza.setPaintTicks(true);
        sliderFuerza.setPaintTrack(true);
        sliderFuerza.setMajorTickSpacing(1);
        sliderFuerza.setMinorTickSpacing(1);
        sliderFuerza.setFont(new Font("Arial", Font.PLAIN, 10));
        sliderFuerza.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.add(sliderFuerza);

        JLabel labelArmadura = new JLabel("ARMADURA:");
        labelArmadura.setFont(new Font("Arial", Font.BOLD, 12));
        labelArmadura.setBounds(235,280,100,20);
        panelGeneratingCharacter.add(labelArmadura);

        sliderArmadura = new JSlider(1,10);
        sliderArmadura.setBounds(325,280,200,40);
        sliderArmadura.setPaintLabels(true);
        sliderArmadura.setPaintTicks(true);
        sliderArmadura.setPaintTrack(true);
        sliderArmadura.setMajorTickSpacing(1);
        sliderArmadura.setMinorTickSpacing(1);
        sliderArmadura.setFont(new Font("Arial", Font.PLAIN, 10));
        sliderArmadura.setBackground(new Color(110, 133, 201));
        panelGeneratingCharacter.add(sliderArmadura);


        JButton botonAnterior = new JButton("Anterior");
        botonAnterior.setBounds(panelGeneratingCharacter.getWidth()/2-ANCHOBOTON-5,350,ANCHOBOTON,45);
        botonAnterior.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nroPersonaje!=1) {
                    nroPersonaje--;
                    limpiarComponentes();
                    mostrarPersonaje(GameController.obtenerPersonaje(nroPersonaje));
                }
            }
        });
        panelGeneratingCharacter.add(botonAnterior);

        JButton botonSiguiente = new JButton("OK!, Siguiente");
        botonSiguiente.setBounds(panelGeneratingCharacter.getWidth()/2+5,350,ANCHOBOTON,45);
        botonSiguiente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nroPersonaje!=6) {
                    if (boxRaza.getSelectedIndex()==HUMANO){
                        Humano humano = new Humano(textFieldNombre.getText(), textFieldApodo.getText(), Integer.decode(textFieldEdad.getText()),100);
                        humano.setImagen("");
                        GameController.agregarPersonaje(nroPersonaje,humano);
                    }else if(boxRaza.getSelectedIndex()==ORCO){
                        Orco orco = new Orco(textFieldNombre.getText(), textFieldApodo.getText(), Integer.decode(textFieldEdad.getText()),100);
                        orco.setImagen("");
                        GameController.agregarPersonaje(nroPersonaje,orco);
                    }else{
                        Elfo elfo = new Elfo(textFieldNombre.getText(), textFieldApodo.getText(), Integer.decode(textFieldEdad.getText()),100);
                        elfo.setImagen("");
                        GameController.agregarPersonaje(nroPersonaje,elfo);
                    }
                    //TODO: ver como actualizar sin crear otro personaje en el lugar
                    nroPersonaje++;
                    limpiarComponentes();
                    mostrarPersonaje(GameController.obtenerPersonaje(nroPersonaje));
                }
            }
        });
        panelGeneratingCharacter.add(botonSiguiente);

        JButton botonCancelar = new JButton("X");
        botonCancelar.setBounds(553,3,45,45);
        botonCancelar.setBackground(Color.WHITE);
        panelGeneratingCharacter.add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarComponentes();
                panelGeneratingCharacter.setVisible(false);
                UIMenu.visible(true);
            }
        });
        frame.add(panelGeneratingCharacter);
    }
    public void limpiarComponentes(){
        textFieldNombre.setText("");
        textFieldApodo.setText("");
        textFieldEdad.setText("");
        boxRaza.setSelectedIndex(0);
        sliderVelocidad.setValue(5);
        sliderFuerza.setValue(5);
        sliderArmadura.setValue(5);
        sliderDestreza.setValue(3);
    }
    public void mostrarPersonaje(Personaje p){
        if (p!=null) {
            textFieldNombre.setText(p.getNombre());
            textFieldApodo.setText(p.getApodo());
            textFieldEdad.setText(Integer.toString(p.getEdad()));
            if (p instanceof Humano) {
                boxRaza.setSelectedIndex(HUMANO);
            } else if (p instanceof Orco) {
                boxRaza.setSelectedIndex(ORCO);
            } else {
                boxRaza.setSelectedIndex(ELFO);
            }
            sliderVelocidad.setValue(p.getCaracteristicas().getVelocidad());
            sliderFuerza.setValue(p.getCaracteristicas().getFuerza());
            sliderArmadura.setValue(p.getCaracteristicas().getArmadura());
            sliderDestreza.setValue(p.getCaracteristicas().getDestreza());
            //TODO: VER COMO CARGAR LA IMAGEN...
        }
    }
}
