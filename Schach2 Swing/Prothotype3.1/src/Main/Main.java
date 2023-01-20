package Main;

import Main.TitelCard.Timerclasse;
import Main.TitelCard.TitelcardAufrufen;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        new TitelcardAufrufen();
        Timerclasse timerclasse = new Timerclasse();
        timerclasse.start();
    }
}