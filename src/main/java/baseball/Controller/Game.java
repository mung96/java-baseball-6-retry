package baseball.Controller;

import baseball.domain.*;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {
    private static final String WINNING_CONDITION = "3스트라이크";

    public void noticeStart() {
        OutputView.printStartNotice();
    }

    public void play() {
        AnswerMachine answerMachine = new AnswerMachine();
        Answer answer = answerMachine.create();

        while (true) {
            String result = tryNumberAndShowResult(answer);
            if (result.equals(WINNING_CONDITION)) {
                OutputView.printCorrectMessage();
                break;
            }
        }
    }

    private String tryNumberAndShowResult(Answer answer) {
        List<Integer> tryUserNumbers = tryNumber();
        return showResult(answer, tryUserNumbers);
    }

    private String showResult(Answer answer, List<Integer> tryUserNumbers) {
        Integer strike = answer.countStrike(tryUserNumbers);
        Integer ball = answer.countBall(tryUserNumbers);
        Result result = new Result(strike, ball);
        String resultMessage = result.prepareResultMessage();
        OutputView.printStrikeAndBall(resultMessage);
        return resultMessage;
    }

    private List<Integer> tryNumber() {
        UserNumber userNumber = new UserNumber(InputView.askUserNumber());
        List<Integer> tryUserNumbers = userNumber.getNumbers();
        return tryUserNumbers;
    }
}
