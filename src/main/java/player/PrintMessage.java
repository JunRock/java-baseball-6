package player;

import camp.nextstep.edu.missionutils.Console;
import writer.InputNumber;

public class PrintMessage {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final InputNumber inputNumber;

    public void read(){
        System.out.println(START_MESSAGE);
    }

    public void inputMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void startGameMessage(){

    }
}
