package utn.frbb.progIII.presentation;

import utn.frbb.progIII.model.CaracteristicasPersonaje;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UICarta extends JPanel {

    private Jugador jugador;
    private Personaje personaje;
    private int lado;//0 es izquierda 1 es derecha
    private boolean eliminado;
    private int numero;
    private JLabel imagenLabel;

    public void UICarta(){
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public void setLado(int i) {
        this.lado = i;
    }

    public int getLado() {
        return lado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void crearImagenCarta()  {
        File file = new File(this.personaje.getImagen());
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        imagenLabel = new JLabel(imageIcon);//240 x
        imagenLabel.setBounds(0,0,this.getWidth(),this.getHeight());
        imagenLabel.setBackground(new Color(255, 0, 0));
        this.add(imagenLabel);
    }

}
