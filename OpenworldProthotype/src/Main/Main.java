package Main;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Gui();
        GameClock gameClock= new GameClock();
        gameClock.start();

    }
}