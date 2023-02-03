package Fight.Fight_Main;

import Main.mouslistener;
import Openwoerld.OW_Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import static Main.Defi.*;

public class FightGui implements ActionListener {
    public FightGui() {
        if (!InFight) {
            InFight = true;
        }
        if (!PannelGenerated[6]) {
            new mouslistener();
            Defenieren();
            PannelGenerated[6] = true;
            Fight_Draw fight_draw = new Fight_Draw();
            fight_draw.setVisible(true);
            fight_draw.setBounds(0, 0, 5000, 5000);

            Fight_GuiPannel.setBounds(0, 0, 5000, 5000);
            Fight_GuiPannel.setVisible(true);
            Fight_GuiPannel.setBackground(BackgroundColor);
            Fight_GuiPannel.setLayout(null);
            Fight_GuiPannel.add(fight_draw);

            Fight_MenuButten.setBackground(BackgroundColor);
            Fight_MenuButten.setForeground(StandardForground);
            Fight_MenuButten.setFont(PausemenuFont);
            Fight_MenuButten.setText("Menu");
            Fight_MenuButten.setBounds(0, 0, 145, 75);
            Fight_MenuButten.setFocusable(false);
            Fight_MenuButten.setBorderPainted(false);
            Fight_MenuButten.addActionListener(this);

            MainFrame.add(Fight_GuiPannel);
            new OW_Gui();
        } else {
            Fight_GuiPannel.setVisible(true);
        }
    }

    public static void Defenieren() {
        for (int i = 0; i < Spielfeldsize; i++) {
            for (int j = 0; j < Spielfeldsize; j++) {
            Spielfeld[i][j]=new Rectangle(SpielfeldBlockX,SpielfeldBlockY,SpielfeldBlocksize,SpielfeldBlocksize);
            SpielfeldBlockY+=SpielfeldBlocksize;
            }
            SpielfeldBlockX+=SpielfeldBlocksize;
            SpielfeldBlockY=100;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Fight_MenuButten){
            System.out.println("Menu");
        }
    }
}
