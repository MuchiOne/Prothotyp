package Main;
import Player.Dir;
import com.sun.javafx.geom.RoundRectangle2D;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Defi {
    public static int Spielfeldsize=800;
    public static int[] Bulletwidth = new int[10];
    public static int[] Bullethight = new int[10];
    public static int MoveDistanz = 17;
    public static int[]Bulletspeed = new int[10];
    public static int[]BulletposX = new int[10];
    public static int[]BulletposY = new int[10];
    public static int[][] Targetpos = new int[10][2];
    public static int BallanceWert=25;
    public static int GameTimer =0;
    public static int Tickspeed =23;
    public static int Playersize = 75;
    public static int currentBullet=1;

    public static boolean running = true;
    public static boolean[] TargetReached = new boolean[10];

    public static RoundRectangle2D HBBall;
    public static Rectangle HBLightning;
    public static Rectangle HBSpieler;
    public static Dir dir=Dir.NoDir;

    public static Point Playerpos=new Point(400-(Playersize/2),400-(Playersize/2));

    public static JFrame MainFrame = new JFrame();

    public static JPanel SpielfeldPannel = new JPanel();
    public static JPanel MainPannel = new JPanel();

    public static JLabel label1 = new JLabel();
    public static JLabel label2 = new JLabel();
    public static JLabel label3 = new JLabel();

    public static ImageIcon Feuerball = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Bullethell\\src\\Bilder\\Feuerball2.png");
    public static ImageIcon Blitz = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Bullethell\\src\\Bilder\\Blitz.png");
    public static ImageIcon Spieler = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Bullethell\\src\\Bilder\\Spieler.png");

    public static Border margin = new LineBorder(new Color(122, 122, 122), 5);
    public static Border border = MainPannel.getBorder();
    public static Color BackgroundColor = new Color(49, 48, 48);


}
