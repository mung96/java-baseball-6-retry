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

    public ResultType decideResultType() {
        if(hasStrike() & hasBall()){
            return BOTH_STRIKE_AND_BALL;
        }
        if (hasStrike()) {
            return ONLY_STRIKE;
        }
        if (hasBall()) {
            return ONLY_BALL;
        }
        if(hasNothing()){
            return NOTHING;
        }
        return null;
    }

    private boolean hasNothing() {
        return strike == 0 & ball == 0;
    }

    private boolean hasBall() {
        return ball != 0;
    }

    private boolean hasStrike() {
        return strike != 0;
    }
}
