package Menus;

import Speicher.SaveFile1.File1Aufrufen;
import Speicher.SaveFile2.File2Aufrufen;
import Speicher.SaveFile3.File3Aufrufen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Defi.*;

public class SaveFileSelectMenu implements ActionListener {
    SaveFileSelectMenu() {
        if (!PannelGenerated[2]) {
            PannelGenerated[2] = true;
            SFSmenuPannel.setBounds(0, 0, 5000, 5000);
            SFSmenuPannel.setVisible(true);
            SFSmenuPannel.setBackground(BackgroundColor);
            SFSmenuPannel.setLayout(null);

            SFS_ExitButton.setBackground(BackgroundColor);
            SFS_ExitButton.setForeground(StandardForground);
            SFS_ExitButton.setFont(PausemenuFont);
            SFS_ExitButton.setText("Exit");
            SFS_ExitButton.setBounds(0, 0, 145, 75);
            SFS_ExitButton.setFocusable(false);
            SFS_ExitButton.setBorderPainted(false);
            SFS_ExitButton.addActionListener(this);

            SFS_File1Button.setBackground(BackgroundColor);
            SFS_File1Button.setForeground(StandardForground);
            SFS_File1Button.setFont(PausemenuFont);
            SFS_File1Button.setText("File 1");
            SFS_File1Button.setBounds(750, 200, 365, 75);
            SFS_File1Button.setFocusable(false);
            SFS_File1Button.setBorderPainted(false);
            SFS_File1Button.addActionListener(this);

            SFS_File2Button.setBackground(BackgroundColor);
            SFS_File2Button.setForeground(StandardForground);
            SFS_File2Button.setFont(PausemenuFont);
            SFS_File2Button.setText("File 2");
            SFS_File2Button.setBounds(750, 500, 365, 75);
            SFS_File2Button.setFocusable(false);
            SFS_File2Button.setBorderPainted(false);
            SFS_File2Button.addActionListener(this);

            SFS_File3Button.setBackground(BackgroundColor);
            SFS_File3Button.setForeground(StandardForground);
            SFS_File3Button.setFont(PausemenuFont);
            SFS_File3Button.setText("File 3");
            SFS_File3Button.setBounds(750, 800, 365, 75);
            SFS_File3Button.setFocusable(false);
            SFS_File3Button.setBorderPainted(false);
            SFS_File3Button.addActionListener(this);

            SFSmenuPannel.add(SFS_ExitButton);
            SFSmenuPannel.add(SFS_File1Button);
            SFSmenuPannel.add(SFS_File2Button);
            SFSmenuPannel.add(SFS_File3Button);

            MainFrame.add(SFSmenuPannel);
        } else {
            SFSmenuPannel.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == SFS_ExitButton) {
            SFSmenuPannel.setVisible(false);
            new Hauptmenu();
        } else if (e.getSource() == SFS_File1Button) {
            SFSmenuPannel.setVisible(false);
            new File1Aufrufen();
        } else if (e.getSource() == SFS_File2Button) {
            SFSmenuPannel.setVisible(false);
            new File2Aufrufen();
        } else if (e.getSource() == SFS_File3Button) {
            SFSmenuPannel.setVisible(false);
            new File3Aufrufen();
        }
    }
}
