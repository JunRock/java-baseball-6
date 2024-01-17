package domain.ballnumber;

import java.util.List;
import java.util.function.Predicate;

public class CheckNumber { //볼 스트라이크 확인
    private List<Integer> computers;
    private List<Integer> players;

    public CheckNumber(List<Integer> computers, List<Integer> player) {
        this.computers = computers;
        this.players = player;
    }

    public int getStrike() { //스트라이크 갯수
        return (int) players.stream()
                .filter(o -> isStrike(o, players.indexOf(o)))
                .count();
    }

    public int getBall() {  //볼 갯수
        return (int) players.stream()
                .filter(o -> isBall(o, players.indexOf(o)))
                .count();
    }

    public boolean containNumber(int value) {  //값을 포함하는지
        return computers.stream()
                .anyMatch(Predicate.isEqual(value));
    }

    public boolean checkSameIndex(int value, int index) { //동일한 인덱스인지
        return computers.indexOf(value) == index;
    }

    public boolean isStrike(int value, int index) {
        return containNumber(value) && checkSameIndex(value, index);
    }

    public boolean isBall(int value, int index) {
        return containNumber(value) && !checkSameIndex(value, index);
    }
}
