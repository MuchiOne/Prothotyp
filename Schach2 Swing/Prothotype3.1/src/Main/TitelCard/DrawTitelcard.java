package Main.TitelCard;

import javax.swing.*;
import java.awt.*;

import static Main.Defi.Titelcardlabel;
import static Main.Defi.titelcard;

public class DrawTitelcard extends JLabel {
    protected void paintComponent(Graphics g) {
        Titelcardlabel.setBounds(0, 0, titelcard.getIconWidth(), titelcard.getIconHeight());
        repaint();
    }
}