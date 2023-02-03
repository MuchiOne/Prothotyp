package Main;

import Openwoerld.Dir;
import Speicher.CFile;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.RoundRectangle2D;

public class Defi {
    //Bullethell

    //Fight
    public static boolean InFight = false;
    public static JPanel Fight_GuiPannel= new JPanel();// 6
    public static JButton Fight_MenuButten= new JButton();

    public static int Spielfeldsize = 9;
    public static int SpielfeldBlocksize =100;
    public static int SpielfeldBlockY =100;
    public static int SpielfeldBlockX =475;
    public static Rectangle[][] Spielfeld = new Rectangle[Spielfeldsize][Spielfeldsize];
    //Menus
    public static JPanel HauptmenuPannel = new JPanel(); // 0
    public static JPanel OptionenmenuPannel = new JPanel();// 1
    public static JPanel SFSmenuPannel = new JPanel();// 2
    public static JPanel PausemenuPannel= new JPanel();// 7

    public static boolean[] PannelGenerated = new boolean[10];
    public static JButton HM_StartButton = new JButton();
    public static JButton HM_OptionenButton = new JButton();
    public static JButton HM_ExitButton = new JButton();
    public static JButton Op_ExitButton = new JButton();
    public static JButton SFS_ExitButton = new JButton();
    public static JButton SFS_File1Button = new JButton();
    public static JButton SFS_File2Button = new JButton();
    public static JButton SFS_File3Button = new JButton();
    public static Font PausemenuFont = new Font("Californian FB", Font.BOLD, 50);
    public static Color StandardForground = new Color(255, 255, 255);

    //Speicher
    public static CFile cFile = CFile.NoFile;
    //Openworld
    public static JLayeredPane OWGuiPannel = new JLayeredPane();// 3
    public static JPanel OWShopPannel = new JPanel();// 4
    public static JPanel OWInventarPannel = new JPanel();// 5/0
    public static JLabel WorldMapLabel = new JLabel();
    public static JLabel OW_Playerlabel = new JLabel();
    public static JLabel OW_Enemy1label = new JLabel();
    public static JButton Shop_ExitButton = new JButton();
    public static JButton Inventar_ExitButton = new JButton();
    public static Rectangle OW_HB_Player;
    public static Rectangle OW_HB_Enemy1;
    public static RoundRectangle2D OW_PlayerInteact;
    public static Line2D[] OW_PropInteract = new Line2D[1];
    public static Line2D[] OW_HB_Up = new Line2D[3];
    public static Line2D[] OW_HB_Down = new Line2D[3];
    public static Line2D[] OW_HB_Left = new Line2D[2];
    public static Line2D[] OW_HB_Right = new Line2D[1];
    public static int Tickspeed_OW = 25;
    public static Dir dir = Dir.NoDir;
    public static boolean[] MinniMenuopen = new boolean[2];
    public static boolean[] Playermove = new boolean[4];
    public static int currentdir;
    public static int OW_movedistance = 25;
    public static int BildGrenzeX = 1575;
    public static int BildGrenzeY = 1920;
    public static Point WorldMappos = new Point(0, 0);
    public static Point OW_Enemypos = new Point(950,1275);
    public static Point OW_Playerpos = new Point(900, 525);
    public static Point OW_StartPlayerpos = new Point(900, 525);
    public static boolean InWoerld = false;
    public static ImageIcon OW_Player = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Prothotype3.1\\src\\Speicher\\Images\\PlayerOW.png");
    public static ImageIcon OW_Enemy1 = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Prothotype3.1\\src\\Speicher\\Images\\Enemy1.png");
    public static ImageIcon WorldMap = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Prothotype3.1\\src\\Speicher\\Images\\WorldMap.png");
    //Main
    public static JFrame MainFrame = new JFrame();
    public static JPanel TitelcardPannel = new JPanel();
    public static JLabel Titelcardlabel = new JLabel();
    public static ImageIcon titelcard = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Prothotype3.1\\src\\Speicher\\Images\\Titelcard.png");
    public static Color BackgroundColor = new Color(49, 48, 48);
}
