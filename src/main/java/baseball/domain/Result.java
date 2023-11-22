package baseball.domain;

import static baseball.domain.ResultType.*;
import static java.lang.String.*;

public class Result {
    private final Integer strike;
    private final Integer ball;

    public Result(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public ResultType decideResultType() {
        if (hasStrike() & hasBall()) {
            return BOTH_STRIKE_AND_BALL;
        }
        if (hasStrike()) {
            return ONLY_STRIKE;
        }
        if (hasBall()) {
            return ONLY_BALL;
        }
        if (hasNothing()) {
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

    public String createResultMessage(ResultType resultType) {
        if (resultType == ONLY_STRIKE) {
            return format(ONLY_STRIKE.getMessage(), strike);
        }
        if (resultType == ONLY_BALL) {
            return format(ONLY_BALL.getMessage(), ball);
        }
        if (resultType == NOTHING) {
            return format(NOTHING.getMessage());
        }
        if (resultType == BOTH_STRIKE_AND_BALL) {
            return format(BOTH_STRIKE_AND_BALL.getMessage(), ball, strike);
        }
        return null;
    }

    public String prepareResultMessage(){
        ResultType resultType = decideResultType();
        return createResultMessage(resultType);
    }
}
