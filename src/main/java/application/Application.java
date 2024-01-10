package application;

import baseball.BaseBallGame;
import computer.Computer;
import player.PrintMessage;

public class Application {
    public static void main(String[] args) {
        BaseBallGame baseBallGame=new BaseBallGame(new Computer(),new PrintMessage());
        baseBallGame.run();
    }
}
