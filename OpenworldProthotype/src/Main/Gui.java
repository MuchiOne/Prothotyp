package Main;

import javax.swing.*;
import java.awt.*;

import static Main.Defi.*;

public class Gui {
    Gui() {
        Bild1Label.setIcon(Bild1);
        new Keylistener();
        Draw draw = new Draw();
        draw.setVisible(true);
        draw.setBounds(0,0,5000,5000);

        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setTitle("Prototype 2.0");
        MainFrame.setLayout(null);
        MainFrame.getContentPane().setBackground(BackgroundColor);
        MainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        MainFrame.setLocationRelativeTo(null);

        pannel1.setBounds(200, 100, 1475, 800);
        pannel1.setVisible(true);
        pannel1.setBackground(Color.white);
        pannel1.setLayout(null);
        pannel1.add(draw);
        pannel1.add(Bild1Label);

        MainFrame.add(pannel1);

    }
}
