package Main;

import com.sun.javafx.geom.RoundRectangle2D;

import javax.swing.*;
import java.awt.*;

import static Main.Defi.*;

public class Draw extends JLabel {
    Draw() {
        if (Playermove[currentdir]) {
            switch (dir) {
                case Up:
                    PlayerposY -= movedistance;
                    break;
                case Down:
                    PlayerposY += movedistance;
                    break;
                case Left:
                    PlayerposX -= movedistance;
                    break;
                case Right:
                    PlayerposX += movedistance;
                    break;
                case NoDir:
            }
        } else {
            switch (dir) {
                case Up:
                    Bild1Y -= movedistance;
                    NPCposY -=movedistance;
                    break;
                case Down:
                    Bild1Y += movedistance;
                    NPCposY +=movedistance;
                    break;
                case Left:
                    Bild1X -= movedistance;
                    NPCposX -=movedistance;
                    break;
                case Right:
                    Bild1X += movedistance;
                    NPCposX +=movedistance;
                    break;
                case NoDir:
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        HB_NPC = new RoundRectangle2D(NPCposX-HB_size,NPCposY-HB_size,100+HB_size*2,100+HB_size*2,100+HB_size*2,100+HB_size*2);
        HB_Player = new Rectangle(PlayerposX, PlayerposY, 100, 100);
        g2d.setColor(Color.white);
        g2d.fillRect(PlayerposX, PlayerposY, 100, 100);
        g2d.drawRoundRect(NPCposX-HB_size,NPCposY-HB_size,100+HB_size*2,100+HB_size*2,100+HB_size*2,100+HB_size*2);
        g2d.setColor(Color.BLUE);
        g2d.fillRoundRect(NPCposX,NPCposY,100,100,100,100);
        Bild1Label.setBounds(Bild1X, Bild1Y, 3500, 3000);
        repaint();

    }
}
