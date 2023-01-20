package  Main;

import Player.PlayerMove;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Gui gui = new Gui();
        GameClock gameClock = new GameClock();
        PlayerMove playerMove = new PlayerMove();
        gameClock.start();
    }
}