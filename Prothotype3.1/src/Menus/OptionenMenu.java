package Menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Defi.*;

public class OptionenMenu implements ActionListener {
    OptionenMenu() {
        if (!PannelGenerated[1]) {
            PannelGenerated[1] = true;
            OptionenmenuPannel.setBounds(0, 0, 5000, 5000);
            OptionenmenuPannel.setVisible(true);
            OptionenmenuPannel.setBackground(BackgroundColor);
            OptionenmenuPannel.setLayout(null);

            Op_ExitButton.setBackground(BackgroundColor);
            Op_ExitButton.setForeground(StandardForground);
            Op_ExitButton.setFont(PausemenuFont);
            Op_ExitButton.setText("Exit");
            Op_ExitButton.setBounds(0, 0, 145, 75);
            Op_ExitButton.setFocusable(false);
            Op_ExitButton.setBorderPainted(false);
            Op_ExitButton.addActionListener(this);

            OptionenmenuPannel.add(Op_ExitButton);
            MainFrame.add(OptionenmenuPannel);
        }else{
            OptionenmenuPannel.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Op_ExitButton) {
            OptionenmenuPannel.setVisible(false);
            new Hauptmenu();
        }
    }
}
