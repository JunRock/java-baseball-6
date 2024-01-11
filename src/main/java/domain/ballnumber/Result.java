package domain.ballnumber;

import com.sun.nio.sctp.SctpStandardSocketOptions;

import static utils.view.OutputView.*;

public class Result {
    private int strikeCount;
    private int ballCount;
    private final static int STRIKE_COUNT = 3;
    private final static String NOT_EXIST_TYPE="존재하지 않는 타입입니다";

    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String showResult(int strikeCount, int ballCount) {
        if (isFullStrike()) {
            return String.format("%d" + STRIKE,strikeCount);
        }
        if (isNothing()) {
            return String.format(NOTHING);
        }
        if (hasStrikeAndBall()) {
            return String.format("%d" + BALL + " " + "%d" + STRIKE,ballCount,strikeCount) ;
        }
        if (isNoStrike()) {
            return String.format("%d"+BALL,ballCount);
        }
        if (isNoBall()) {
            return String.format("%d"+strikeCount+STRIKE,strikeCount);
        }
        throw new IllegalArgumentException(NOT_EXIST_TYPE);
    }


    public boolean isFullStrike() {
        return strikeCount == STRIKE_COUNT;
    }

    public boolean isNothing() {
        return strikeCount <= 0 && ballCount <= 0;
    }

    public boolean hasStrikeAndBall() {
        return strikeCount >= 0 && ballCount >= 0;
    }

    public boolean isNoStrike() {
        return strikeCount <= 0;
    }

    public boolean isNoBall() {
        return ballCount <= 0;
    }
}
