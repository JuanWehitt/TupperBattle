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

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(panelGeneratingCharacter.getWidth()/2-ANCHOBOTON/2,350,ANCHOBOTON,30);
        botonCancelar.setBackground(Color.WHITE);
        panelGeneratingCharacter.add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelGeneratingCharacter.setVisible(false);

            }
        });
        frame.add(panelGeneratingCharacter);
    }
}
