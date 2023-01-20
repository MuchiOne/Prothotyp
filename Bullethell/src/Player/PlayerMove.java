package Player;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.Defi.*;
import static Player.Dir.*;

public class PlayerMove implements KeyListener {
    public PlayerMove() {
        MainFrame.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'w') {
            if (Playerpos.y - MoveDistanz > 0) {
                dir = Up;
            } else {
                Playerpos.y = 0;
                dir = NoDir;
            }
        }
        if (e.getKeyChar() == 's') {
            if (Playerpos.y + MoveDistanz + Playersize < Spielfeldsize) {
                dir = Down;
            } else {
                Playerpos.y = Spielfeldsize - Playersize;
                dir = NoDir;
            }
        }
        if (e.getKeyChar() == 'd') {
            if (Playerpos.x + MoveDistanz + Playersize < Spielfeldsize) {
                dir = Right;
            } else {
                Playerpos.x = Spielfeldsize - Playersize;
                dir = NoDir;
            }
        }
        if (e.getKeyChar() == 'a') {
            if (Playerpos.x - MoveDistanz > 0) {
                dir = Left;
            } else {
                Playerpos.x = 0;
                dir = NoDir;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE){
            System.exit(0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
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
    }
}