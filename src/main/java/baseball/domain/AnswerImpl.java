package baseball.domain;

import java.util.List;

public class AnswerImpl implements Answer {
    private final List<Integer> answer;

    public AnswerImpl(List<Integer> answer) {
        this.answer = answer;
    }

    @Override
    public Integer countStrike(List<Integer> userNumbers) {
        int strike = 0;
        int i = 0;
        while (i < answer.size()) {
            if (answer.get(i).equals(userNumbers.get(i))) {
                strike += 1;
            }
            i++;
        }
        return strike;
    }

    @Override
    public Integer countBall(List<Integer> userNumbers) {
        int ball = 0;
        int i = 0;
        while (i < answer.size()) {
            if (answer.contains(userNumbers.get(i)) & !answer.get(i).equals(userNumbers.get(i))) {
                ball += 1;
            }
            i++;
        }
        return ball;
    }
}
