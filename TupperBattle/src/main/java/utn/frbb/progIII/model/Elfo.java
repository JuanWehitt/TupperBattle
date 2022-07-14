package utn.frbb.progIII.model;

import java.util.Random;

public class Elfo extends Personaje{

    public Elfo(String nombre, String apodo, String fechaNac, int salud) {
        super(nombre, apodo, fechaNac, salud);
    }

    @Override
    public int probocarDanio(Personaje contrincante) {
        //poder de disparo PD: Destreza * Fuerza * Nivel del personaje que ataca
        //efectividad de disparo ED: Aleatorio entre 1 y 100
        //valor de ataque VA: Poder de Disparo * Efectividad de Disparo
        //poder de defensa PDef: Armadura * Velocidad del personaje que defiende
        //
        Random r = new Random();
        CaracteristicasPersonaje misCaracteristicas = this.getCaracteristicas();
        CaracteristicasPersonaje susCaracteristicas = contrincante.getCaracteristicas();
        int PD = misCaracteristicas.getDestreza() * misCaracteristicas.getFuerza() * misCaracteristicas.getNivel();
        int ED = r.nextInt(100)+1;
        int VA = PD * ED;
        int Pdef = susCaracteristicas.getArmadura() * susCaracteristicas.getVelocidad();
        double danio = ((((VA*ED)-Pdef)/500)*100 ) * 1.05;
        return (int)Math.round(danio);
    }
}
