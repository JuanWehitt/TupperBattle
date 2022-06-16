package utn.frbb.progIII.Logger;

import utn.frbb.progIII.model.Registro;

public class Logger {

    public static void logearRegistro(Registro reg) {
        System.out.println(reg.getTexto());
    }
}
