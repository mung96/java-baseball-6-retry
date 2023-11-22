package baseball.domain;

public enum ResultType {
    ONLY_STRIKE("%d스트라이크"),
    ONLY_BALL("%d볼"),
    NOTHING("낫싱"),
    BOTH_STRIKE_AND_BALL("%d볼 %d스트라이크");

    private String message;

    ResultType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
