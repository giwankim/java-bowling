package bowling.exception;

public class InvalidRollException extends RuntimeException {

    public static final String INVALID_PINS_MESSAGE = "볼링 핀의 개수는 1-10의 숫자입니다.";

    public InvalidRollException() {
        this(INVALID_PINS_MESSAGE);
    }

    public InvalidRollException(String message) {
        super(message);
    }
}
