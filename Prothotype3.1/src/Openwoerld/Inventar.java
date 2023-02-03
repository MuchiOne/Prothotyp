package Openwoerld;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Defi.*;

public class Inventar implements ActionListener {
    public Inventar() {
        MinniMenuopen[0] = true;
        if (!PannelGenerated[5]) {
            PannelGenerated[5] = true;

            OWInventarPannel.setBounds(350, 175, 1200, 750);
            OWInventarPannel.setVisible(true);
            OWInventarPannel.setBackground(BackgroundColor);
            OWInventarPannel.setLayout(null);

            Inventar_ExitButton.setBackground(BackgroundColor);
            Inventar_ExitButton.setForeground(StandardForground);
            Inventar_ExitButton.setFont(PausemenuFont);
            Inventar_ExitButton.setText("Exit");
            Inventar_ExitButton.setBounds(0, 0, 145, 75);
            Inventar_ExitButton.setFocusable(false);
            Inventar_ExitButton.setBorderPainted(false);
            Inventar_ExitButton.addActionListener(this);

            OWInventarPannel.add(Inventar_ExitButton);
            OWGuiPannel.add(OWInventarPannel, 1);
        } else {
            OWInventarPannel.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Inventar_ExitButton) {
            OWInventarPannel.setVisible(false);
            new OW_Gui();
        }
    }
}
