package utn.frbb.progIII.model;

import java.util.Date;

public abstract class Personaje {

    private String nombre;
    private String apodo;
    private Date fechaNac;
    private int edad;
    private int salud;
    private String imagen;
    private CaracteristicasPersonaje caracteristicas;

    public abstract void probocarDanio(Personaje contrincante);

    public Personaje(String nombre, String apodo, int edad, int salud) {
        this.nombre = nombre;
        this.apodo = apodo;
        //this.fechaNac = fechaNac;
        this.edad = edad;
        this.salud = salud;
    }
}
