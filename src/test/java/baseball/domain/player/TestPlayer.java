package baseball.domain.player;

import camp.nextstep.edu.missionutils.test.NsTest;
import domain.player.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사용자입력값 유효성 판단")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TestPlayer {
    @ParameterizedTest
    @ValueSource(strings = {"","122","wdw","1234"})
    void 사용자_입력값_유효성_판단(String playerNumber)
    {
        //given
        Player player=new Player();

        //then
        assertThatThrownBy(()->player.validNumber(playerNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
