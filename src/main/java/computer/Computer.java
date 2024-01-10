package computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final Integer MIN_NUM = 1;
    private static final Integer MAX_NUM = 9;
    private static final Integer COMPUTER_SIZE = 3;
    public List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        System.out.print("com: ");
        while (computer.size() < COMPUTER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
                System.out.print(randomNumber);
            }
        }
        return computer;
    }
}
