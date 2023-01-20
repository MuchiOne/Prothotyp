package Main;

import javax.swing.*;
import java.awt.*;

public class Defi {
    //Bullethell

    //Fight

    //Menus
    public static JPanel HauptmenuPannel = new JPanel(); // 0
    public static JPanel OptionenmenuPannel = new JPanel();// 1
    public static JPanel SFSmenuPannel = new JPanel();// 2
    public static JPanel OWGuiPannel = new JPanel();// 3

    public static boolean[] PannelGenerated = new boolean[10];

    public static  JButton HM_StartButton = new JButton();
    public static  JButton HM_OptionenButton = new JButton();
    public static  JButton HM_ExitButton = new JButton();
    public static  JButton Op_ExitButton = new JButton();
    public static  JButton SFS_ExitButton = new JButton();
    public static  JButton SFS_File1Button = new JButton();
    public static  JButton SFS_File2Button = new JButton();
    public static  JButton SFS_File3Button = new JButton();


    public static Font PausemenuFont = new Font("Californian FB", Font.BOLD, 50);
    public static Color StandardForground = new Color(255, 255, 255);

    //Speicher
    public static ImageIcon titelcard = new ImageIcon("C:\\Users\\AdMi\\IdeaProjects\\Prothotype3.1\\src\\Speicher\\Images\\Titelcard.png");

    //Openworld

    //Main
    public static JFrame MainFrame = new JFrame();
    public static JPanel TitelcardPannel = new JPanel();
    public static JLabel Titelcardlabel = new JLabel();
    public static Color BackgroundColor = new Color(49, 48, 48);
}
