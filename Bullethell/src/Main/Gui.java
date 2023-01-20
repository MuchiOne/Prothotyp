package Main;

import Bullets.BulletMove;
import Bullets.DrawBullets;
import Player.DrawPlayer;
import Player.PlayerMove;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import static Main.Defi.*;
public class Gui {
    public Gui() {
        BulletposX[0] = 0;
        BulletposY[0] = Playerpos.y;
        BulletposX[1] = Playerpos.x;
        BulletposY[1] = 0;
        Bulletspeed[0] = 25;
        Bulletspeed[1] = 50;
        TargetReached[0] = true;
        TargetReached[1] = true;
        Bulletwidth[0] = 50;
        Bullethight[0] = 50;
        Bulletwidth[1] = 50;
        Bullethight[1] = 100;
        DrawBullets drawBullets = new DrawBullets();
        drawBullets.setVisible(true);
        drawBullets.setBounds(0, 0, Spielfeldsize, Spielfeldsize);
        DrawPlayer drawPlayer = new DrawPlayer();
        drawPlayer.setVisible(true);
        drawPlayer.setBounds(0, 0, Spielfeldsize, Spielfeldsize);
        new PlayerMove();
        MainFrame.setUndecorated(true);
        MainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainFrame.setTitle("Prototype 2.0");
        MainFrame.setLayout(null);
        MainFrame.setVisible(true);
        MainFrame.getContentPane().setBackground(BackgroundColor);
        MainFrame.setBounds(0, 0, Spielfeldsize + 10, Spielfeldsize + 10);
        MainFrame.setLocationRelativeTo(null);

        label1.setIcon(Feuerball);
        label2.setIcon(Blitz);
        label3.setIcon(Spieler);

        SpielfeldPannel.setBounds(5, 5, Spielfeldsize, Spielfeldsize);
        SpielfeldPannel.setVisible(true);
        SpielfeldPannel.setBackground(BackgroundColor);
        SpielfeldPannel.setLayout(null);
        SpielfeldPannel.add(label1);
        SpielfeldPannel.add(label2);
        SpielfeldPannel.add(label3);

        MainPannel.setBounds(0, 0, Spielfeldsize + 10, Spielfeldsize + 10);
        MainPannel.setBackground(BackgroundColor);
        MainPannel.setBorder(new CompoundBorder(border, margin));
        MainPannel.setLayout(null);
        MainPannel.setVisible(true);

        SpielfeldPannel.add(drawBullets);
        SpielfeldPannel.add(drawPlayer);
        MainFrame.add(SpielfeldPannel);
        MainFrame.add(MainPannel);


    }
}
