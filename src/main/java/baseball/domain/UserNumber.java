package baseball.domain;

import baseball.Error.ErrorMessage;

import java.util.List;

public class UserNumber {
    private static final Integer INPUT_SIZE = 3;
    private String inputStr;
    private List<Integer> numbers;

    public List<Integer> getNumbers() {
        return numbers;
    }

    public UserNumber(String beforeInputStr) {
        this.inputStr = deleteBlank(beforeInputStr);
        validate();
        numbers = convertNumbers();
    }

    private String deleteBlank(String beforeInputStr) {
        return beforeInputStr.replace(" ", "");
    }

    private void validate() {
        validateNotNumber();
        validateOverSize();
        validateUnderSize();
        validateErrorNumber();
        validateDuplicateNumber();
    }

    private void validateNotNumber() {
        if (isNotNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INCLUDE_NOT_NUMBER.getMessage());
        }
    }

    private boolean isNotNumber() {
        return !inputStr.chars().allMatch(ch -> Character.isDigit(ch));
    }

    private void validateOverSize() {
        if (inputStr.length() > INPUT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_OVERSIZE.getMessage());
        }
    }

    private void validateUnderSize() {
        if (inputStr.length() < INPUT_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NUMBERS_UNDERSIZE.getMessage());
        }
    }

    private void validateErrorNumber() {
        if (inputStr.contains("0")) {
            throw new IllegalArgumentException(ErrorMessage.INCLUDE_INVALID_NUMBER.getMessage());
        }
    }

    private void validateDuplicateNumber() {
        if (hasDuplicateNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INCLUDE_DUPLICATE_NUMBER.getMessage());
        }
    }

    private boolean hasDuplicateNumber() {
        return inputStr.chars().distinct().count() != inputStr.length();
    }

    private List<Integer> convertNumbers() {
        return inputStr.chars()
                .mapToObj(Character::getNumericValue)
                .toList();
    }
}
