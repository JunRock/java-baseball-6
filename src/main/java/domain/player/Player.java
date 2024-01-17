package domain.player;

import utils.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static config.exception.ErrorStatus.IS_NOT_NUMBER;
import static config.status.Condition.NUMBER_LENGTH;
import static config.status.Message.*;

public class Player {
    public List<Integer> inputNumber() {
        String number = InputView.input();
        validIsNumber(number);
        validIsEmpty(number);
        validLengthOfNumber(number);
        validDuplicateNumber(number);
        return converterInteger(number);
    }

    /**
     * 아무것도 입력하지 않은 경우
     */
    public void validIsEmpty(String number) {
        if (number.isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
    }

    /**
     * 입력한 길이가 부족한 경우
     */
    public void validLengthOfNumber(String number) {
        if (number.length() != NUMBER_LENGTH)
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }

    /**
     * 중복된 숫자를 입력한 경우
     */
    public void validDuplicateNumber(String number) {
        if (isUserNumber(number))
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }

    /**
     * 숫자를 입력하지 않은 경우
     */

    public void validIsNumber(String number) {
        if (!isNumber(number))
            throw new IllegalArgumentException(IS_NOT_NUMBER);
    }

    private boolean isNumber(String number) {
        return number
                .chars()
                .anyMatch(Character::isDigit);
    }

    private boolean isUserNumber(String number) {
        boolean userNumber = getList(number)
                .stream()
                .distinct()
                .count() != number.length();
        return userNumber;
    }

    private List<Integer> converterInteger(String number) {
        return getList(number)
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static Integer restartOption() {
        return Integer.valueOf(InputView.input());
    }

    private List<String> getList(String number) {
        return Arrays.asList(number.split(""));
    }

}
