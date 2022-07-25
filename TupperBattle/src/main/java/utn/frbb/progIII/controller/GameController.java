package utn.frbb.progIII.controller;

import utn.frbb.progIII.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static final int SALUDEXTRAALGANAR = 20;
    public static final int CANTIDADDEPERSONAJESPORJUGADOR = 3;
    public static final int CANTIDADDEATAQUESPORJUGADOR = 7;
    public static final int LADODERECHO = 1;
    public static final int LADODIZQUIERDO = 0;
    private static int nroPartida = 0;
    private static List<Partida> listaDePartidas = new ArrayList<>();
    private static Partida partidaActual;

    private static List<Personaje> listaPersonajes = new ArrayList<>(CANTIDADDEPERSONAJESPORJUGADOR*2);

    public static int personajesPorJugador() {
        return CANTIDADDEPERSONAJESPORJUGADOR;
    }

    public static void iniciarJuego(){

        //repartir los presonajes (cartas) mostrar carteles
        repartirLosPersonajes();
        partidaActual = listaDePartidas.get(nroPartida-1);

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

    public static Jugador getJugadorDeTurno() {
        Partida partida = listaDePartidas.get(getNroPartida()-1);
        return partida.getJugadorDeTurno();
    }
    public static Jugador getJugadorEnEspera() {
        Partida partida = listaDePartidas.get(getNroPartida()-1);
        return partida.getJugadorEnEspera();
    }

    public static int atacarAlOponente() {
            Personaje atacante = GameController.getJugadorDeTurno().getPersonajeEnRonda();
            Personaje oponente = GameController.getJugadorEnEspera().getPersonajeEnRonda();
            int valor = atacante.probocarDanio(oponente);
            oponente.setSalud(oponente.getSalud()-valor);
            System.out.println(atacante.getNombre() + "ataco a "+ oponente.getNombre()+ " y le resto "+valor+ " de vida");
            return valor;
    }

    public static void actualizarNumeroDeAtaques() {
        Personaje atacante = GameController.getJugadorDeTurno().getPersonajeEnRonda();
        atacante.setAtaqueNro(atacante.getAtaqueNro()+1);
    }


    public static void setRonda(int ronda) {
        partidaActual.setNroDeRonda(ronda);
    }


    public static int getRonda() {
        return partidaActual.getNroDeRonda();
    }

    public static void setJugadorDeTurno(Jugador jugador) {
        Partida partida = listaDePartidas.get(nroPartida-1);
        partida.setJugadorDeTurno(jugador);
    }

    public static void setJugadorEnEspera(Jugador jugador) {
        Partida partida = listaDePartidas.get(nroPartida-1);
        partida.setJugadorEnEspera(jugador);
    }

    public static boolean esFinDeLaPartida() {
        Partida partida = listaDePartidas.get(nroPartida-1);
        Jugador jugador1 = partida.getJugador2();
        Jugador jugador2 = partida.getJugador2();
        if (((jugador1.getPersonaje(0).getSalud()==0) &&
                (jugador1.getPersonaje(1).getSalud()==0) &&
                (jugador1.getPersonaje(2).getSalud()==0)) ||
                ((jugador2.getPersonaje(0).getSalud()==0) &&
                        (jugador2.getPersonaje(1).getSalud()==0) &&
                        (jugador2.getPersonaje(2).getSalud()==0))){
            return true;
        }else{
            return false;
        }
    }

    public static boolean esFinDeRonda() {
        Personaje oponente = GameController.getJugadorEnEspera().getPersonajeEnRonda();
        Personaje atacante = GameController.getJugadorDeTurno().getPersonajeEnRonda();
        if(oponente.isMuerto()){
            return true;
        }
        if(oponente.getAtaqueNro()==7 && atacante.getAtaqueNro()==7){
            return true;
        }else{
            return false;
        }

    }

    public static void finalizarRonda() {
        Partida partida = listaDePartidas.get(nroPartida-1);
        Jugador jugadorGanador,jugadorPerdedor;
        Personaje personajeJ1 = partida.getJugador1().getPersonajeEnRonda();
        Personaje personajeJ2 = partida.getJugador2().getPersonajeEnRonda();

        //si el personaje en espera murio..
        // seteo jugador ganador
        // seteo jugador perdedor
        //si la ronda termino por numero de ataques


        if (personajeJ1.getAtaqueNro()==7 && personajeJ2.getAtaqueNro()==7){
            if (personajeJ1.getSalud()<=personajeJ2.getSalud()){
                jugadorGanador = partida.getJugador1();
                jugadorPerdedor = partida.getJugador2();
            }else{
                jugadorGanador = partida.getJugador2();
                jugadorPerdedor = partida.getJugador1();
            }
        }else {
            if (partida.getJugador2().getPersonajeEnRonda().isMuerto()) {
                jugadorGanador = partida.getJugador1();
                jugadorPerdedor = partida.getJugador2();
            } else {
                jugadorGanador = partida.getJugador2();
                jugadorPerdedor = partida.getJugador1();
            }
        }
        jugadorGanador.getPersonajeEnRonda().setSalud(jugadorGanador.getPersonajeEnRonda().getSalud()+SALUDEXTRAALGANAR);
        jugadorGanador.getPersonajeEnRonda().setAtaqueNro(1);
        jugadorPerdedor.getPersonajeEnRonda().setAtaqueNro(1);
        partida.setGanadorDeRonda(jugadorGanador);
        partida.setPerdedorDeRonda(jugadorPerdedor);
        partida.setNroDeRonda(partida.getNroDeRonda()+1);
    }

    public static Jugador getJugadorGanador() {
        Partida partida = listaDePartidas.get(nroPartida-1);
        return partida.getGanadorDeRonda();
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
        if (jugador.cantidadDePersonajesVivos()>=1) {
            while (p.isMuerto()) {
                nroPersonajeSorteado = (int) (Math.random() * CANTIDADDEPERSONAJESPORJUGADOR);
                p = jugador.getPersonaje(nroPersonajeSorteado);
            }
            jugador.setPersonajeEnRonda(p);
            System.out.println("Se sorteo del Jugador " + jugador.getNombre() + " el personaje + " + p.getNombre() + " el " + p.getApodo());
            return p;
        }else{
            return null;
        }
    }

    public static Jugador sortearJugador(){
        int jugador = (int)(Math.random()*2);
        if (jugador == 0){
            System.out.println("Salio soreteado " + listaDePartidas.get(nroPartida-1).getJugador1().getNombre() +"para iniciar la ronda.");
            return listaDePartidas.get(nroPartida-1).getJugador1();
        }else{
            System.out.println("Salio soreteado " + listaDePartidas.get(nroPartida-1).getJugador2().getNombre() +"para iniciar la ronda.");
            return listaDePartidas.get(nroPartida-1).getJugador2();
        }
    }


}
