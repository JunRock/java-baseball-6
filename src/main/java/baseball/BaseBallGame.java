package baseball;

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
        printMessage.read(); //시작 문구
        //computer
        List<Integer> computer = computers.getComputer(); //컴퓨터 랜덤 숫자 생성

        while (true) {
            //player
            printMessage.inputMessage(); //사용자 숫자 입력 메시지 출력
            String userNumber = printMessage.write(); //사용자 숫자 입력

            if(userNumber.length()>PLAYER_SIZE||userNumber.length()<PLAYER_SIZE) //사용자가 입력한 메시지 예외 처리
                throw new IllegalArgumentException("3자리만 입력해주세요");

            List<Integer> player = asList(userNumber.split("")) //사용자가 중복된 숫자를 입력했는지 확인
                    .stream()
                    .distinct()
                    .map(s -> Integer.parseInt((String) s))
                    .collect(Collectors.toList());

            if(player.size()<PLAYER_SIZE)  //사용자가 동일한 숫자 입력 시 예외 발생
                throw new IllegalArgumentException("중복 문자 입력은 안됩니다");

            int strike = 0;
            int ball = 0;

            for(int i=0;i<player.size();i++){
                int finalI = i;
                if(computer.stream().anyMatch(number -> player.get(finalI)==number)){ //포함 여부
                    if(computer.indexOf(player.get(finalI))== finalI) //동일한 인덱스에 있는지 확인
                        strike++;
                    else ball++;
                }
            }

            if (strike == 3) { //맞힌 경우
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); //게임 성공 메시지 출력
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); //게임 진행여부 메시지 출력
                if(Console.readLine().equals("1")){ //사용자 입력
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
