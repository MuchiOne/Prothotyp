package Main.TitelCard;

import Main.Keylistener;
import Main.Main;

import javax.swing.*;
import java.awt.*;

import static Main.Defi.*;

public class TitelcardAufrufen {
    public TitelcardAufrufen() {
        MainFrame.setUndecorated(true);
        MainFrame.setVisible(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setTitle("Prototype 3.1");
        MainFrame.setLayout(null);
        MainFrame.setExtendedState(Frame.MAXIMIZED_BOTH);
        MainFrame.setLocationRelativeTo(null);
        new Keylistener();
        Titelcardlabel.setIcon(titelcard);
        DrawTitelcard draw = new DrawTitelcard();
        draw.setVisible(true);
        draw.setBounds(0, 0, 5000, 5000);

        TitelcardPannel.setBounds(0, 0, 5000, 5000);
        TitelcardPannel.setVisible(true);
        TitelcardPannel.setBackground(BackgroundColor);
        TitelcardPannel.setLayout(null);
        TitelcardPannel.add(Titelcardlabel);
        TitelcardPannel.add(draw);

        MainFrame.add(TitelcardPannel);

    }
}
