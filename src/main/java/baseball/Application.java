package baseball;

import application.BaseBallGame;
import computer.Computer;
import player.PrintMessage;

public class Application {
    public static void main(String[] args) {
        Computer computer=new Computer();
        PrintMessage printMessage=new PrintMessage();
        BaseBallGame baseBallGame=new BaseBallGame(computer,printMessage);
        baseBallGame.run();
    }
}
