package utn.frbb.progIII.model;

public class Ronda {
    private int nro;
    private Personaje personajeGanador;
    private Personaje personajePerdedor;
    private int vidaGanador;
    private int vidaPerdedor;
    private Jugador jugadorGanador,jugadorPerdedor;


    public Ronda(int nro) {
        this.nro = nro;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

    public Personaje getPersonajeGanador() {
        return personajeGanador;
    }

    public void setPersonajeGanador(Personaje personajeGanador) {
        this.personajeGanador = personajeGanador;
    }

    public Personaje getPersonajePerdedor() {
        return personajePerdedor;
    }

    public void setPersonajePerdedor(Personaje personajePerdedor) {
        this.personajePerdedor = personajePerdedor;
    }

    public int getVidaGanador() {
        return vidaGanador;
    }

    public void setVidaGanador(int vidaGanador) {
        this.vidaGanador = vidaGanador;
    }

    public int getVidaPerdedor() {
        return vidaPerdedor;
    }

    public void setVidaPerdedor(int vidaPerdedor) {
        this.vidaPerdedor = vidaPerdedor;
    }

    public Jugador getJugadorGanador() {
        return jugadorGanador;
    }

    public void setJugadorGanador(Jugador jugadorGanador) {
        this.jugadorGanador = jugadorGanador;
        this.personajeGanador = jugadorGanador.getPersonajeEnRonda();
        this.vidaGanador = personajeGanador.getSalud();
    }

    public Jugador getJugadorPerdedor() {
        return jugadorPerdedor;
    }

    public void setJugadorPerdedor(Jugador jugadorPerdedor) {
        this.jugadorPerdedor = jugadorPerdedor;
        this.personajePerdedor = jugadorPerdedor.getPersonajeEnRonda();
        this.vidaPerdedor = personajePerdedor.getSalud();
    }
}
