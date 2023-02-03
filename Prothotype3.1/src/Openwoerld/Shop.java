package Openwoerld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Defi.*;

public class Shop implements ActionListener {
    public Shop() {
        if (!PannelGenerated[4]) {
            PannelGenerated[4] = true;
            OWShopPannel.setBounds(350, 175, 1200, 750);
            OWShopPannel.setVisible(true);
            OWShopPannel.setBackground(BackgroundColor);
            OWShopPannel.setLayout(null);

            Shop_ExitButton.setBackground(BackgroundColor);
            Shop_ExitButton.setForeground(StandardForground);
            Shop_ExitButton.setFont(PausemenuFont);
            Shop_ExitButton.setText("Exit");
            Shop_ExitButton.setBounds(0, 0, 145, 75);
            Shop_ExitButton.setFocusable(false);
            Shop_ExitButton.setBorderPainted(false);
            Shop_ExitButton.addActionListener(this);

            OWShopPannel.add(Shop_ExitButton);

            OWGuiPannel.add(OWShopPannel,1);
        } else {
            OWShopPannel.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Shop_ExitButton){
            OWShopPannel.setVisible(false);
            new OW_Gui();
        }
    }
}
