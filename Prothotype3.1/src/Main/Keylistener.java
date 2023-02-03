package Main;

import Menus.Hilfemenu;
import Menus.PauseMenu;
import Openwoerld.Inventar;
import Openwoerld.OW_Gui;
import Openwoerld.Shop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.Defi.*;
import static Openwoerld.Dir.*;

public class Keylistener implements KeyListener {
    public Keylistener() {
        MainFrame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (OW_Playerpos.y == OW_StartPlayerpos.y) {
            Playermove[0] = false;
            Playermove[1] = false;
        }
        if (OW_Playerpos.x == OW_StartPlayerpos.x) {
            Playermove[3] = false;
            Playermove[2] = false;
        }
        if (InWoerld) {
            if (e.getKeyChar() == 'w') {
                currentdir = 0;
                if (WorldMappos.y + OW_movedistance >= 0 || Playermove[1]) {
                    if (!Playermove[1]) {
                        WorldMappos.y = 0;
                    }
                    Playermove_W();
                } else {
                    dir = Down;
                }
            }
            if (e.getKeyChar() == 's') {
                currentdir = 1;
                if (WorldMappos.y - OW_movedistance <= -BildGrenzeY || Playermove[0]) {
                    if (!Playermove[0]) {
                        WorldMappos.y = -BildGrenzeY;
                    }
                    Playermove_S();
                } else {
                    dir = Up;
                }
            }
            if (e.getKeyChar() == 'd') {
                currentdir = 2;
                if (WorldMappos.x - OW_movedistance <= -BildGrenzeX || Playermove[3]) {
                    if (!Playermove[3]) {
                        WorldMappos.x = -BildGrenzeX;
                    }
                    Playermove_D();
                } else {
                    dir = Left;
                }
            }
            if (e.getKeyChar() == 'a') {
                currentdir = 3;
                if (WorldMappos.x + OW_movedistance >= 0 || Playermove[2]) {
                    if (!Playermove[2]) {
                        WorldMappos.x = 0;
                    }
                    Playermove_A();
                } else {
                    dir = Right;
                }
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F2) {
            if (InFight) {
                Fight_GuiPannel.setVisible(false);
                WorldMappos.x = 0;
                WorldMappos.y = 0;
                dir = NoDir;
                InFight = false;
                new OW_Gui();
            } else {
                System.exit(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_F1) {
            new Hilfemenu();
        } else if (e.getKeyCode() == KeyEvent.VK_M) {
            System.out.println("\uD83D\uDDFF");
        } else if (e.getKeyCode() == KeyEvent.VK_I &&
                OW_PlayerInteact.getBounds2D().intersectsLine(WorldMappos.x + (int) OW_PropInteract[0].getX1(), WorldMappos.y + (int) OW_PropInteract[0].getY1(), WorldMappos.x + (int) OW_PropInteract[0].getX2(), WorldMappos.y + (int) OW_PropInteract[0].getY2())) {
            new Shop();
            InWoerld = false;
        } else if (e.getKeyCode() == KeyEvent.VK_E) {
            if(!MinniMenuopen[1]) {
                if (!MinniMenuopen[0]) {
                    new Inventar();
                    InWoerld = false;
                } else {
                    OWInventarPannel.setVisible(false);
                    MinniMenuopen[0] = false;
                    new OW_Gui();
                }
            }
        } else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            if (!MinniMenuopen[0]) {
                if (!MinniMenuopen[1]) {
                    new PauseMenu();
                    InWoerld = false;
                } else {
                    PausemenuPannel.setVisible(false);
                    MinniMenuopen[1] = false;
                    new OW_Gui();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (InWoerld) {
            if (Playermove[currentdir]) {
                switch (dir) {
                    case Right:
                        if (e.getKeyChar() == 'd') {
                            dir = NoDir;
                        }
                        break;
                    case Left:
                        if (e.getKeyChar() == 'a') {
                            dir = NoDir;
                        }
                        break;
                    case Down:
                        if (e.getKeyChar() == 's') {
                            dir = NoDir;
                        }
                        break;
                    case Up:
                        if (e.getKeyChar() == 'w') {
                            dir = NoDir;
                        }
                }
            } else {
                switch (dir) {
                    case Left:
                        if (e.getKeyChar() == 'd') {
                            dir = NoDir;
                        }
                        break;
                    case Right:
                        if (e.getKeyChar() == 'a') {
                            dir = NoDir;
                        }
                        break;
                    case Up:
                        if (e.getKeyChar() == 's') {
                            dir = NoDir;
                        }
                        break;
                    case Down:
                        if (e.getKeyChar() == 'w') {
                            dir = NoDir;
                        }
                }
            }
        }
    }

    public static void Playermove_W() {
        dir = Up;
        Playermove[0] = true;
    }

    public static void Playermove_A() {
        dir = Left;
        Playermove[3] = true;
    }

    public static void Playermove_S() {
        dir = Down;
        Playermove[1] = true;
    }

    public static void Playermove_D() {
        dir = Right;
        Playermove[2] = true;
    }
}
