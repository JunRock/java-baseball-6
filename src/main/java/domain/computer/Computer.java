package domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static config.status.Condition.*;

public class Computer {
    public List<Integer> getComputer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < COMPUTER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
