package utn.frbb.progIII.presentation;

import utn.frbb.progIII.Logger.Logger;

import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        UIWindow uiWindow = new UIWindow();
        Logger.logearRegistro("Inicio del Juego");
        uiWindow.crearVentana();
        //UIVentana miventana = new UIVentana();
    }
}
