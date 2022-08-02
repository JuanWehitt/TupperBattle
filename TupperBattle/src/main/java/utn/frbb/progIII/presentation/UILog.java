package utn.frbb.progIII.presentation;

import javax.swing.*;
import java.awt.*;

public class UILog extends JPanel {

    private JPanel panelLog;
    private JScrollPane scrollPane;

    public void crearPanel(JFrame frame) {
        panelLog = new JPanel();
        panelLog.setLayout(null);

        panelLog.setBounds(frame.getWidth() / 2 - 600 / 2, 180, 600, 400);
        panelLog.setBackground(new Color(110, 133, 201));
        panelLog.setVisible(false);
    }

}
