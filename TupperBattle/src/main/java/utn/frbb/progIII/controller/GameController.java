package utn.frbb.progIII.controller;

import utn.frbb.progIII.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static int ronda = 1;
    private static final int CANTIDADDEPERSONAJESPORJUGADOR = 3;
    private static final int CANTIDADDEATAQUESPORJUGADOR = 7;
    private static int nroPartida = 0;
    private static List<Partida> listaDePartidas = new ArrayList<>();


    private static List<Personaje> listaPersonajes = new ArrayList<>(CANTIDADDEPERSONAJESPORJUGADOR*2);


    public static int personajesPorJugador() {
        return CANTIDADDEPERSONAJESPORJUGADOR;
    }

    public static void iniciarJuego(){
        ronda = 1;

        //repartir los presonajes (cartas) mostrar carteles
        repartirLosPersonajes();
        Partida partidaActual = listaDePartidas.get(nroPartida-1);
        partidaActual.setJugadorDeTurno(sortearJugador());

        partidaActual.getJugadorDeTurno().setPersonajeEnRonda(sortearPersonajeDeJugador(partidaActual.getJugadorDeTurno()));
        partidaActual.getJugadorEnEspera().setPersonajeEnRonda(sortearPersonajeDeJugador(partidaActual.getJugadorEnEspera()));


        //crear la Partida
        //comenzar el juego iniciando la ronda 1
        //bucle de rondas
        ////Elegir al azar el personaje del jugador 1.
        ////Elegir al azar el personaje del jugador 2.
        ////Sortear jugador que comienza solo en ronda 1, sino el perdedor de la ronda anterior.
        ////Ataca el jugador sorteado el otro jugador
        ////
    }

    public static int getNroPartida() {
        return nroPartida;
    }

    public static void repartirLosPersonajes(){
        int jugador;
        int personajesEnJugador1 = 0;
        int personajesEnJugador2 = 0;
        Jugador j1 = listaDePartidas.get(nroPartida-1).getJugador1();
        Jugador j2 = listaDePartidas.get(nroPartida-1).getJugador2();
        for (int i = 0; i<CANTIDADDEPERSONAJESPORJUGADOR*2; i++){
            jugador = (int)(Math.random() * 2) + 1; //1 o 2
            if (jugador == 1){
                if (personajesEnJugador1<CANTIDADDEPERSONAJESPORJUGADOR) {
                    j1.agregarPersonaje(listaPersonajes.get(i));
                    personajesEnJugador1++;
                }else{
                    j2.agregarPersonaje(listaPersonajes.get(i));
                    personajesEnJugador2++;
                }
            }else {
                if (personajesEnJugador2<CANTIDADDEPERSONAJESPORJUGADOR) {
                    j2.agregarPersonaje(listaPersonajes.get(i));
                    personajesEnJugador2++;
                }else{
                    j1.agregarPersonaje(listaPersonajes.get(i));
                    personajesEnJugador1++;
                }
            }
        }

    }

    public static void crearPersonajesAleatorio(){

    }

    public static void crearLaPartida(String nombreJugador1, String nombreJugador2) {
        listaDePartidas.add(new Partida(new Jugador(), new Jugador()));
        Partida p = listaDePartidas.get(listaDePartidas.size()-1);
        Jugador j1 = p.getJugador1();
        j1.setNombre(nombreJugador1);
        Jugador j2 = p.getJugador2();
        j2.setNombre(nombreJugador2);
        nroPartida = listaDePartidas.size();
    }

    public static Jugador getJugador(int nro, int partida){
        if (nro == 1) {
            return listaDePartidas.get(partida-1).getJugador1();
        }else{
            return listaDePartidas.get(partida-1).getJugador2();
        }
    }

    public void terminarJuego(){

    }

    public static Personaje obtenerPersonaje(int nro){
        nro--;
        if(nro<listaPersonajes.size()) {
            return listaPersonajes.get(nro);
        }else {
            return null;
        }
    }

    public static void agregarPersonaje(int index, Personaje p, CaracteristicasPersonaje caracteristicasPersonaje){
        index--;
        //System.out.println(p.getNombre()+" "+ p.getApodo()+" "+ p.getEdad()+" "+ p.getSalud());
        if (p instanceof Humano) {
            if (listaPersonajes.size()>index){
                listaPersonajes.set(index, new Humano(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }else {
                listaPersonajes.add(index, new Humano(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }
        }else if (p instanceof Orco){
            if (listaPersonajes.size()>index){
                listaPersonajes.set(index, new Orco(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }else {
                listaPersonajes.add(index, new Orco(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }
        }else{
            if (listaPersonajes.size()>index){
                listaPersonajes.set(index, new Elfo(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }else {
                listaPersonajes.add(index, new Elfo(p.getNombre(), p.getApodo(), p.getFechaNac(), p.getSalud()));
            }
        }
        listaPersonajes.get(index).setImagen(p.getImagen());
        CaracteristicasPersonaje caracteristicasPersonaje1 = listaPersonajes.get(index).getCaracteristicas();
        caracteristicasPersonaje1.setArmadura(caracteristicasPersonaje.getArmadura());
        caracteristicasPersonaje1.setDestreza(caracteristicasPersonaje.getDestreza());
        caracteristicasPersonaje1.setFuerza(caracteristicasPersonaje.getFuerza());
        caracteristicasPersonaje1.setVelocidad(caracteristicasPersonaje.getVelocidad());
        //System.out.println(listaPersonajes.size());
    }

    public static int cantDePersonajesCreados(){
        return listaPersonajes.size();
    }

    public static Personaje sortearPersonajeDeJugador(Jugador jugador){
        int nroPersonajeSorteado = (int)(Math.random() * CANTIDADDEPERSONAJESPORJUGADOR);
        Personaje p = jugador.getPersonaje(nroPersonajeSorteado);
        while (p.getSalud()==0){
            nroPersonajeSorteado = (int)(Math.random() * CANTIDADDEPERSONAJESPORJUGADOR);
            p = jugador.getPersonaje(nroPersonajeSorteado);
        }
        jugador.setPersonajeEnRonda(p);
        System.out.println("Se sorteo del Jugador "+jugador.getNombre()+" el personaje + "+p.getNombre()+" el "+p.getApodo());
        return p;
    }

    public static Jugador sortearJugador(){
        int jugador = (int)(Math.random()*2);
        if (jugador == 0){
            return listaDePartidas.get(nroPartida-1).getJugador1();
        }else{
            return listaDePartidas.get(nroPartida-1).getJugador2();
        }
    }


}
