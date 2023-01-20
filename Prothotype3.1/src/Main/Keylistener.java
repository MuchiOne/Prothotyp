package Main;

import Menus.Hilfemenu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static Main.Defi.*;

public class Keylistener implements KeyListener {
    public Keylistener(){
        MainFrame.addKeyListener(this);
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
       if (e.getKeyCode()==KeyEvent.VK_F2){
           System.exit(0);
       }else if (e.getKeyCode()==KeyEvent.VK_F1){
           new Hilfemenu();
        }else if(e.getKeyCode()==KeyEvent.VK_M){
           System.out.println("\uD83D\uDDFF");
       }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
