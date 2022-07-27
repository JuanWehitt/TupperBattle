package utn.frbb.progIII.presentation;

import utn.frbb.progIII.Logger.Logger;

import javax.swing.*;
import java.io.IOException;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        UIMenu uiMenu = new UIMenu();
        Logger.logearRegistro("Inicio del Juego");
        JFrame frame = uiMenu.crearVentana();
        UIPartida partida = new UIPartida();
        //UIVentana miventana = new UIVentana();
        frame.repaint();
    }
}
