package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static baseball.domain.ResultType.*;

public class ResultTest {
    Answer answer = new AnswerImpl(List.of(3, 4, 7));

    @Test
    @DisplayName("스트라이크만 있을 때 ONLY_STRIKE 상수를 반환한다.")
    void OnlyStrike() {
        //given
        Integer strike = 2;
        Integer ball = 0;
        ResultType expectResultType = getExpectResultType(strike, ball);
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ResultType.ONLY_STRIKE);
    }

    @Test
    @DisplayName("볼만 있을 때 ONLY_BALL 상수를 반환한다.")
    void OnlyBall() {
        //given
        Integer strike = 0;
        Integer ball = 1;
        ResultType expectResultType = getExpectResultType(strike, ball);
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ResultType.ONLY_BALL);
    }

    @Test
    @DisplayName("볼,스트라이크 둘다 없을 때 NOTHING 상수를 반환한다.")
    void Nothing() {
        //given
        Integer strike = 0;
        Integer ball = 0;
        ResultType expectResultType = getExpectResultType(strike, ball);
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ResultType.NOTHING);
    }

    @Test
    @DisplayName("볼,스트라이크 둘다 있을 때 BOTH_STRIKE_AND_BALL 상수를 반환한다.")
    void StrikeAndBall() {
        //given
        Integer strike = 1;
        Integer ball = 2;
        ResultType expectResultType = getExpectResultType(strike, ball);
        //then
        Assertions.assertThat(expectResultType).isEqualTo(ResultType.BOTH_STRIKE_AND_BALL);
    }

    private ResultType getExpectResultType(Integer strike, Integer ball) {
        Result result = new Result(strike, ball);
        ResultType expectResult = result.decideResultType();
        return expectResult;
    }

    @ParameterizedTest
    @CsvSource(value = {"3:3스트라이크","2:2스트라이크","1:1스트라이크"},delimiter = ':')
    @DisplayName("ONLY_STRIKE일때 n스트라이크입니다.메세지를 띄우기.")
    void OnlyStrikeMessage(int givenStrike,String givenMessage) {
        //given
        ResultType resultType = ResultType.ONLY_STRIKE;
        Integer strike = givenStrike;
        Integer ball = 0;
        //when
        Result result = new Result(strike,ball);
        String resultMessage = result.createResultMessage(resultType);
        //then
        Assertions.assertThat(resultMessage).isEqualTo(givenMessage);
    }
    @ParameterizedTest
    @CsvSource(value = {"3:3볼","2:2볼","1:1볼"},delimiter = ':')
    @DisplayName("ONLY_BALL일때 n볼입니다.메세지를 띄우기.")
    void onlyBallMessage(int givenBall,String givenMessage) {
        //given
        ResultType resultType = ResultType.ONLY_BALL;
        Integer strike = 0;
        Integer ball = givenBall;
        //when
        Result result = new Result(strike,ball);
        String resultMessage = result.createResultMessage(resultType);
        //then
        Assertions.assertThat(resultMessage).isEqualTo(givenMessage);
    }

    @Test
    @DisplayName("NOTHING일때 낫싱 메세지를 띄우기.")
    void nothingMessage() {
        //given
        ResultType resultType = ResultType.NOTHING;
        Integer strike = 0;
        Integer ball = 0;
        //when
        Result result = new Result(strike,ball);
        String resultMessage = result.createResultMessage(resultType);
        //then
        Assertions.assertThat(resultMessage).isEqualTo("낫싱");
    }
    @ParameterizedTest
    @CsvSource(value = {"1:1:1볼 1스트라이크",
            "1:2:1볼 2스트라이크",
            "2:1:2볼 1스트라이크"},delimiter = ':')
    @DisplayName("BOTH_STRIKE_AND_BALL일때 n볼 k스트라이크 입니다.메세지를 띄우기.")
    void strikeAndBallMessage(int givenBall,int givenStrike,String givenMessage) {
        //given
        ResultType resultType = ResultType.BOTH_STRIKE_AND_BALL;
        Integer ball = givenBall;
        Integer strike = givenStrike;
        //when
        Result result = new Result(strike,ball);
        String resultMessage = result.createResultMessage(resultType);
        //then
        Assertions.assertThat(resultMessage).isEqualTo(givenMessage);
    }

}











