package Openwoerld;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import static Main.Defi.*;

public class OW_Draw extends JLabel {
    static boolean ö = false;

    OW_Draw() {
        if (ö) {
            new OW_NPCCollision();
        }
        ö = true;
        if (Playermove[currentdir]) {
            switch (dir) {
                case Up:
                    OW_Playerpos.y -= OW_movedistance;
                    break;
                case Down:
                    OW_Playerpos.y += OW_movedistance;
                    break;
                case Left:
                    OW_Playerpos.x -= OW_movedistance;
                    break;
                case Right:
                    OW_Playerpos.x += OW_movedistance;
                    break;
                case NoDir:
            }
        } else {
            switch (dir) {
                case Up:
                    WorldMappos.y -= OW_movedistance;
                    break;
                case Down:
                    WorldMappos.y += OW_movedistance;
                    break;
                case Left:
                    WorldMappos.x -= OW_movedistance;
                    break;
                case Right:
                    WorldMappos.x += OW_movedistance;
                    break;
                case NoDir:
            }
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        OW_PlayerInteact = new RoundRectangle2D.Double(OW_Playerpos.x - 80, OW_Playerpos.y - 67, 225, 225, 225, 225);
        OW_HB_Enemy1 = new Rectangle(WorldMappos.x + OW_Enemypos.x, WorldMappos.y + OW_Enemypos.y, OW_Enemy1.getIconWidth(), OW_Enemy1.getIconHeight());
        OW_Enemy1label.setBounds(WorldMappos.x + OW_Enemypos.x, WorldMappos.y + OW_Enemypos.y, OW_Enemy1.getIconWidth(), OW_Enemy1.getIconHeight());
        OW_HB_Player = new Rectangle(OW_Playerpos.x, OW_Playerpos.y, OW_Player.getIconWidth(), OW_Player.getIconHeight());
        //g2d.drawLine(WorldMappos.x + (int) OW_HB_Up[2].getX1(), WorldMappos.y + (int) OW_HB_Up[2].getY1(), WorldMappos.x + (int) OW_HB_Up[2].getX2(), WorldMappos.y + (int) OW_HB_Up[2].getY2());
        OW_Playerlabel.setBounds(OW_Playerpos.x, OW_Playerpos.y, OW_Player.getIconWidth(), OW_Player.getIconHeight());
        WorldMapLabel.setBounds(WorldMappos.x, WorldMappos.y, 3500, 3000);
        repaint();
    }
}
