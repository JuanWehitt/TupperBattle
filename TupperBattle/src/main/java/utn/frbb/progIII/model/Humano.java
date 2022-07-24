package utn.frbb.progIII.model;

import java.util.Random;

public class Humano extends Personaje{

    public Humano(String nombre, String apodo, String fechaNac, int salud) {
        super(nombre, apodo, fechaNac, salud);
    }

    public Humano() {

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
        double danio = (double) ((double)(((VA*ED) - Pdef) / 500000.0) * 100.0);
        //System.out.println("el rndmo al atacar es de "+ED+". El PD es de "+PD+" VA es "+VA+". PDef es "+Pdef+". Danio es "+danio+". La division da "+(double)(((VA*ED) - Pdef) / 500000.0));
        return (int)Math.round(danio);
    }
}
