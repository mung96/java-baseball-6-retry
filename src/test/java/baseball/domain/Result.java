package baseball.domain;

import java.util.List;

import static baseball.domain.ResultType.*;

public class Result {
    private final Integer strike;
    private final Integer ball;

    Result(Answer answer, List<Integer> userNumber) {
        this.strike = answer.countStrike(userNumber);
        this.ball = answer.countBall(userNumber);
    }

    public ResultType decide() {
        if (ball == 0) {
            return ONLY_STRIKE;
        }
        if (strike == 0) {
            return ONLY_BALL;
        }
        return null;
    }
}
