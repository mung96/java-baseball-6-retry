package baseball.domain;

import java.util.List;

import static baseball.domain.ResultType.*;

public class Result {
    private final Integer strike;
    private final Integer ball;

    Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public ResultType decide() {
        if(strike == 0 & ball==0){
            return NOTHING;
        }
        if (ball == 0) {
            return ONLY_STRIKE;
        }
        if (strike == 0) {
            return ONLY_BALL;
        }
        return null;
    }
}
