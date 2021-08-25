package bowling.exception;

public class InvalidPlayerNameException extends RuntimeException {

    public static final String INVALID_NAME_MESSAGE = "플레이어 이름을 영문으로 3글자로 입력해 주십시오.";

    public InvalidPlayerNameException() {
        this(INVALID_NAME_MESSAGE);
    }

    public InvalidPlayerNameException(String message) {
        super(message);
    }
}
