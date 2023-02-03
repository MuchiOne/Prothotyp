package Openwoerld;


import Fight.Fight_Main.FightGui;

import java.awt.geom.Line2D;

import static Main.Defi.*;

public class OW_Gui {
    public OW_Gui() {
        Thread ow_thread = new Thread(new OW_Gameclock());
        InWoerld=true;
        ow_thread.start();
        if (!PannelGenerated[3]) {
            PannelGenerated[3]=true;
            Defenieren();
            OW_Draw ow_draw = new OW_Draw();
            ow_draw.setVisible(true);
            ow_draw.setBounds(0, 0, 5000, 5000);

            OWGuiPannel.setBounds(0, 0, 5000, 5000);
            OWGuiPannel.setVisible(true);
            OWGuiPannel.setBackground(BackgroundColor);
            OWGuiPannel.setLayout(null);
            OWGuiPannel.add(ow_draw,10);
            OWGuiPannel.add(OW_Enemy1label,10);
            OWGuiPannel.add(OW_Playerlabel,10);
            OWGuiPannel.add(WorldMapLabel,10);

            MainFrame.add(OWGuiPannel);
        }else{
            OWGuiPannel.setVisible(true);
        }
    }

    public static void Defenieren() {
        OW_Enemy1label.setIcon(OW_Enemy1);
        WorldMapLabel.setIcon(WorldMap);
        OW_Playerlabel.setIcon(OW_Player);
        OW_PropInteract[0]=new Line2D.Double(2170,2275,2550,2275);//Shop Interact
        OW_HB_Down[0]= new Line2D.Double(1975,2300,2600,2300);
        OW_HB_Right[0]= new Line2D.Double(2600,2100,2600,2300);
        OW_HB_Left[0]=new Line2D.Double(1975,2300,2030,2175);
        OW_HB_Left[1]=new Line2D.Double(2030,2175,2150,2075);
        OW_HB_Up[0]=new Line2D.Double(2150,2075,2600,2100);
        OW_HB_Up[1]=new Line2D.Double(2550,2150,2700,2035);
        OW_HB_Down[1]= new Line2D.Double(2550,2175,2720,2100);
        OW_HB_Down[2]= new Line2D.Double(1025,1200,1425,1500);
        OW_HB_Up[2]= new Line2D.Double(900,1400,1175,1725);


    }
}
