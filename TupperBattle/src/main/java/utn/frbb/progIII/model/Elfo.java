package utn.frbb.progIII.model;

import java.util.Date;

public class Elfo extends Personaje{

    public Elfo(String nombre, String apodo, int edad, int salud) {
        super(nombre, apodo, edad, salud);
    }

    @Override
    public void probocarDanio(Personaje contrincante) {

    }
}
