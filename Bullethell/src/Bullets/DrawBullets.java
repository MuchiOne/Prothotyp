package Bullets;

import com.sun.javafx.geom.RoundRectangle2D;
import javax.swing.*;
import java.awt.*;

import static Main.Defi.*;

public class DrawBullets extends JLabel {
    protected void paintComponent(Graphics g) {
        HBLightning = new Rectangle(BulletposX[1],BulletposY[1],Bulletwidth[1],Bullethight[1]);
        HBBall = new RoundRectangle2D(BulletposX[0], BulletposY[0], Bulletwidth[0] - BallanceWert, Bullethight [0] - BallanceWert, Bullethight[0], Bulletwidth[0]);
        label1.setBounds(BulletposX[0], BulletposY[0],Bulletwidth[0], Bullethight[0]);
        label2.setBounds(BulletposX[1], BulletposY[1], Bulletwidth[1], Bullethight[1]);
        repaint();

    }
}

