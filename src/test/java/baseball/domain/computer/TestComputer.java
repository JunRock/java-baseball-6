package baseball.domain.computer;

import domain.computer.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("캄퓨터 랜덤 상수 체크")
public class TestComputer {
    @Test
    public void 컴퓨터_랜덤_상수_생성() throws Exception
    {
        //given
        Computer computer = new Computer();
        List<Integer> computers = computer.getComputer();
        //when
        int size = computers.size();
        //then
        assertThat(size).isEqualTo(3);
    }
}
