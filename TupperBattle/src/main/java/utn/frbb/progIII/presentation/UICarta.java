package utn.frbb.progIII.presentation;

import utn.frbb.progIII.model.CaracteristicasPersonaje;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Jugador;
import utn.frbb.progIII.model.Personaje;

import javax.swing.*;

public class UICarta extends JPanel {

    private Jugador jugador;
    private Personaje personaje;
    private int lado;//0 es izquierda 1 es derecha
    private UICaracteristicas caracteristicas;

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

    //TODO: HACER LO DE CARACTERISTICAS....
}
