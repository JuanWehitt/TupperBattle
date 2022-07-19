package utn.frbb.progIII.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static final String PATHLOGGER = "TupperBattle/Logger/log.log";
    public static void logearRegistro(String reg) throws IOException {

        System.out.println(reg);
        try {
            FileWriter fw = new FileWriter(PATHLOGGER, true);
            BufferedWriter buffer = new BufferedWriter(fw);
            buffer.write(reg+"\r\n");
            fw.close();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
