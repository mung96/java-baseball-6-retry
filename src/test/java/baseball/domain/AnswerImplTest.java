package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class AnswerTest {

    Answer answer = new Answer(List.of(3,4,7));
    @Test
    @DisplayName("위치와 숫자가 모두 맞으면 스트라이크수를 3개로 반환한다.")
    void countStrike(Integer userNumber, Integer expectStrike){
        Integer resultStrike = answer.countStrike(userNumber);
        //then
        Assertions.assertThat(resultStrike).isEqualTo(expectStrike);
    }
}
