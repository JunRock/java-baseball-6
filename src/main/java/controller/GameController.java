package controller;

import domain.ballnumber.CheckNumber;
import domain.ballnumber.Result;
import domain.computer.Computer;
import domain.player.Player;
import utils.view.InputView;
import utils.view.OutputView;

import java.util.List;

import static domain.player.Player.*;

public class GameController {
    private final static String START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private final static String GAMEOVER_MESSAGE="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String RESTART_GAME="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final static String INPUT_MESSAGE="숫자를 입력해주세요 :";
    private final Integer GAMEOVER=2;
    public void start(){
        InputView.inputMessage(START_MESSAGE);
        do{
            Computer computer=new Computer();
            playGame(computer.getComputer());
            InputView.inputMessage(GAMEOVER_MESSAGE);
            InputView.inputMessage(RESTART_GAME);
        }while (restartOption()!=GAMEOVER);
    }

    public static void playGame(List<Integer>computers){
        while (true) {
            Player player = new Player();
            OutputView.outputView(INPUT_MESSAGE);
            List<Integer> players = player.inputNumber();
            CheckNumber checkNumber = new CheckNumber(computers, players);
            Result result = new Result(checkNumber.getStrike(), checkNumber.getBall());
            OutputView.resultView(result.showResult(checkNumber.getStrike(), checkNumber.getBall()));
            if(result.isFullStrike())
                break;
        }
    }
}
