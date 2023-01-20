package Main;
import static Main.Defi.*;
public class GameClock extends Thread{
    GameClock () throws InterruptedException {
        while (running){
            sleep(Tickspeed);
            new Draw();
            new Colision();
        }
    }
}
