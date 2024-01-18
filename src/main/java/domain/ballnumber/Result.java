package domain.ballnumber;

import static config.exception.ErrorStatus.NOT_EXIST_TYPE;
import static config.status.BaseballCondition.MIN_NUMBER;
import static config.status.BaseballCondition.STRIKE_COUNT;
import static config.status.Message.*;

public class Result {
    private int strikeCount;
    private int ballCount;


    public Result(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }

    public String showResult(int strikeCount, int ballCount) {
        if (isFullStrike()) {
            return String.format("%d" + STRIKE, strikeCount);
        }
        if (isNothing()) {
            return String.format(NOTHING);
        }
        if (hasStrikeAndBall()) {
            return String.format("%d" + BALL + " " + "%d" + STRIKE, ballCount, strikeCount);
        }
        if (isNoStrike()) {
            return String.format("%d" + BALL, ballCount);
        }
        if (isNoBall()) {
            return String.format("%d" + STRIKE, strikeCount);
        }
        throw new IllegalArgumentException(NOT_EXIST_TYPE);
    }


    public boolean isFullStrike() {
        return strikeCount == STRIKE_COUNT;
    }

    public boolean isNothing() {
        return strikeCount <= MIN_NUMBER && ballCount <= MIN_NUMBER;
    }

    public boolean hasStrikeAndBall() {
        return strikeCount >= MIN_NUMBER && ballCount >= MIN_NUMBER;
    }

    public boolean isNoStrike() {
        return strikeCount <= MIN_NUMBER;
    }

    public boolean isNoBall() {
        return ballCount <= MIN_NUMBER;
    }
}
