package Menus;

import static Main.Defi.*;

public class Hauptmenu {
    public Hauptmenu(){
        if (!PannelGenerated[0]) {
            HauptmenuPannel.setBounds(0, 0, 5000, 5000);
            HauptmenuPannel.setVisible(true);
            HauptmenuPannel.setBackground(BackgroundColor);
            HauptmenuPannel.setLayout(null);
            MainFrame.add(HauptmenuPannel);
        }


    }
}
