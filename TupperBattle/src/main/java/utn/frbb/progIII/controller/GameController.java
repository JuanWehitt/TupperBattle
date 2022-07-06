package utn.frbb.progIII.controller;

import utn.frbb.progIII.model.Elfo;
import utn.frbb.progIII.model.Humano;
import utn.frbb.progIII.model.Orco;
import utn.frbb.progIII.model.Personaje;

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

    public static void agregarPersonaje(int index, Personaje p){
        index--;
        System.out.println(p.getNombre()+" "+ p.getApodo()+" "+ p.getEdad()+" "+ p.getSalud());
        if (p instanceof Humano) {
            listaPersonajes.add(index, new Humano(p.getNombre(), p.getApodo(), p.getEdad(), p.getSalud()));
            listaPersonajes.get(index).setImagen(p.getImagen());
        }else if (p instanceof Orco){
            listaPersonajes.add(index, new Orco(p.getNombre(), p.getApodo(), p.getEdad(), p.getSalud()));
            listaPersonajes.get(index).setImagen(p.getImagen());
        }else{
            listaPersonajes.add(index, new Elfo(p.getNombre(), p.getApodo(), p.getEdad(), p.getSalud()));
            listaPersonajes.get(index).setImagen(p.getImagen());
        }
        System.out.println(listaPersonajes.size());
    }

}
