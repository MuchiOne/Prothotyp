package Main.TitelCard;
import Menus.Hauptmenu;

import static Main.Defi.*;
public class Timerclasse extends Thread {
    public Timerclasse() throws InterruptedException {
        sleep(3500);
        TitelcardPannel.setVisible(false);
        new Hauptmenu();
    }
}
