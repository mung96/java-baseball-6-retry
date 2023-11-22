package baseball.view;

public enum ViewMessage {
    ASK_USER_NUMBER("숫자를 입력해주세요 :"),
    ASK_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    START_NOTICE("숫자 야구 게임을 시작합니다.");

    private String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
