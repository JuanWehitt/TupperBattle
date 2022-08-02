package utn.frbb.progIII.presentation;

import utn.frbb.progIII.model.CaracteristicasPersonaje;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class UICarta extends JPanel {

    private Jugador jugador;
    private Personaje personaje;
    private int lado;//0 es izquierda 1 es derecha
    private boolean eliminado=false;
    private int numero;
    private JLabel imagenLabel;
    private JLabel labelVida;

    public void UICarta(){
    }

    public JLabel getLabelVida() {
        return labelVida;
    }

    public void setLabelVida(String labelVida) {
        this.labelVida.setText(labelVida);
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
        imagenLabel.setOpaque(eliminado);
        if (eliminado) {
            this.setBorder(BorderFactory.createLineBorder(new Color(136, 136, 136), 10, true));
        }else{
            this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5, true));
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void crearImagenCarta()  {
        //System.out.println(" en crear imagen carta : "+personaje.getApodo()+" "+personaje.getImagen());
        File file = new File(this.personaje.getImagen());
        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = bufferedImage.getScaledInstance(110, 160, Image.SCALE_DEFAULT);
        ImageIcon imageIcon = new ImageIcon(image);
        imagenLabel = new JLabel(imageIcon);//240 x
        imagenLabel.setBounds(5,5,(this.getWidth()-10),(this.getHeight()-10));
        imagenLabel.setBackground(new Color(255, 255, 255));
        //imagenLabel.setOpaque(true);
        this.setLayout(null);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK,5,true));

        JLabel labelNombre = new JLabel(this.getPersonaje().getNombre().toUpperCase(Locale.ROOT));
        labelNombre.setBounds(6,this.getHeight()-21,this.getWidth()-12,15);
        labelNombre.setHorizontalAlignment(SwingConstants.CENTER);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 12));
        labelNombre.setOpaque(true);
        labelNombre.setBackground(new Color(183, 227, 183,80));
        this.add(labelNombre);
        labelVida = new JLabel(Integer.toString(this.getPersonaje().getSalud()));
        labelVida.setBounds(6,6,20,15);
        labelVida.setHorizontalAlignment(SwingConstants.CENTER);
        labelVida.setFont(new Font("Arial", Font.BOLD, 10));
        labelVida.setOpaque(true);
        labelVida.setBackground(new Color(183, 227, 183,80));
        this.add(labelVida);
        this.add(imagenLabel);
    }

}
