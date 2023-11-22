package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static baseball.domain.ResultType.*;

public class ResultTest {
    Answer answer = new AnswerImpl(List.of(3,4,7));

    @Test
    @DisplayName("스트라이크만 있을 때 ONLY_STRIKE 상수를 반환한다.")
    void OnlyStrike(){
        //given
        ResultType expectResultType = getExpectResultType("347");
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ONLY_STRIKE);
    }

    @Test
    @DisplayName("볼만 있을 때 ONLY_BALL 상수를 반환한다.")
    void OnlyBall(){
        //given
        ResultType expectResultType = getExpectResultType("473");
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ONLY_BALL);
    }

    @Test
    @DisplayName("볼,스트라이크 둘다 없을 때 NOTHING 상수를 반환한다.")
    void Nothing(){
        //given
        ResultType expectResultType = getExpectResultType("");
        //thenㄴ
        Assertions.assertThat(expectResultType).isEqualTo(NOTHING);
    }

    private ResultType getExpectResultType(String userInput) {
        UserNumber userNumber = new UserNumber(userInput);
        Result result = new Result(answer,userNumber.getNumbers());
        ResultType expectResult = result.decide();
        return expectResult;
    }
}
