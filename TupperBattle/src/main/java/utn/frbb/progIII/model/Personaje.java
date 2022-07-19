package utn.frbb.progIII.model;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class Personaje {

    private String nombre;
    private String apodo;
    private String fechaNac;
    private int edad;
    private int salud;
    private String imagen;
    private CaracteristicasPersonaje caracteristicas;



    private int ataqueNro = 1;

    public abstract int probocarDanio(Personaje contrincante);

    public Personaje(){

    }

    public Personaje(String nombre, String apodo, String fechaNac, int salud) {
        this.nombre = nombre;
        this.apodo = apodo;
        this.fechaNac = fechaNac;
        this.salud = salud;
        this.caracteristicas = new CaracteristicasPersonaje();

    }

    public int getAtaqueNro() {
        return ataqueNro;
    }

    public void setAtaqueNro(int ataque){
        ataqueNro = ataque;
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public int getEdad() {
        String[] edadArr = fechaNac.split("/", 3);
        int dia = Integer.parseInt(edadArr[0]);
        int mes = Integer.parseInt(edadArr[1]);
        int anio = Integer.parseInt(edadArr[2]);
        Date hoy = new Date();
        LocalDate local = hoy.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        edad = local.getYear()-anio;
        //System.out.println(local.getMonthValue()+" "+local.getYear());
        if (mes>local.getMonthValue()){
            edad--;
        }else if (mes==local.getMonthValue()){
            if (dia>local.getDayOfMonth()){
                edad--;
            }
        }
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
