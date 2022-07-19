package utn.frbb.progIII.model;

import utn.frbb.progIII.controller.GameController;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private String id;
    private String nombre;
    private String alias;
    private List<Personaje> listaPersonajes;
    private Personaje personajeEnRonda;

    public Jugador() {
        listaPersonajes = new ArrayList<>(GameController.personajesPorJugador());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Personaje getPersonaje(int ind) {
        return listaPersonajes.get(ind);
    }

    public boolean agregarPersonaje(Personaje personaje) {
        if (listaPersonajes.size()<GameController.personajesPorJugador()) {
            listaPersonajes.add(personaje);
            return true;
        }else{
            return false;
        }
    }

    public Personaje getPersonajeEnRonda() {
        return personajeEnRonda;
    }

    public void setPersonajeEnRonda(Personaje personajeEnRonda) {
        this.personajeEnRonda = personajeEnRonda;
    }


}
