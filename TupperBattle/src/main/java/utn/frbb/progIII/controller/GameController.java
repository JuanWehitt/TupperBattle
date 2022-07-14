package utn.frbb.progIII.controller;

import utn.frbb.progIII.model.*;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private static List<Personaje> listaPersonajes = new ArrayList<>(6);;

    public void iniciarJuego(){

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

}
