package utn.frbb.progIII.model;

import utn.frbb.progIII.controller.GameController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Partida {

    private String id;
    private Jugador jugador1,jugador2,jugadorGanador;
    private Jugador jugadorDeTurno;
    private Jugador jugadorEnEspera;
    private List<Ronda> listaDeRondas;
    private int nroDeRonda;

    public Partida(Jugador jugador1, Jugador jugador2) {
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        nroDeRonda = 1;
        listaDeRondas = new ArrayList<>();
        listaDeRondas.add(new Ronda(nroDeRonda));
    }

    public int getNroDeRonda() {
        return nroDeRonda;
    }

    public void setNroDeRonda(int nroDeRonda) {
        this.nroDeRonda = nroDeRonda;
    }

    public Jugador getGanadorDeRonda(int nroRonda) {
        return listaDeRondas.get(nroRonda-1).getJugadorGanador();
    }

    public  void setGanadorDeRonda(Jugador ganadorDeRonda) {
        listaDeRondas.get(nroDeRonda-1).setJugadorGanador(ganadorDeRonda);
    }

    public  Jugador getPerdedorDeRonda(int nroRonda) {
        return listaDeRondas.get(nroRonda-1).getJugadorPerdedor();
    }

    public  void setPerdedorDeRonda(Jugador perdedorDeRonda) {
        listaDeRondas.get(nroDeRonda-1).setJugadorPerdedor(perdedorDeRonda);
    }

    public void nuevaRonda(){
        listaDeRondas.add(new Ronda(nroDeRonda+1));
        nroDeRonda++;
    }

    public  Jugador getJugadorDeTurno() {
        return jugadorDeTurno;
    }

    public  void setJugadorDeTurno(Jugador jugadorDeTurno) {
        this.jugadorDeTurno = jugadorDeTurno;
        if (jugadorDeTurno==jugador1){
            jugadorEnEspera = jugador2;
        }else{
            jugadorEnEspera = jugador1;
        }
    }

    public Jugador getJugadorEnEspera() {
        return jugadorEnEspera;
    }

    public void setJugadorEnEspera(Jugador jugadorEnEspera) {
        this.jugadorEnEspera = jugadorEnEspera;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
    }

}
