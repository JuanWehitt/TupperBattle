package utn.frbb.progIII.presentation;

import utn.frbb.progIII.Logger.Logger;

import javax.swing.*;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        UIApp uiApp = new UIApp();
        JFrame frame = uiApp.crearVentana();
        frame.repaint();
    }
}
