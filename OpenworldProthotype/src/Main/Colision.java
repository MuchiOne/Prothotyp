package Main;

import static Main.Defi.*;

public class Colision {
    Colision(){
        if (Bild1Y>0){
            Bild1Y = 0;
        }
        if (Bild1X>0){
            Bild1X = 0;
        }
        if (Bild1X<=-2025){
            Bild1X = -2025;
        }
        if (Bild1Y<= -2195){
            Bild1Y = -2195;
        }
        if (PlayerposY>StartPlayerpos.y&&Bild1Y>-1000){
            PlayerposY=StartPlayerpos.y;
        }else if (PlayerposY<StartPlayerpos.y&&Bild1Y<-1000) {
            PlayerposY=StartPlayerpos.y;
        }
        if (PlayerposX>StartPlayerpos.x&&Bild1X>-1000){
            PlayerposX=StartPlayerpos.x;
        }else if (PlayerposX<StartPlayerpos.x&&Bild1X<-1000){
            PlayerposX=StartPlayerpos.x;
        }
        if (PlayerposX>1375){
            PlayerposX=1375;
        }
        if (PlayerposY>700){
            PlayerposY=700;
        }
        if(PlayerposX<0){
            PlayerposX=0;
        }
        if(PlayerposY<0){
            PlayerposY=0;
        }
    }
}
