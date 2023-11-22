package baseball.view;

import static baseball.view.ViewMessage.*;

public class OutputView {
    public static void printStartNotice(){
        System.out.println(START_NOTICE.getMessage());
    }

    public static void printStrikeAndBall(String ResultMessage){
        System.out.println(ResultMessage);
    }

    public static void printCorrectMessage(){
        System.out.println(WIN_MESSAGE.getMessage());
    }
}
