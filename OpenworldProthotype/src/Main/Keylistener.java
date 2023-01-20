package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.Defi.*;
import static Main.Dir.*;

public class Keylistener implements KeyListener {
    Keylistener() {
        MainFrame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (PlayerposY == StartPlayerpos.y) {
            Playermove[0] = false;
            Playermove[1] = false;
        }
        if (PlayerposX == StartPlayerpos.x) {
            Playermove[3] = false;
            Playermove[2] = false;
        }
        if (running) {
            if (e.getKeyChar() == 'w') {
                currentdir=0;
                if (Bild1Y + movedistance >= 0 || Playermove[1]) {
                    if(!Playermove[1]){
                        Bild1Y = 0;
                    }
                    Playermove_W();
                } else {
                    dir = Down;
                }
            }
            if (e.getKeyChar() == 's') {
                currentdir=1;
                if (Bild1Y - movedistance <= -2195 || Playermove[0]) {
                    if(!Playermove[0]){
                        Bild1Y = -2195;
                    }
                    Playermove_S();
                } else {
                    dir = Up;
                }
            }
            if (e.getKeyChar() == 'd') {
                currentdir=2;
                if (Bild1X - movedistance <= -2025||Playermove[3]) {
                    if(!Playermove[3]){
                        Bild1X = -2025;
                    }
                    Playermove_D();
                } else {
                    dir = Left;
                }
            }
            if (e.getKeyChar() == 'a') {
                currentdir=3;
                if (Bild1X + movedistance >= 0||Playermove[2]) {
                    if(!Playermove[2]){
                        Bild1X = 0;
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
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
        if (e.getKeyCode()==KeyEvent.VK_E&& HB_NPC.intersects(HB_Player.x,HB_Player.y,100,100)){
            System.out.println("\uD83D\uDDFF");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (running) {
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
            }else{
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
        Playermove[0]=true;
    }

    public static void Playermove_A() {
        dir = Left;
        Playermove[3]=true;
    }

    public static void Playermove_S() {
        dir = Down;
        Playermove[1]=true;
    }

    public static void Playermove_D() {
        dir = Right;
        Playermove[2]=true;
    }

}
