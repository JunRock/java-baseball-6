package baseball.domain.ballnumber;

import domain.ballnumber.CheckNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@DisplayName("입력한 숫자가 들어왔을 때")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestBallNumber {

    @Test
    @BeforeEach
    void 값이_포함되어_있는지_확인()
    {
        //given
        int value=2;
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        boolean ball = checkNumber.containNumber(player.get(0));
        //then
        assertThat(ball).isTrue();
    }
    
    @ParameterizedTest
    @CsvSource(value = {("1,2"),("2,1")})
    void 동일한_인덱스인지_확인(int value,int index)
    {
        //given
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        boolean sameIndex = checkNumber.checkSameIndex(value, index);
        //then
        assertThat(sameIndex).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {("1,2"),("2,1")})
    void 스트라이크인지(int value,int index)
    {
        //given
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        boolean strike = checkNumber.isStrike(value, index);
        //then
        assertThat(strike).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {("4,2"),("2,0")})
    void 볼인지(int value,int index)
    {
        //given
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        boolean ball = checkNumber.isBall(value, index);
        //then
        assertThat(ball).isTrue();
    }

    @Test
    void 몇_개의_스트라이크인지()
    {
        //given
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        int strike = checkNumber.getStrike();
        //then
        assertThat(strike).isEqualTo(2);
    }

    @Test
    void 몇_개의_볼인지()
    {
        //given
        List<Integer> computer= Arrays.asList(1,2,3);
        List<Integer> player=Arrays.asList(3,2,6);
        CheckNumber checkNumber=new CheckNumber(computer,player);
        //when
        int ball = checkNumber.getBall();
        //then
        assertThat(ball).isEqualTo(1);
    }
}
