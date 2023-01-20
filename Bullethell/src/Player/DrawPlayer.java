package Player;

import javax.swing.*;
import java.awt.*;

import static Main.Defi.*;

public class DrawPlayer extends JLabel {
    public DrawPlayer() {
        switch (dir) {
            case Up:
                Playerpos.y -= MoveDistanz;
                break;
            case Down:
                Playerpos.y += MoveDistanz;
                break;
            case Left:
                Playerpos.x -= MoveDistanz;
                break;
            case Right:
                Playerpos.x += MoveDistanz;
                break;
            case NoDir:
        }
    }

    protected void paintComponent(Graphics g) {
        HBSpieler = new Rectangle(Playerpos.x,Playerpos.y,Playersize-BallanceWert,Playersize-BallanceWert);
        label3.setBounds(Playerpos.x,Playerpos.y,Playersize,Playersize);
        repaint();

    }
}
