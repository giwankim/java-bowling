package bowling.exception;

public class InvalidFirstBowlException extends RuntimeException {

    public static final String MESSAGE = "처음 투구가 스트라이크가 아니어야 합니다.";

    public InvalidFirstBowlException() {
        this(MESSAGE);
    }

    public InvalidFirstBowlException(String message) {
        super(message);
    }
}
