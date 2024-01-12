package controller;

import domain.ballnumber.CheckNumber;
import domain.ballnumber.Result;
import domain.computer.Computer;
import domain.player.Player;
import utils.view.InputView;
import utils.view.OutputView;

import java.util.List;

import static config.status.Condition.GAMEOVER;
import static config.status.Message.*;
import static domain.player.Player.*;

public class GameController {

    public void start() {
        InputView.inputMessage(START_MESSAGE);
        do {
            Computer computer = new Computer();
            playGame(computer.getComputer());
            InputView.inputMessage(GAMEOVER_MESSAGE);
            InputView.inputMessage(RESTART_GAME);
        } while (!restartOption().equals(GAMEOVER));
    }

    public static void playGame(List<Integer> computers) {
        while (true) {
            Player player = new Player();
            OutputView.outputView(INPUT_MESSAGE);
            List<Integer> players = player.inputNumber();
            CheckNumber checkNumber = new CheckNumber(computers, players);
            Result result = new Result(checkNumber.getStrike(), checkNumber.getBall());
            OutputView.resultView(result.showResult(checkNumber.getStrike(), checkNumber.getBall()));
            if (result.isFullStrike())
                break;
        }
    }
}
