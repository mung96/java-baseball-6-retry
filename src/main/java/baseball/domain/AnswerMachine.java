package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class AnswerMachine {
    private static final Integer MIN_POSSIBLE_NUMBER = 1;
    private static final Integer MAX_POSSIBLE_NUMBER = 9;
    private static final Integer ANSWER_SIZE = 3;

    public Answer create() {
        List<Integer> computer = choiceRandomNumbers();
        return new AnswerImpl(computer);
    }

    private List<Integer> choiceRandomNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < ANSWER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(MIN_POSSIBLE_NUMBER, MAX_POSSIBLE_NUMBER);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
