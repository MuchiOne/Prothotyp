package Main.TitelCard;
import Menus.Hauptmenu;

import static Main.Defi.*;
public class Timerclasse extends Thread {
    public Timerclasse() throws InterruptedException {
        sleep(0);
        new Hauptmenu();
        TitelcardPannel.setVisible(false);
    }
}
