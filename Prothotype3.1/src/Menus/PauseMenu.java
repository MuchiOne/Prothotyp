package Menus;

import static Main.Defi.*;

public class PauseMenu {
    public PauseMenu(){
        MinniMenuopen[1]=true;
        if (!PannelGenerated[7]) {
            PannelGenerated[7] = true;
            PausemenuPannel.setBounds(350, 175, 1200, 750);
            PausemenuPannel.setVisible(true);
            PausemenuPannel.setBackground(BackgroundColor);
            PausemenuPannel.setLayout(null);

            OWGuiPannel.add(PausemenuPannel,1);
        }else{
            PausemenuPannel.setVisible(true);
        }
    }
}
