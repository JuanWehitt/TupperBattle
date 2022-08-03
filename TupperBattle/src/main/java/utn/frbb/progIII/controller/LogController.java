package utn.frbb.progIII.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;



public class LogController {
    private final static String ruta = "TupperBattle/Logger/log.log";
    private static FileReader fr;
    private static File f;

    public static String getArchivo(){
        fr = null;
        BufferedReader br = null;
        //Cadena de texto donde se guardara el contenido del archivo
        String contenido = "";
        try
        {
            //ruta puede ser de tipo String o tipo File
            f = new File(ruta);
            fr = new FileReader( f );
            br = new BufferedReader( fr );

            String linea;
            //Obtenemos el contenido del archivo linea por linea
            while( ( linea = br.readLine() ) != null ){
                contenido += linea + "\n";
            }

        }catch( Exception e ){  }
        //finally se utiliza para que si todo ocurre correctamente o si ocurre
        //algun error se cierre el archivo que anteriormente abrimos
        finally
        {
            try{
                br.close();
            }catch( Exception ex ){}
        }
        return contenido;
    }

    public static boolean borrarArchivo() {
        if (f.delete()) {
            System.out.println("El fichero ha sido borrado satisfactoriamente");
            return true;
        }
        else {
            System.out.println("El fichero no puede ser borrado");
            return false;
        }
    }
}
