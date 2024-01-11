package domain.ballnumber;

import domain.computer.Computer;
import domain.player.Player;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class BaseballNumber { //볼 스트라이크 확인
    private List<Integer> computers;
    private List<Integer>players;
    public BaseballNumber(Computer computer,List<Integer> player) {
        computers=computer.getComputer();
        this.players=player;
    }

    public static void generateNumber(Computer computer, List<Integer> player){
        new BaseballNumber(computer,player);
    }


    public boolean containNumber(int value){  //값을 포함하는지
        return computers.stream()
                .anyMatch(Predicate.isEqual(value));
    }

    public boolean checkSameIndex(int value,int index){ //동일한 인덱스인지
        return computers.indexOf(value)==index;
    }

    public boolean isStrike(int value,int index){
        return containNumber(value) && checkSameIndex(value, index);
    }

    public boolean isBall(int value,int index){
        return containNumber(value)&&!checkSameIndex(value,index);
    }

    public void getStrike(){
        players.stream()
                .filter(o -> isStrike(o, players.indexOf(o)))
                .count();
    }

    public void getBall(){
        players.stream()
                .filter(o-> isBall(o,players.indexOf(o)))
                .count();
    }
}
