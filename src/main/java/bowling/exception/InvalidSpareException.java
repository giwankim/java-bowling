package bowling.exception;

public class InvalidSpareException extends RuntimeException {

    public static final String INVALID_SPARE_MESSAGE = "핀들의 합이 스페어가 아닙니다.";

    public InvalidSpareException() {
        this(INVALID_SPARE_MESSAGE);
    }

    public InvalidSpareException(String message) {
        super(message);
    }
}
