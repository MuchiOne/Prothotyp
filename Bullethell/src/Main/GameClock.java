package Main;

import Bullets.BulletMove;
import Player.DrawPlayer;

import static Main.Defi.*;

public class GameClock extends Thread {
    GameClock() throws InterruptedException {
        sleep(1000);
        while (running) {
            GameTimer++;
            sleep(Tickspeed);
            new CollisionCheck();
            new DrawPlayer();
            new BulletMove();
            System.out.println(GameTimer);
            if (GameTimer==2000){
                System.out.println("You won");
                System.exit(0);
            }
        }
    }
}
