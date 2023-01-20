package Bullets;


import static Main.Defi.*;

public class BulletMove {
    public BulletMove() {
        switch (currentBullet) {
            case 1:
                if (TargetReached[0]) {
                    if (BulletposX[0]<Spielfeldsize) {
                        Targetpos[0][0] = Spielfeldsize + Bullethight[0];
                        Targetpos[0][1] = Playerpos.y;
                        TargetReached[0]=false;
                    }else{
                        Targetpos[0][0] = -Bullethight[0];
                        Targetpos[0][1] = Playerpos.y;
                        TargetReached[0]=false;
                    }
                }
                if (Targetpos[0][0]>Spielfeldsize) {
                    if (BulletposX[0] < Targetpos[0][0]) {
                        BulletposX[0] += Bulletspeed[0];
                    }else{
                        BulletposY[0] = Playerpos.y;
                        TargetReached[0] = true;
                    }
                }else{
                    if (BulletposX[0] > Targetpos[0][0]) {
                        BulletposX[0] -= Bulletspeed[0];
                    }else{
                        BulletposY[0] = Playerpos.y;
                        TargetReached[0] = true;
                    }

                }
                currentBullet=2;
                break;
            case 2:
                if (TargetReached[1]) {
                    Targetpos[1][0] = Playerpos.x;
                    Targetpos[1][1] = Spielfeldsize + Bullethight[1];
                }
                if (BulletposY[1] < Targetpos[1][1]) {
                    BulletposY[1] += Bulletspeed[1];
                }
                if (BulletposY[1] >= Targetpos[1][1]) {
                    BulletposY[1] = 0;
                    BulletposX[1] = Playerpos.x;
                    TargetReached[1] = true;
                }else{
                    TargetReached[1]=false;
                }
                currentBullet=1;
        }
    }
}
