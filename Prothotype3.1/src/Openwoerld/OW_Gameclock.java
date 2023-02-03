package Openwoerld;

import static Main.Defi.*;

public class OW_Gameclock implements Runnable {
    @Override
    public void run() {
        while (InWoerld) {
            try {
                Thread.sleep(Tickspeed_OW);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            new OW_Draw();
            new OW_MOVCollision();
        }
    }
}
