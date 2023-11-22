package baseball.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AnswerImplTest {

    AnswerImpl answer = new AnswerImpl(List.of(3, 4, 7));

    @Test
    @DisplayName("위치와 숫자가 모두 맞으면 스트라이크수를 3개 반환한다.")
    void count_3_Strike() {
        Integer expectStrike = 3;
        assertCountStrike(List.of(3, 4, 7), expectStrike);
    }

    @Test
    @DisplayName("위치와 숫자가 2개만 맞으면 스트라이크수를 2개 반환한다.")
    void count_2_Strike() {
        Integer expectStrike = 2;
        assertCountStrike(List.of(3, 9, 7), expectStrike);
        assertCountStrike(List.of(3, 4, 1), expectStrike);
        assertCountStrike(List.of(6, 4, 7), expectStrike);
    }

    @Test
    @DisplayName("위치와 숫자가 1개만 맞으면 스트라이크수를 1개 반환한다.")
    void count_1_Strike() {
        Integer expectStrike = 1;
        assertCountStrike(List.of(3, 9, 4), expectStrike);
        assertCountStrike(List.of(7, 4, 1), expectStrike);
        assertCountStrike(List.of(9, 2, 7), expectStrike);
    }

    @Test
    @DisplayName("위치까지 맞는게 없다면 스트라이크수를 0개 반환한다.")
    void count_0_Strike() {
        Integer expectStrike = 0;
        assertCountStrike(List.of(1, 9, 4), expectStrike);
    }

    private void assertCountStrike(List<Integer> userNumbers, Integer expectStrike) {
        Integer resultStrike = answer.countStrike(userNumbers);
        Assertions.assertThat(resultStrike).isEqualTo(expectStrike);
    }

    @Test
    @DisplayName("숫자는 3개 맞지만 위치가 맞는게 없다면 볼을 3개 반환한다.")
    void count_3_ball() {
        Integer expectBall = 3;
        assertCountBall(List.of(4, 7, 3), expectBall);
        assertCountBall(List.of(7, 3, 4), expectBall);
    }
    @Test
    @DisplayName("숫자는 2개 맞지만 위치가 맞는게 없다면 볼을 2개 반환한다.")
    void count_2_ball() {
        Integer expectBall = 2;
        assertCountBall(List.of(1, 3, 4), expectBall);
        assertCountBall(List.of(8, 7, 4), expectBall);
        assertCountBall(List.of(7, 3, 9), expectBall);
    }

    @Test
    @DisplayName("숫자는 1개 맞지만 위치가 맞는게 없다면 볼을 1개 반환한다.")
    void count_1_ball() {
        Integer expectBall = 1;
        assertCountBall(List.of(1, 3, 2), expectBall);
        assertCountBall(List.of(5, 9, 4), expectBall);
        assertCountBall(List.of(8, 7, 2), expectBall);
    }

    @Test
    @DisplayName("숫자,위치 맞는게 없다면 볼을 0개 반환한다.")
    void count_0_ball() {
        Integer expectBall = 1;
        assertCountBall(List.of(1, 3, 2), expectBall);
        assertCountBall(List.of(5, 9, 4), expectBall);
        assertCountBall(List.of(8, 7, 2), expectBall);
    }

    private void assertCountBall(List<Integer> userNumbers, Integer expectBall) {
        Integer resultBall = answer.countBall(userNumbers);
        Assertions.assertThat(resultBall).isEqualTo(expectBall);
    }
}




