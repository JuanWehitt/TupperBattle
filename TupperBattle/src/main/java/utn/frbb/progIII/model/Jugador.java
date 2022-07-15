package utn.frbb.progIII.model;

public class Jugador {
    private String id;
    private String nombre;
    private String alias;
    private Personaje personaje1,personaje2,personaje3;
    private Personaje personajeEnRonda;

    public Jugador() {
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

    public Personaje getPersonaje1() {
        return personaje1;
    }

    public void setPersonaje1(Personaje personaje1) {
        this.personaje1 = personaje1;
    }

    public Personaje getPersonaje2() {
        return personaje2;
    }

    public void setPersonaje2(Personaje personaje2) {
        this.personaje2 = personaje2;
    }

    public Personaje getPersonaje3() {
        return personaje3;
    }

    public void setPersonaje3(Personaje personaje3) {
        this.personaje3 = personaje3;
    }

    public Personaje getPersonajeEnRonda() {
        return personajeEnRonda;
    }

    public void setPersonajeEnRonda(Personaje personajeEnRonda) {
        this.personajeEnRonda = personajeEnRonda;
    }
}
