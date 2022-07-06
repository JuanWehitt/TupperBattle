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

    public abstract int probocarDanio(Personaje contrincante);

    public Personaje(){

    }

    public Personaje(String nombre, String apodo, int edad, int salud) {
        this.nombre = nombre;
        this.apodo = apodo;
        //this.fechaNac = fechaNac;
        this.edad = edad;
        this.salud = salud;
        this.caracteristicas = new CaracteristicasPersonaje();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public CaracteristicasPersonaje getCaracteristicas() {
        return caracteristicas;
    }

}
