package utn.frbb.progIII.model;

public class Humano extends Personaje{

    public Humano(String nombre, String apodo, int edad, int salud) {
        super(nombre, apodo, edad, salud);
    }

    @Override
    public void probocarDanio(Personaje contrincante) {

    }
}
