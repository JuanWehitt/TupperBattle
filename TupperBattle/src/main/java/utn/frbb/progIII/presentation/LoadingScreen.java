package utn.frbb.progIII.presentation;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LoadingScreen {

    public static void cargarLoadingEn(JPanel panel) throws IOException {
        File file = new File("TupperBattle/images//logo.png");
        BufferedImage bufferedImage = ImageIO.read(file);
        ImageIcon imageIcon = new ImageIcon(bufferedImage);
        System.out.println(imageIcon.getImageLoadStatus() + " "+java.awt.MediaTracker.COMPLETE);
        JLabel logoLabel = new JLabel(imageIcon);
        logoLabel.setBounds(250,200,700,250);

        panel.add(logoLabel);
        while (imageIcon.getImageLoadStatus()!=java.awt.MediaTracker.COMPLETE){}
        //System.out.println(imageIcon.getImageLoadStatus());
        JPanel panelTransparencia = new JPanel();
        panelTransparencia.setBounds(250,200,750,250);
        panelTransparencia.setBackground(new Color(255, 0, 0,50));
        //panelTransparencia.setOpaque(false);
        panelTransparencia.setLayout(null);
        panel.add(panelTransparencia);


    }
}
