package Openwoerld;

import Fight.Fight_Main.FightGui;

import static Main.Defi.*;

public class OW_NPCCollision {
    public OW_NPCCollision() {
        //Down
        for (int i = 0; i < OW_HB_Down.length; i++) {
            if (OW_HB_Player.intersectsLine(WorldMappos.x + (int) OW_HB_Down[i].getX1(), WorldMappos.y + (int) OW_HB_Down[i].getY1(), WorldMappos.x + (int) OW_HB_Down[i].getX2(), WorldMappos.y + (int) OW_HB_Down[i].getY2())) {
                if (Playermove[0] || Playermove[1]) {
                } else {
                    WorldMappos.y -= OW_movedistance;
                }
            }
        }
        //Right
        if (OW_HB_Player.intersectsLine(WorldMappos.x + (int) OW_HB_Right[0].getX1(), WorldMappos.y + (int) OW_HB_Right[0].getY1(), WorldMappos.x + (int) OW_HB_Right[0].getX2(), WorldMappos.y + (int) OW_HB_Right[0].getY2())) {
            if (Playermove[2] || Playermove[3]) {
                OW_Playerpos.x += OW_movedistance;
            } else {
                WorldMappos.x += OW_movedistance;
            }
        }
        //Left
        for (int i = 0; i < OW_HB_Left.length; i++) {
            if (OW_HB_Player.intersectsLine(WorldMappos.x + (int) OW_HB_Left[i].getX1(), WorldMappos.y + (int) OW_HB_Left[i].getY1(), WorldMappos.x + (int) OW_HB_Left[i].getX2(), WorldMappos.y + (int) OW_HB_Left[i].getY2())) {
                if (Playermove[2] || Playermove[3]) {
                    OW_Playerpos.x += OW_movedistance;
                } else {
                    WorldMappos.x += OW_movedistance;
                }
            }
        }
        //Up
        for (int i = 0; i < OW_HB_Up.length; i++) {
            if (OW_HB_Player.intersectsLine(WorldMappos.x + (int) OW_HB_Up[i].getX1(), WorldMappos.y + (int) OW_HB_Up[i].getY1(), WorldMappos.x + (int) OW_HB_Up[i].getX2(), WorldMappos.y + (int) OW_HB_Up[i].getY2())) {
                if (Playermove[0] || Playermove[1]) {
                    OW_Playerpos.y += OW_movedistance;
                } else {
                    WorldMappos.y += OW_movedistance;
                }
            }
            if (OW_HB_Player.intersects(WorldMappos.x + OW_Enemypos.x, WorldMappos.y + OW_Enemypos.y,OW_Enemy1.getIconWidth(),OW_Enemy1.getIconHeight())){
                OWGuiPannel.setVisible(false);
                InWoerld = false;
                new FightGui();
            }
        }
    }
}
