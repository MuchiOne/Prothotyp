package Main;

import com.sun.javafx.geom.RoundRectangle2D;

import javax.swing.*;
import java.awt.*;

public class Defi {
    public static int Tickspeed = 25;
    public static int movedistance = 5;
    public static int currentdir = 0;
    public static boolean running = true;
    public static boolean[] Playermove = new boolean[4];
    public static JFrame MainFrame = new JFrame();
    public static Color BackgroundColor = new Color(49, 48, 48);
    public static JLabel Bild1Label = new JLabel();
    public static Point StartPlayerpos = new Point(700, 375);
    public static int PlayerposX = 700;
    public static int PlayerposY = 375;
    public static int HB_size = 150;
    public static RoundRectangle2D HB_NPC;
    public static Rectangle HB_Player;
    public static int NPCposY = 1000;
    public static int NPCposX = 1000;
    public static int Bild1X = 0;
    public static int Bild1Y = 0;
    public static Dir dir = Dir.NoDir;
    public static JPanel pannel1 = new JPanel();
    public static ImageIcon Bild1 = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\OpenworldProthotype\\src\\Main\\Feld.png");
}
