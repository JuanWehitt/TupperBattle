package utn.frbb.progIII.controller;

import utn.frbb.progIII.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {


    public static final int VIDAEXTRAALGANAR = 20;
    public static final int CANTIDADDEPERSONAJESPORJUGADOR = 3;
    public static final int CANTIDADDEATAQUESPORJUGADOR = 7;
    public static final int LADODERECHO = 1;
    public static final int LADOIZQUIERDO = 0;
    public static final String PATHIMAGENHUMANO = "TupperBattle/images/humano.jpg";
    public static final String PATHIMAGENORCO = "TupperBattle/images/orco.jpg";
    public static final String PATHIMAGENELFO = "TupperBattle/images/elfo.jpg";
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
        if(partidaActual.getNroDeRonda()==1) {
            partidaActual.setJugadorDeTurno(sortearJugador());
        }else{
            partidaActual.setJugadorDeTurno(partidaActual.getPerdedorDeRonda(partidaActual.getNroDeRonda()-1));
        }
        partidaActual.getJugadorDeTurno().setPersonajeEnRonda(sortearPersonajeDeJugador(partidaActual.getJugadorDeTurno()));
        partidaActual.getJugadorEnEspera().setPersonajeEnRonda(sortearPersonajeDeJugador(partidaActual.getJugadorEnEspera()));
        setNroAtaques(1);
    }

    public static int getNroPartida() {
        return nroPartida;
    }



    public static void repartirLosPersonajes(){
        int jugador;
        int personajesEnJugador1 = 0;
        int personajesEnJugador2 = 0;
        Jugador j1 = partidaActual.getJugador1();
        Jugador j2 = partidaActual.getJugador2();
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

    public static void crearPartida(String nombreJugador1, String nombreJugador2) {
        listaDePartidas.add(new Partida(new Jugador(), new Jugador()));
        Partida p = listaDePartidas.get(listaDePartidas.size()-1);
        Jugador j1 = p.getJugador1();
        j1.setNombre(nombreJugador1);
        Jugador j2 = p.getJugador2();
        j2.setNombre(nombreJugador2);
        nroPartida = listaDePartidas.size();
        partidaActual = p;
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
            System.out.println(atacante.getNombre() + " ataco a "+ oponente.getNombre()+ " y le resto "+valor+ " de vida");
            return valor;
    }

    public static void actualizarNumeroDeAtaques() {
        Personaje atacante = GameController.getJugadorDeTurno().getPersonajeEnRonda();
        atacante.setAtaqueNro(atacante.getAtaqueNro()+1);
    }

    public static void nuevaRonda(){
        partidaActual.nuevaRonda();
    }

    public static int getRonda() {
        return partidaActual.getNroDeRonda();
    }

    public static Jugador getPerdedorDeRonda(){
        return partidaActual.getPerdedorDeRonda(partidaActual.getNroDeRonda());
    }

    public static Jugador getGanadorDeRonda(){
        //Partida partida = listaDePartidas.get(nroPartida-1);
        return partidaActual.getGanadorDeRonda(partidaActual.getNroDeRonda());
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
        Jugador jugador1 = partida.getJugador1();
        Jugador jugador2 = partida.getJugador2();
        return (jugador1.cantidadDePersonajesVivos()==0 || jugador2.cantidadDePersonajesVivos()==0);
    }

    public static void finalizarPartida() {
        Partida partida = listaDePartidas.get(nroPartida-1);
        Jugador jugador1 = partida.getJugador1();
        Jugador jugador2 = partida.getJugador2();
        if (jugador1.cantidadDePersonajesVivos()==0){
            partida.setJugadorGanador(jugador2);
        }else{
            partida.setJugadorGanador(jugador1);
        }
        jugador1.revivirPersonajes();
        jugador2.revivirPersonajes();

    }

    public static boolean esFinDeRonda() {
        Personaje oponente = GameController.getJugadorEnEspera().getPersonajeEnRonda();
        Personaje atacante = GameController.getJugadorDeTurno().getPersonajeEnRonda();
        if(oponente.isMuerto()){
            return true;
        }
        if(oponente.getAtaqueNro()==CANTIDADDEATAQUESPORJUGADOR+1 && atacante.getAtaqueNro()==CANTIDADDEATAQUESPORJUGADOR+1){
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
        personajeJ2.setEnRonda(false);
        personajeJ1.setEnRonda(false);
        if (personajeJ1.getAtaqueNro()==CANTIDADDEATAQUESPORJUGADOR+1 && personajeJ2.getAtaqueNro()==CANTIDADDEATAQUESPORJUGADOR+1){
            if (personajeJ1.getSalud()<=personajeJ2.getSalud()){
                jugadorGanador = partida.getJugador2();
                jugadorPerdedor = partida.getJugador1();
            }else{
                jugadorGanador = partida.getJugador1();
                jugadorPerdedor = partida.getJugador2();
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
        jugadorGanador.getPersonajeEnRonda().setSalud(jugadorGanador.getPersonajeEnRonda().getSalud()+VIDAEXTRAALGANAR);
        jugadorGanador.getPersonajeEnRonda().setAtaqueNro(1);
        jugadorPerdedor.getPersonajeEnRonda().setAtaqueNro(1);
        partida.setGanadorDeRonda(jugadorGanador);
        partida.setPerdedorDeRonda(jugadorPerdedor);

    }

    public static Jugador getGanadorDePartida() {
        return partidaActual.getJugadorGanador();
    }

    public static void setNroAtaques(int i) {
        partidaActual.getJugador1().getPersonajeEnRonda().setAtaqueNro(1);
        partidaActual.getJugador2().getPersonajeEnRonda().setAtaqueNro(1);
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
            jugador.getPersonajeEnRonda().setEnRonda(true);
            System.out.println("Se sorteo del Jugador " + jugador.getNombre() + " el personaje " + p.getNombre() + " el " + p.getApodo());
            return p;
        }else{
            return null;
        }
    }

    public static Jugador sortearJugador(){
        int jugador = (int)(Math.random()*2);
        if (jugador == 0){
            System.out.println("Salio soreteado " + listaDePartidas.get(nroPartida-1).getJugador1().getNombre() +" para iniciar la ronda.");
            return listaDePartidas.get(nroPartida-1).getJugador1();
        }else{
            System.out.println("Salio soreteado " + listaDePartidas.get(nroPartida-1).getJugador2().getNombre() +" para iniciar la ronda.");
            return listaDePartidas.get(nroPartida-1).getJugador2();
        }
    }


}
