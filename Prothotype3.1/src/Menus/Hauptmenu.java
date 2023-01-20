package Menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Main.Defi.*;


public class Hauptmenu implements ActionListener {
    public Hauptmenu() {
        if (!PannelGenerated[0]) {
            PannelGenerated[0]=true;
            HauptmenuPannel.setBounds(0, 0, 5000, 5000);
            HauptmenuPannel.setVisible(true);
            HauptmenuPannel.setBackground(BackgroundColor);
            HauptmenuPannel.setLayout(null);

            HM_ExitButton.setBackground(BackgroundColor);
            HM_ExitButton.setForeground(StandardForground);
            HM_ExitButton.setFont(PausemenuFont);
            HM_ExitButton.setText("Exit");
            HM_ExitButton.setBounds(0, 0, 145, 75);
            HM_ExitButton.setFocusable(false);
            HM_ExitButton.setBorderPainted(false);
            HM_ExitButton.addActionListener(this);

            HM_StartButton.setBackground(BackgroundColor);
            HM_StartButton.setForeground(StandardForground);
            HM_StartButton.setFont(PausemenuFont);
            HM_StartButton.setText("Start");
            HM_StartButton.setBounds(750, 800, 365, 75);
            HM_StartButton.setFocusable(false);
            HM_StartButton.setBorderPainted(false);
            HM_StartButton.addActionListener(this);

            HM_OptionenButton.setBackground(BackgroundColor);
            HM_OptionenButton.setForeground(StandardForground);
            HM_OptionenButton.setFont(PausemenuFont);
            HM_OptionenButton.setText("Optionen");
            HM_OptionenButton.setBounds(750, 900, 365, 75);
            HM_OptionenButton.setFocusable(false);
            HM_OptionenButton.setBorderPainted(false);
            HM_OptionenButton.addActionListener(this);

            HauptmenuPannel.add(HM_ExitButton);
            HauptmenuPannel.add(HM_StartButton);
            HauptmenuPannel.add(HM_OptionenButton);
            MainFrame.add(HauptmenuPannel);
        }else{
            HauptmenuPannel.setVisible(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == HM_ExitButton) {
            System.exit(0);
        }else if(e.getSource()==HM_StartButton){
            new SaveFileSelectMenu();
            HauptmenuPannel.setVisible(false);
        }else if (e.getSource()==HM_OptionenButton){
            new OptionenMenu();
            HauptmenuPannel.setVisible(false);
        }
    }
}
