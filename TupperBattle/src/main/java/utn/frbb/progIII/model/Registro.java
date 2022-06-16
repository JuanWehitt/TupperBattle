package utn.frbb.progIII.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Registro {
    private String texto;
    //TODO: crear un atributo fecha, con la hora minutos y los segundos.

    @Override
    public String toString() {
        return texto;
    }

    public Registro(String texto) {
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

}
