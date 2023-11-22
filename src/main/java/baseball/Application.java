package baseball;

import baseball.Controller.Game;
import baseball.view.InputView;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();

        game.noticeStart();
        game.play();

        while (isRestart()) {
            game.play();
        }
    }

    private static boolean isRestart() {
        return InputView.askRestart().equals("1");
    }
}
