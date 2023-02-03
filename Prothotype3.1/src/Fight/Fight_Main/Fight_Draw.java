package Fight.Fight_Main;

import javax.swing.*;
import java.awt.*;
import static Main.Defi.*;

public class Fight_Draw extends JLabel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i <Spielfeldsize ; i++) {
            for (int j = 0; j <Spielfeldsize ; j++) {
                g2d.setColor(Color.white);
                g2d.draw(Spielfeld[i][j]);
                g2d.setColor(new Color(20, 115, 15));
                g2d.fillRect(Spielfeld[i][j].x+1,Spielfeld[i][j].y+1,Spielfeld[i][j].width-1,Spielfeld[i][j].height-1);
            }
        }
        repaint();
    }
}
