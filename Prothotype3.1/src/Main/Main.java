package Main;
import Main.TitelCard.Timerclasse;
import Main.TitelCard.TitelcardAufrufen;

import java.awt.*;

import static Main.Defi.MainFrame;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image img = toolkit.getImage("src/Speicher/Images/MoyaiCurser.png");
        Point point = new Point(0,0);
        Cursor cursor = toolkit.createCustomCursor(img,point,"Cursor");
        MainFrame.setCursor(cursor);
        new TitelcardAufrufen();
        new Timerclasse();
    }
}