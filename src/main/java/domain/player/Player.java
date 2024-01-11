package domain.player;

import utils.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    private final static String EMPTY_ERROR_MESSAGE="문자를 입력하지 않았습니다";
    private final static String LENGTH_ERROR_MESSAGE="입력한 문자가 3개가 아닙니다";
    private final static String DUPLICATE_ERROR_MESSAGE="중복된 문자를 입력하였습니다";
    private final static int NUMBER_LENGTH=3;

    public List<Integer> inputNumber(){
        String number = InputView.input();
        validIsEmpty(number);
        validLengthOfNumber(number);
        validDuplicateNumber(number);
        return converterInteger(number);
    }

    /**
     * 아무것도 입력하지 않은 경우
     */
    public void validIsEmpty(String number){
        if(number.isEmpty())
            throw new IllegalArgumentException(EMPTY_ERROR_MESSAGE);
    }

    /**
     * 입력한 길이가 부족한 경우
     */
    public void validLengthOfNumber(String number){
        if(number.length()!=NUMBER_LENGTH)
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }

    /**
     * 중복된 숫자를 입력한 경우
     */

    public void validDuplicateNumber(String number){
        if(isUserNumber(number))
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }

    private boolean isUserNumber(String number) {
        boolean userNumber= Arrays.asList(number.split(""))
                .stream()
                .distinct()
                .count()!= number.length();
        return userNumber;
    }

    private List<Integer> converterInteger(String number){
        return Arrays.asList(number.split(""))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    public static Integer restartOption(){
        return Integer.valueOf(InputView.input());
    }
}
