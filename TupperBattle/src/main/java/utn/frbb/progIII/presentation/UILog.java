package utn.frbb.progIII.presentation;

import utn.frbb.progIII.controller.GameController;
import utn.frbb.progIII.controller.LogController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UILog extends JPanel {

    private JPanel panelLog;
    private JScrollPane scrollPane;
    private JTextPane textPane;
    private JButton botonEliminarLog;
    private JButton botonCancelar;

    public void crearPanel(JFrame frame) {
        /*panelLog = new JPanel();
        panelLog.setLayout(null);

        panelLog.setBounds(frame.getWidth()/2-600/2,180,600,400);
        panelLog.setBackground(new Color(110, 133, 201));
        panelLog.setVisible(false);*/


        setLayout(null);

        setBounds(frame.getWidth() / 2 - 600 / 2, 180, 600, 400);
        setBackground(new Color(110, 133, 201));
        setVisible(false);

        textPane = new JTextPane();
        scrollPane = new JScrollPane();
        scrollPane.setViewportView(textPane);
        scrollPane.setBounds(3,50,596,300);
        add(scrollPane);

        botonCancelar = new JButton("X");
        botonCancelar.setBounds(553,3,45,45);
        botonCancelar.setBackground(Color.WHITE);
        add(botonCancelar);
        botonCancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                botonCancelar.getParent().setVisible(false);
                UIApp.visible(true);
            }
        });
        add(botonCancelar);
        botonEliminarLog = new JButton("Eliminar archivo log");
        botonEliminarLog.setBounds(250, 355, 200,30);
        botonEliminarLog.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(LogController.borrarArchivo()){
                    JOptionPane.showMessageDialog(null, "Archivo borrado.",
                            "Archivo log", JOptionPane.INFORMATION_MESSAGE);
                }
                botonEliminarLog.getParent().setVisible(false);
                UIApp.visible(true);
            }
        });
        add(botonEliminarLog);
        frame.add(this);
    }

    public void cargarArchivoLog() {
        String contenido = LogController.getArchivo();
        if (contenido==null){
            JOptionPane.showMessageDialog(null, "No existe el archivo, comienze un nuevo juego.",
                    "Archivo log", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            UIApp.visible(true);
        }else {
            textPane.setText(contenido);
        }
    }
}
