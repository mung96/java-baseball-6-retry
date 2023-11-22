package baseball.view;

import static baseball.view.ViewMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String askUserNumber() {
        System.out.print(ASK_USER_NUMBER.getMessage());
        return readLine();
    }

    public static String askRestart() {
        System.out.println(ASK_RESTART.getMessage());
        return readLine();
    }
}
