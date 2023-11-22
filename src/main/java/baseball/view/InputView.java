package baseball.view;

import static baseball.view.ViewMessage.*;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String askUserNumber() {
        System.out.println(ASK_USER_NUMBER.getMessage());
        return readLine();
    }

    public String askRestart() {
        System.out.println(ASK_RESTART.getMessage());
        return readLine();
    }
}
