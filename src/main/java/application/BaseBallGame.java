package application;

import camp.nextstep.edu.missionutils.Console;
import computer.Computer;
import player.PrintMessage;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.util.Arrays.asList;

public class BaseBallGame {
    private static final Integer PLAYER_SIZE=3;
    private final Computer computers;
    private final PrintMessage printMessage;
    public BaseBallGame(Computer computer,PrintMessage printMessage) {
        this.computers=computer;
        this.printMessage=printMessage;
    }


    public void run() {
        printMessage.read();
        String userNumber = printMessage.write();
        //computer
        List<Integer> computer = computers.getComputer();

        while (true) {
            //player
            printMessage.inputMessage();


            if(userNumber.length()>PLAYER_SIZE||userNumber.length()<PLAYER_SIZE)
                throw new IllegalArgumentException("3자리만 입력해주세요");

            List<Integer> player = asList(userNumber.split(""))
                    .stream()
                    .distinct()
                    .map(s -> Integer.parseInt((String) s))
                    .collect(Collectors.toList());

            if(player.size()<PLAYER_SIZE)
                throw new IllegalArgumentException("중복 문자 입력은 안됩니다");

            int strike = 0;
            int ball = 0;
            for(int i=0;i<player.size();i++){
                int finalI = i;
                if(computer.stream().anyMatch(number -> player.get(finalI)==number)){ //포함 여부
                    if(computer.indexOf(player.get(finalI))== finalI)
                        strike++;
                    else ball++;
                }
            }

            if (strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if(Console.readLine().equals("1")){
                    computer = computers.getComputer();
                    continue;
                }
                else return;
            }

            if(strike==0&&ball==0)
                System.out.println("낫싱");
            else if (strike == 0)
                System.out.println(ball + "볼");
            else if (ball == 0)
                System.out.println(strike + "스트라이크");
            else if(strike!=0&&ball!=0)
                System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }
}
