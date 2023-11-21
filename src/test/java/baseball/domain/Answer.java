package baseball.domain;

import java.util.List;

public interface Answer {
    Integer countStrike(List<Integer> userNumbers);
    Integer countBall(List<Integer> userNumbers);
}
