package Openwoerld;

import static Main.Defi.*;
public class OW_MOVCollision {
    OW_MOVCollision(){
        if (WorldMappos.y>0){
            WorldMappos.y = 0;
        }
        if (WorldMappos.x>0){
            WorldMappos.x = 0;
        }
        if (WorldMappos.x<-BildGrenzeX){
            WorldMappos.x = -BildGrenzeX;
        }
        if (WorldMappos.y< -BildGrenzeY){
            WorldMappos.y = -BildGrenzeY;
        }
        if (OW_Playerpos.y>OW_StartPlayerpos.y&&WorldMappos.y>-1000){
            OW_Playerpos.y=OW_StartPlayerpos.y;
        }else if (OW_Playerpos.y<OW_StartPlayerpos.y&&WorldMappos.y<-1000) {
            OW_Playerpos.y=OW_StartPlayerpos.y;
        }
        if (OW_Playerpos.x>OW_StartPlayerpos.x&&WorldMappos.x>-1000){
            OW_Playerpos.x=OW_StartPlayerpos.x;
        }else if (OW_Playerpos.x<OW_StartPlayerpos.x&&WorldMappos.x<-1000){
            OW_Playerpos.x=OW_StartPlayerpos.x;
        }
        if (OW_Playerpos.x>1855){
            OW_Playerpos.x=1855;
        }
        if (OW_Playerpos.y>978){
            OW_Playerpos.y=978;
        }
        if(OW_Playerpos.x<0){
            OW_Playerpos.x=0;
        }
        if(OW_Playerpos.y<0){
            OW_Playerpos.y=0;
        }
    }
}
