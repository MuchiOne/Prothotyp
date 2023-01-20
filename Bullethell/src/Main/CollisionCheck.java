package Main;

import static Main.Defi.*;

public class CollisionCheck {
    CollisionCheck() {
        if (HBBall.intersects(Playerpos.x, Playerpos.y, Playersize, Playersize)) {
            System.out.println("Intersect ");
            System.exit(0);
        }
        if (HBLightning.intersects(Playerpos.x, Playerpos.y, Playersize, Playersize)) {
            System.out.println("Intersect ");
            System.exit(0);
        }
        if (Playerpos.y < 0) {
            Playerpos.y = 0;
        }
        if (Playerpos.y + Playersize > Spielfeldsize) {
            Playerpos.y = Spielfeldsize - Playersize;
        }
        if (Playerpos.x + Playersize > Spielfeldsize) {
            Playerpos.x = Spielfeldsize - Playersize;
        }
        if (Playerpos.x < 0) {
            Playerpos.x = 0;
        }
    }
}
